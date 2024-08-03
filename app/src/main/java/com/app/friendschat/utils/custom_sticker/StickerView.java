package com.app.friendschat.utils.custom_sticker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.app.friendschat.R;

public class StickerView extends FrameLayout {

    private final boolean showIcons;
    private final boolean showBorder;
    private final boolean bringToFrontCurrentSticker;

    @IntDef({
            ActionMode.NONE, ActionMode.DRAG, ActionMode.ZOOM_WITH_TWO_FINGER, ActionMode.ICON,
            ActionMode.CLICK
    })
    @Retention(RetentionPolicy.SOURCE)
    protected @interface ActionMode {
        int NONE = 0;
        int DRAG = 1;
        int ZOOM_WITH_TWO_FINGER = 2;
        int ICON = 3;
        int CLICK = 4;
    }

    @IntDef(flag = true, value = {FLIP_HORIZONTALLY, FLIP_VERTICALLY})
    @Retention(RetentionPolicy.SOURCE)
    protected @interface Flip {
    }

    private static final String TAG = "StickerView";

    private static final int DEFAULT_MIN_CLICK_DELAY_TIME = 200;

    public static final int FLIP_HORIZONTALLY = 1;
    public static final int FLIP_VERTICALLY = 1 << 1;

    private final List<com.app.friendschat.utils.custom_sticker.Sticker> stickers = new ArrayList<>();
    private final List<BitmapStickerIcon> icons = new ArrayList<>(4);

    //undo
    private List<List<com.app.friendschat.utils.custom_sticker.Sticker>> undoList = new ArrayList<>();
    private List<com.app.friendschat.utils.custom_sticker.Sticker> listUndoTemp = new ArrayList<>();

    private final Paint borderPaint = new Paint();
    private final RectF stickerRect = new RectF();

    private final Matrix sizeMatrix = new Matrix();
    private final Matrix downMatrix = new Matrix();
    private final Matrix moveMatrix = new Matrix();

    // region storing variables
    private final float[] bitmapPoints = new float[8];
    private final float[] bounds = new float[8];
    private final float[] point = new float[2];
    private final PointF currentCenterPoint = new PointF();
    private final float[] tmp = new float[2];
    private PointF midPoint = new PointF();
    // endregion
    private final int touchSlop;

    private BitmapStickerIcon currentIcon;
    //the first point down position
    private float downX;
    private float downY;

    private float oldDistance = 0f;
    private float oldRotation = 0f;

    @ActionMode
    private int currentMode = ActionMode.NONE;

    private com.app.friendschat.utils.custom_sticker.Sticker handlingSticker;

    private boolean locked;
    private boolean constrained;

    private OnStickerOperationListener onStickerOperationListener;

    private long lastClickTime = 0;
    private int minClickDelayTime = DEFAULT_MIN_CLICK_DELAY_TIME;

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray a = null;
        try {
            a = context.obtainStyledAttributes(attrs, R.styleable.StickerView);
            showIcons = a.getBoolean(R.styleable.StickerView_showIcons, false);
            showBorder = a.getBoolean(R.styleable.StickerView_showBorder, false);
            bringToFrontCurrentSticker =
                    a.getBoolean(R.styleable.StickerView_bringToFrontCurrentSticker, false);

            // borderPaint - line bao quanh sticker
            borderPaint.setAntiAlias(true);
            borderPaint.setColor(a.getColor(R.styleable.StickerView_borderColor, Color.WHITE));
            borderPaint.setAlpha(a.getInteger(R.styleable.StickerView_borderAlpha, 128));
            borderPaint.setStrokeWidth(5.0f);
            borderPaint.setPathEffect(new DashPathEffect(new float[]{28, 10}, 0));

            configDefaultIcons();
        } finally {
            if (a != null) {
                a.recycle();
            }
        }
    }

    public void configDefaultIcons() {
        BitmapStickerIcon deleteIcon = new BitmapStickerIcon(
                ContextCompat.getDrawable(getContext(), R.drawable.ic_close_emoji),
                BitmapStickerIcon.RIGHT_TOP);
        deleteIcon.setIconEvent(new DeleteIconEvent());

        BitmapStickerIcon copyIcon = new BitmapStickerIcon(
                ContextCompat.getDrawable(getContext(), R.drawable.ic_copy_emoji2),
                BitmapStickerIcon.LEFT_TOP);
        copyIcon.setIconEvent(new CopyIconEvent(getContext()));
        BitmapStickerIcon zoomIcon = new BitmapStickerIcon(
                ContextCompat.getDrawable(getContext(), R.drawable.ic_scale_and_rotate2),
                BitmapStickerIcon.RIGHT_BOTOM);
        zoomIcon.setIconEvent(new ZoomIconEvent());
//    BitmapStickerIcon flipIcon = new BitmapStickerIcon(
//            ContextCompat.getDrawable(getContext(), R.drawable.ic_flip),
//            BitmapStickerIcon.RIGHT_TOP);
//    flipIcon.setIconEvent(new FlipHorizontallyEvent());

        icons.clear();
        icons.add(deleteIcon);
        icons.add(copyIcon);
        icons.add(zoomIcon);
//    icons.add(flipIcon);
    }

    /**
     * Swaps sticker at layer [[oldPos]] with the one at layer [[newPos]].
     * Does nothing if either of the specified layers doesn't exist.
     */
    public void swapLayers(int oldPos, int newPos) {
        if (stickers.size() >= oldPos && stickers.size() >= newPos) {
            Collections.swap(stickers, oldPos, newPos);

            //save undo khi swap xong
            saveStickerState();
            Log.d("showSwapLayer", "oldPos= " + oldPos + ", newPos= " + newPos);
            invalidate();
        }
    }

    public void hideOrShowSticker(com.app.friendschat.utils.custom_sticker.Sticker sticker, int pos) {
        if (stickers.size() > 0) {
            sticker.setHide(!sticker.isHide());
            //
            saveStickerState();
            invalidate();
        }
    }

    /**
     * Sends sticker from layer [[oldPos]] to layer [[newPos]].
     * Does nothing if either of the specified layers doesn't exist.
     */
    public void sendToLayer(int oldPos, int newPos) {
        if (stickers.size() >= oldPos && stickers.size() >= newPos) {
            com.app.friendschat.utils.custom_sticker.Sticker s = stickers.get(oldPos);
            stickers.remove(oldPos);
            stickers.add(newPos, s);
            invalidate();
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            stickerRect.left = left;
            stickerRect.top = top;
            stickerRect.right = right;
            stickerRect.bottom = bottom;
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawStickers(canvas);
    }

    protected void drawStickers(Canvas canvas) {
        for (int i = 0; i < stickers.size(); i++) {
            com.app.friendschat.utils.custom_sticker.Sticker sticker = stickers.get(i);
            if (sticker != null) {
                if (!sticker.isHide()) {
                    sticker.draw(canvas);
                }
            }
        }

        if (handlingSticker != null && !locked && (showBorder || showIcons)) {
            getStickerPoints(handlingSticker, bitmapPoints);

            float x1 = bitmapPoints[0];
            float y1 = bitmapPoints[1];
            float x2 = bitmapPoints[2];
            float y2 = bitmapPoints[3];
            float x3 = bitmapPoints[4];
            float y3 = bitmapPoints[5];
            float x4 = bitmapPoints[6];
            float y4 = bitmapPoints[7];

            if (showBorder) {
                canvas.drawLine(x1, y1, x2, y2, borderPaint);
                canvas.drawLine(x1, y1, x3, y3, borderPaint);
                canvas.drawLine(x2, y2, x4, y4, borderPaint);
                canvas.drawLine(x4, y4, x3, y3, borderPaint);
            }

            //draw icons
            if (showIcons) {
                float rotation = calculateRotation(x4, y4, x3, y3);
                for (int i = 0; i < icons.size(); i++) {
                    BitmapStickerIcon icon = icons.get(i);
                    switch (icon.getPosition()) {
                        case BitmapStickerIcon.LEFT_TOP:

                            configIconMatrix(icon, x1, y1, rotation);
                            break;

                        case BitmapStickerIcon.RIGHT_TOP:
                            configIconMatrix(icon, x2, y2, rotation);
                            break;

                        case BitmapStickerIcon.LEFT_BOTTOM:
                            configIconMatrix(icon, x3, y3, rotation);
                            break;

                        case BitmapStickerIcon.RIGHT_BOTOM:
                            configIconMatrix(icon, x4, y4, rotation);
                            break;
                    }
                    icon.draw(canvas, borderPaint);
                }
            }
        }
    }

    protected void configIconMatrix(@NonNull BitmapStickerIcon icon, float x, float y,
                                    float rotation) {
        icon.setX(x);
        icon.setY(y);
        icon.getMatrix().reset();

        icon.getMatrix().postRotate(rotation, icon.getWidth() / 2, icon.getHeight() / 2);
        icon.getMatrix().postTranslate(x - icon.getWidth() / 2, y - icon.getHeight() / 2);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (locked) {
            Log.d("checkLockEmojiCurrent", "1.Lock");
            return super.onInterceptTouchEvent(ev);
        }
        Log.d("checkLockEmojiCurrent", "1.Un_Lock");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = ev.getX();
                downY = ev.getY();

                return findCurrentIconTouched() != null || findHandlingSticker() != null;
        }

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (locked) {
            Log.d("checkLockEmojiCurrent", "2.Lock");
            return super.onTouchEvent(event);
        }
        Log.d("checkLockEmojiCurrent", "2.Un_Lock");
        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (!onTouchDown(event)) {
                    return false;
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                oldDistance = calculateDistance(event);
                oldRotation = calculateRotation(event);

                midPoint = calculateMidPoint(event);

                if (handlingSticker != null && isInStickerArea(handlingSticker, event.getX(1),
                        event.getY(1)) && findCurrentIconTouched() == null) {
                    currentMode = ActionMode.ZOOM_WITH_TWO_FINGER;
                }
                Log.d("checkMotionFiger", "ACTION_POINTER_DOWN: ");
                break;

            case MotionEvent.ACTION_MOVE:
                if (handlingSticker != null) {
                    if (!isLockCurrent()) {
                        handleCurrentMode(event);
                        invalidate();
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                onTouchUp(event);
                break;

            case MotionEvent.ACTION_POINTER_UP:
                if (currentMode == ActionMode.ZOOM_WITH_TWO_FINGER && handlingSticker != null) {
                    if (onStickerOperationListener != null) {
                        onStickerOperationListener.onStickerZoomFinished(handlingSticker);
                        //save undo khi zoom xong
                        saveStickerState();
                    }
                }
                currentMode = ActionMode.NONE;
                Log.d("checkMotionFiger", "ACTION_POINTER_UP: ");
                break;
        }

        return true;
    }

    /**
     * @param event MotionEvent received from {@link #onTouchEvent)
     * @return true if has touch something
     */
    protected boolean onTouchDown(@NonNull MotionEvent event) {
        currentMode = ActionMode.DRAG;

        downX = event.getX();
        downY = event.getY();

        midPoint = calculateMidPoint();
        oldDistance = calculateDistance(midPoint.x, midPoint.y, downX, downY);
        oldRotation = calculateRotation(midPoint.x, midPoint.y, downX, downY);

        currentIcon = findCurrentIconTouched();
        if (currentIcon != null) {
            currentMode = ActionMode.ICON;
            currentIcon.onActionDown(this, event);
        } else {
            handlingSticker = findHandlingSticker();
        }

        if (handlingSticker != null) {
            onStickerOperationListener.onStickerTouchedDown(handlingSticker);
            downMatrix.set(handlingSticker.getMatrix());
            if (bringToFrontCurrentSticker) {
                stickers.remove(handlingSticker);
                stickers.add(handlingSticker);
            }
        }

        if (currentIcon == null && handlingSticker == null) {
            return false;
        }
        invalidate();
        return true;
    }

    protected void onTouchUp(@NonNull MotionEvent event) {
        long currentTime = SystemClock.uptimeMillis();

        if (currentMode == ActionMode.ICON && currentIcon != null && handlingSticker != null) {
            currentIcon.onActionUp(this, event);
        }

        if (currentMode == ActionMode.DRAG
                && Math.abs(event.getX() - downX) < touchSlop
                && Math.abs(event.getY() - downY) < touchSlop
                && handlingSticker != null) {
            currentMode = ActionMode.CLICK;
            if (onStickerOperationListener != null) {
                onStickerOperationListener.onStickerClicked(handlingSticker);
            }
            if (currentTime - lastClickTime < minClickDelayTime) {
                if (onStickerOperationListener != null) {
                    onStickerOperationListener.onStickerDoubleTapped(handlingSticker);
                }
            }
        }

        if (currentMode == ActionMode.DRAG && handlingSticker != null) {
            if (onStickerOperationListener != null) {
                onStickerOperationListener.onStickerDragFinished(handlingSticker);
                Log.d("checkDragCurrent", "--------------");
                Log.d("checkDragCurrent", "onTouchUp: 1, " + handlingSticker.getMatrix().toString());
                for (int i = 0; i < stickers.size(); i++) {
                    Log.d("checkDragCurrent", "onTouchUp: 2, " + stickers.get(i).getMatrix().toString());
                }
                //save undo khi di chuyển xong
                saveStickerState();
            }
        }

        currentMode = ActionMode.NONE;
        lastClickTime = currentTime;
    }

    protected void handleCurrentMode(@NonNull MotionEvent event) {
        switch (currentMode) {
            case ActionMode.NONE:
            case ActionMode.CLICK:
                Log.d("checkMoveSticker", "CLICK");
                break;
            case ActionMode.DRAG:
                if (handlingSticker != null) {
                    moveMatrix.set(downMatrix);
                    moveMatrix.postTranslate(event.getX() - downX, event.getY() - downY);
                    handlingSticker.setMatrix(moveMatrix);
                    if (constrained) {
                        constrainSticker(handlingSticker);
                        Log.d("checkMoveSticker", "1.DRAG");
                    }
                    //Log.d("checkDragCurrent", "onTouchUp: 2");
                }
                Log.d("checkMoveSticker", "DRAG");
                break;
            case ActionMode.ZOOM_WITH_TWO_FINGER:
                if (handlingSticker != null) {
                    float newDistance = calculateDistance(event);
                    float newRotation = calculateRotation(event);

                    moveMatrix.set(downMatrix);
                    moveMatrix.postScale(newDistance / oldDistance, newDistance / oldDistance, midPoint.x,
                            midPoint.y);
                    moveMatrix.postRotate(newRotation - oldRotation, midPoint.x, midPoint.y);
                    handlingSticker.setMatrix(moveMatrix);
                }
                Log.d("checkMoveSticker", "ZOOM_WITH_TWO_FINGER");
                break;

            case ActionMode.ICON:
                if (handlingSticker != null && currentIcon != null) {
                    currentIcon.onActionMove(this, event);
                }
                Log.d("checkMoveSticker", "ICON");
                break;
        }
    }

    public void zoomAndRotateCurrentSticker(@NonNull MotionEvent event) {
        zoomAndRotateSticker(handlingSticker, event);
    }

    public void zoomAndRotateSticker(@Nullable com.app.friendschat.utils.custom_sticker.Sticker sticker, @NonNull MotionEvent event) {
        if (sticker != null) {
            //ẩn do lúc chọn phóng to/ nhỏ size thay đổi quá nhanh
            //downMatrix.set(handlingSticker.getMatrix());
            float newDistance = calculateDistance(midPoint.x, midPoint.y, event.getX(), event.getY());
            float newRotation = calculateRotation(midPoint.x, midPoint.y, event.getX(), event.getY());
            Log.e("HVV1312", "OK ???: " + midPoint.x + " va " + event.getX());
            moveMatrix.set(downMatrix);
            //set zoom in/out sticker
            moveMatrix.postScale(newDistance / oldDistance, newDistance / oldDistance, midPoint.x,
                    midPoint.y);
            //set quay sticker
            moveMatrix.postRotate(newRotation - oldRotation, midPoint.x, midPoint.y);
            handlingSticker.setMatrix(moveMatrix);
        }
    }

    public void customeZoomAndRotateSticker(@Nullable com.app.friendschat.utils.custom_sticker.Sticker sticker, int x, int y, int m, int n) {
        if (sticker != null) {

            float oldD = calculateDistance(midPoint.x, midPoint.y, m, n);
            Log.e("HVV1312", "mid Point : " + midPoint.x + " va " + midPoint.y + " va va va m: " + m + " va n: " + n);
            float newDistance = calculateDistance(midPoint.x, midPoint.y, x, y);
            moveMatrix.set(downMatrix);
            moveMatrix.postScale(newDistance / oldD, newDistance / oldD, midPoint.x,
                    midPoint.y);
            if (handlingSticker != null) {
                handlingSticker.setMatrix(moveMatrix);
            }
            invalidate();
        }
    }

    protected void constrainSticker(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker) {
        float moveX = 0;
        float moveY = 0;
        int width = getWidth();
        int height = getHeight();
        sticker.getMappedCenterPoint(currentCenterPoint, point, tmp);
        if (currentCenterPoint.x < 0) {
            moveX = -currentCenterPoint.x;
        }

        if (currentCenterPoint.x > width) {
            moveX = width - currentCenterPoint.x;
        }

        if (currentCenterPoint.y < 0) {
            moveY = -currentCenterPoint.y;
        }

        if (currentCenterPoint.y > height) {
            moveY = height - currentCenterPoint.y;
        }

        sticker.getMatrix().postTranslate(moveX, moveY);
    }

    @Nullable
    protected BitmapStickerIcon findCurrentIconTouched() {
        for (BitmapStickerIcon icon : icons) {
            float x = icon.getX() - downX;
            float y = icon.getY() - downY;
            float distance_pow_2 = x * x + y * y;
            if (distance_pow_2 <= Math.pow(icon.getIconRadius() + icon.getIconRadius(), 2)) {
                return icon;
            }
        }

        return null;
    }

    /**
     * find the touched Sticker
     **/
    @Nullable
    protected com.app.friendschat.utils.custom_sticker.Sticker findHandlingSticker() {
        for (int i = stickers.size() - 1; i >= 0; i--) {
            if (isInStickerArea(stickers.get(i), downX, downY)) {
                return stickers.get(i);
            }
        }
        return null;
    }

    protected boolean isInStickerArea(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker, float downX, float downY) {
        tmp[0] = downX;
        tmp[1] = downY;
        return sticker.contains(tmp);
    }

    @NonNull
    protected PointF calculateMidPoint(@Nullable MotionEvent event) {
        if (event == null || event.getPointerCount() < 2) {
            midPoint.set(0, 0);
            return midPoint;
        }
        float x = (event.getX(0) + event.getX(1)) / 2;
        float y = (event.getY(0) + event.getY(1)) / 2;
        midPoint.set(x, y);
        return midPoint;
    }

    @NonNull
    protected PointF calculateMidPoint() {
        if (handlingSticker == null) {
            midPoint.set(0, 0);
            return midPoint;
        }
        handlingSticker.getMappedCenterPoint(midPoint, point, tmp);
        return midPoint;
    }

    /**
     * calculate rotation in line with two fingers and x-axis
     **/
    protected float calculateRotation(@Nullable MotionEvent event) {
        if (event == null || event.getPointerCount() < 2) {
            return 0f;
        }
        return calculateRotation(event.getX(0), event.getY(0), event.getX(1), event.getY(1));
    }

    protected float calculateRotation(float x1, float y1, float x2, float y2) {
        double x = x1 - x2;
        double y = y1 - y2;
        double radians = Math.atan2(y, x);
        return (float) Math.toDegrees(radians);
    }

    /**
     * calculate Distance in two fingers
     **/
    protected float calculateDistance(@Nullable MotionEvent event) {
        if (event == null || event.getPointerCount() < 2) {
            return 0f;
        }
        return calculateDistance(event.getX(0), event.getY(0), event.getX(1), event.getY(1));
    }

    protected float calculateDistance(float x1, float y1, float x2, float y2) {
        double x = x1 - x2;
        double y = y1 - y2;
        Double.isNaN(x);
        Double.isNaN(x);
        Double.isNaN(y);
        Double.isNaN(y);
        return (float) Math.sqrt(x * x + y * y);
    }

    protected float calculateDistance2(float x1, float y1, float x2, float y2) {
        double x = x1 - x2;
        double y = y1 - y2;

        return (float) Math.sqrt(x * x + y * y);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);

        //ẩn do khi bấm edit bị reset lại maxtrix về mặc định
//        for (int i = 0; i < stickers.size(); i++) {
//            Sticker sticker = stickers.get(i);
//            if (sticker != null) {
//                transformSticker(sticker);
//            }
//        }
    }

    /**
     * Sticker's drawable will be too bigger or smaller
     * This method is to transform it to fit
     * step 1：let the center of the sticker image is coincident with the center of the View.
     * step 2：Calculate the zoom and zoom
     **/
    protected void transformSticker(@Nullable com.app.friendschat.utils.custom_sticker.Sticker sticker) {
        if (sticker == null) {
            Log.e(TAG, "transformSticker: the bitmapSticker is null or the bitmapSticker bitmap is null");
            return;
        }

        sizeMatrix.reset();

        float width = getWidth();
        float height = getHeight();
        float stickerWidth = sticker.getWidth();
        float stickerHeight = sticker.getHeight();
        //step 1
        float offsetX = (width - stickerWidth) / 2;
        float offsetY = (height - stickerHeight) / 2;

        sizeMatrix.postTranslate(offsetX, offsetY);

        //step 2
        float scaleFactor;
        if (width < height) {
            scaleFactor = width / stickerWidth;
        } else {
            scaleFactor = height / stickerHeight;
        }

        sizeMatrix.postScale(scaleFactor / 2f, scaleFactor / 2f, width / 2f, height / 2f);

        sticker.getMatrix().reset();
        sticker.setMatrix(sizeMatrix);

        invalidate();
    }

    public void flipCurrentSticker(int direction) {
        flip(handlingSticker, direction);
    }

    public void flip(@Nullable com.app.friendschat.utils.custom_sticker.Sticker sticker, @Flip int direction) {
        if (sticker != null) {
            if (!sticker.isLock()) {
                sticker.getCenterPoint(midPoint);
                if ((direction & FLIP_HORIZONTALLY) > 0) {
                    sticker.getMatrix().preScale(-1, 1, midPoint.x, midPoint.y);
                    sticker.setFlippedHorizontally(!sticker.isFlippedHorizontally());
                }
                if ((direction & FLIP_VERTICALLY) > 0) {
                    sticker.getMatrix().preScale(1, -1, midPoint.x, midPoint.y);
                    sticker.setFlippedVertically(!sticker.isFlippedVertically());
                }

                if (onStickerOperationListener != null) {
                    onStickerOperationListener.onStickerFlipped(sticker);
                }

                //save undo khi flip xong
                saveStickerState();

                invalidate();
            }
        }
    }

    public boolean replace(@Nullable com.app.friendschat.utils.custom_sticker.Sticker sticker) {
        return replace(sticker, true);
    }

    public boolean replace(@Nullable com.app.friendschat.utils.custom_sticker.Sticker sticker, boolean needStayState) {
        if (handlingSticker != null && sticker != null) {
            float width = getWidth();
            float height = getHeight();
            if (needStayState) {
                sticker.setMatrix(handlingSticker.getMatrix());
                sticker.setFlippedVertically(handlingSticker.isFlippedVertically());
                sticker.setFlippedHorizontally(handlingSticker.isFlippedHorizontally());
            } else {
                handlingSticker.getMatrix().reset();
                // reset scale, angle, and put it in center
                float offsetX = (width - handlingSticker.getWidth()) / 2f;
                float offsetY = (height - handlingSticker.getHeight()) / 2f;
                sticker.getMatrix().postTranslate(offsetX, offsetY);

                float scaleFactor;
                if (width < height) {
                    scaleFactor = width / handlingSticker.getDrawable().getIntrinsicWidth();
                } else {
                    scaleFactor = height / handlingSticker.getDrawable().getIntrinsicHeight();
                }
                sticker.getMatrix().postScale(scaleFactor / 2f, scaleFactor / 2f, width / 2f, height / 2f);
            }
            int index = stickers.indexOf(handlingSticker);
            stickers.set(index, sticker);
            handlingSticker = sticker;

            invalidate();
            return true;
        } else {
            return false;
        }
    }

    public void replaceSticker(@Nullable com.app.friendschat.utils.custom_sticker.Sticker stickerOld, com.app.friendschat.utils.custom_sticker.Sticker stickerNew) {
        if (stickerOld != null && stickerNew != null) {
            stickerNew.setMatrix(stickerOld.getMatrix());
            stickerNew.setFlippedVertically(stickerOld.isFlippedVertically());
            stickerNew.setFlippedHorizontally(stickerOld.isFlippedHorizontally());
            stickerNew.setLock(stickerOld.isLock());

            int index = stickers.indexOf(stickerOld);
            stickers.set(index, stickerNew);
            handlingSticker = stickerNew;

            if (onStickerOperationListener != null) {
                onStickerOperationListener.onReplaceSticker(stickerOld);
            }
            //save undo khi replace face xong
            saveStickerState();

            invalidate();
        }
    }

    public boolean remove(@Nullable com.app.friendschat.utils.custom_sticker.Sticker sticker) {
        if (stickers.contains(sticker)) {
            stickers.remove(sticker);
            if (onStickerOperationListener != null) {
                onStickerOperationListener.onStickerDeleted(sticker);
            }
            if (handlingSticker == sticker) {
                handlingSticker = null;
            }

            //save undo khi xóa xong
            saveStickerState();

            invalidate();

            return true;
        } else {
            Log.d(TAG, "remove: the sticker is not in this StickerView");

            return false;
        }
    }

    public boolean removeCurrentSticker() {
        if (onStickerOperationListener != null) {
            onStickerOperationListener.onStickerHideOptionIcon();
        }
        return remove(handlingSticker);
    }

    public void hideSelect() {
        if (onStickerOperationListener != null) {
            onStickerOperationListener.onStickerHideOptionIcon();
        }
        handlingSticker = null;
        invalidate();
    }

    public void removeAllStickers() {
        stickers.clear();
        if (handlingSticker != null) {
            handlingSticker.release();
            handlingSticker = null;
        }
        invalidate();
    }

    @NonNull
    public StickerView addSticker(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker) {
        return addSticker(sticker, com.app.friendschat.utils.custom_sticker.Sticker.Position.CENTER);
    }

    public void clone(com.app.friendschat.utils.custom_sticker.Sticker sticker) {
        if (sticker instanceof DrawableSticker) {
            DrawableSticker drawableSticker = (DrawableSticker) sticker;
            Drawable drawable = drawableSticker.getDrawable().getConstantState().newDrawable().mutate();
            DrawableSticker drawableSticker1 = new DrawableSticker(drawable, drawableSticker.getDrawablePath());

            Matrix matrix = new Matrix(sticker.getMatrix());
            matrix.postTranslate(0.0F, 30.0F);
            drawableSticker1.setMatrix(matrix);
            drawableSticker1.setPagerSelect(sticker.getPagerSelect());
            drawableSticker1.setPosSelect(sticker.getPosSelect());
            drawableSticker1.setHide(sticker.isHide());
            drawableSticker1.setLock(sticker.isLock());
            drawableSticker1.setFlippedVertically(sticker.isFlippedVertically());
            drawableSticker1.setFlippedHorizontally(sticker.isFlippedHorizontally());
            stickers.add(drawableSticker1);
            invalidate();
        } else if (sticker instanceof TextSticker) {
            //cần sửa lại code khi có update add text
            TextSticker textSticker = new TextSticker(getContext());
            TextSticker textSticker1 = (TextSticker) sticker;
            textSticker.setText(textSticker1.getText());
            textSticker.setDrawable(textSticker1.getDrawable().getConstantState().newDrawable().mutate());
            textSticker.resizeText();
            addSticker(textSticker);
            Matrix matrix = new Matrix(sticker.getMatrix());
            matrix.postTranslate(0.0F, 30.0F);
            textSticker.setMatrix(matrix);
        }
        //save undo khi copy xong
        saveStickerState();
    }

    public StickerView addSticker(@NonNull final com.app.friendschat.utils.custom_sticker.Sticker sticker,
                                  final @com.app.friendschat.utils.custom_sticker.Sticker.Position int position) {
        if (ViewCompat.isLaidOut(this)) {
            addStickerImmediately(sticker, position);
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    addStickerImmediately(sticker, position);
                }
            });
        }
        return this;
    }

    protected void addStickerImmediately(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker, @com.app.friendschat.utils.custom_sticker.Sticker.Position int position) {
        setStickerPosition(sticker, position);


        float scaleFactor, widthScaleFactor, heightScaleFactor;

        widthScaleFactor = (float) getWidth() / sticker.getDrawable().getIntrinsicWidth();
        heightScaleFactor = (float) getHeight() / sticker.getDrawable().getIntrinsicHeight();
        scaleFactor = widthScaleFactor > heightScaleFactor ? heightScaleFactor : widthScaleFactor;

        sticker.getMatrix()
                .postScale(scaleFactor / 2, scaleFactor / 2, getWidth() / 2, getHeight() / 2);

        handlingSticker = sticker;
        stickers.add(sticker);

        //save undo khi add xong
        saveStickerState();

        if (onStickerOperationListener != null) {
            onStickerOperationListener.onStickerAdded(sticker);
        }
        invalidate();
    }

    protected void setStickerPosition(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker, @com.app.friendschat.utils.custom_sticker.Sticker.Position int position) {
        float width = getWidth();
        float height = getHeight();
        float offsetX = width - sticker.getWidth();
        float offsetY = height - sticker.getHeight();
        if ((position & com.app.friendschat.utils.custom_sticker.Sticker.Position.TOP) > 0) {
            offsetY /= 4f;
        } else if ((position & com.app.friendschat.utils.custom_sticker.Sticker.Position.BOTTOM) > 0) {
            offsetY *= 3f / 4f;
        } else {
            offsetY /= 2f;
        }
        if ((position & com.app.friendschat.utils.custom_sticker.Sticker.Position.LEFT) > 0) {
            offsetX /= 4f;
        } else if ((position & com.app.friendschat.utils.custom_sticker.Sticker.Position.RIGHT) > 0) {
            offsetX *= 3f / 4f;
        } else {
            offsetX /= 2f;
        }
        sticker.getMatrix().postTranslate(offsetX, offsetY);
    }

    @NonNull
    public float[] getStickerPoints(@Nullable com.app.friendschat.utils.custom_sticker.Sticker sticker) {
        float[] points = new float[8];
        getStickerPoints(sticker, points);
        return points;
    }

    public void getStickerPoints(@Nullable com.app.friendschat.utils.custom_sticker.Sticker sticker, @NonNull float[] dst) {
        if (sticker == null) {
            Arrays.fill(dst, 0);
            return;
        }
        sticker.getBoundPoints(bounds);
        sticker.getMappedPoints(dst, bounds);
    }

    public void save(@NonNull File file) {
        try {
            StickerUtils.saveImageToGallery(file, createBitmap());
            StickerUtils.notifySystemGallery(getContext(), file);
        } catch (IllegalArgumentException | IllegalStateException ignored) {
            //
        }
    }

    @NonNull
    public Bitmap createBitmap() throws OutOfMemoryError {
        handlingSticker = null;
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        this.draw(canvas);
        return bitmap;
    }

    public int getStickerCount() {
        return stickers.size();
    }

    public List<com.app.friendschat.utils.custom_sticker.Sticker> getStickers() {
        return stickers;
    }

    public List<com.app.friendschat.utils.custom_sticker.Sticker> getReverseSticker() {
        List<com.app.friendschat.utils.custom_sticker.Sticker> reversedSticker = new ArrayList<>(stickers);
        Collections.reverse(reversedSticker);
        return reversedSticker;
    }

    public void setStickers(List<com.app.friendschat.utils.custom_sticker.Sticker> stickerList) {
        for (com.app.friendschat.utils.custom_sticker.Sticker sticker : stickerList) {
            if (sticker instanceof DrawableSticker) {
                DrawableSticker drawableSticker = (DrawableSticker) sticker;
                Drawable drawable = drawableSticker.getOriginalDrawable().getConstantState().newDrawable().mutate();

                DrawableSticker drawableStickerNew = new DrawableSticker(drawable, drawableSticker.getDrawablePath());
                drawableStickerNew.setMatrix(drawableSticker.getMatrix());
                drawableStickerNew.setPagerSelect(drawableSticker.getPagerSelect());
                drawableStickerNew.setPosSelect(drawableSticker.getPosSelect());
                drawableStickerNew.setLock(drawableSticker.isLock());
                drawableStickerNew.setFlippedHorizontally(drawableSticker.isFlippedHorizontally());
                drawableStickerNew.setFlippedVertically(drawableSticker.isFlippedVertically());
                stickers.add(drawableStickerNew);
                Log.d("MatrixEmojiEdit", "1.add: " + drawableSticker.getMatrix().toString());
            } else if (sticker instanceof TextSticker) {

            }
        }

        for (int i = 0; i < stickers.size(); i++) {
            Log.d("MatrixEmojiEdit", "3.size: " + stickers.get(i).getMatrix().toString());
        }
        invalidate();
    }


    public void unSelectStickerCurrent() {
        handlingSticker = null;
        invalidate();
    }

    public void selectStickerCurrent(com.app.friendschat.utils.custom_sticker.Sticker sticker) {
        handlingSticker = sticker;
        invalidate();
    }

    public com.app.friendschat.utils.custom_sticker.Sticker getStickerFace() {
        if (stickers.size() > 0) {
            for (int i = 0; i < stickers.size(); i++) {
                if (stickers.get(i).getPagerSelect() == 0) {
                    return stickers.get(i);
                }
            }
        }
        return null;
    }

    public boolean isNoneSticker() {
        return getStickerCount() == 0;
    }

    public boolean isLocked() {
        return locked;
    }

    @NonNull
    public StickerView setLocked(boolean locked) {
        this.locked = locked;
        invalidate();
        return this;
    }

    public boolean isLockCurrent() {
        return handlingSticker.isLock();
    }

    @NonNull
    public StickerView setLockedCurrent(boolean lockedCurrent) {
        handlingSticker.setLock(lockedCurrent);
        saveStickerState();
        invalidate();
        return this;
    }

    @NonNull
    public StickerView setMinClickDelayTime(int minClickDelayTime) {
        this.minClickDelayTime = minClickDelayTime;
        return this;
    }

    public int getMinClickDelayTime() {
        return minClickDelayTime;
    }

    public boolean isConstrained() {
        return constrained;
    }

    @NonNull
    public StickerView setConstrained(boolean constrained) {
        this.constrained = constrained;
        postInvalidate();
        return this;
    }

    @NonNull
    public StickerView setOnStickerOperationListener(
            @Nullable OnStickerOperationListener onStickerOperationListener) {
        this.onStickerOperationListener = onStickerOperationListener;
        return this;
    }

    @Nullable
    public OnStickerOperationListener getOnStickerOperationListener() {
        return onStickerOperationListener;
    }

    @Nullable
    public com.app.friendschat.utils.custom_sticker.Sticker getCurrentSticker() {
        return handlingSticker;
    }

    @NonNull
    public List<BitmapStickerIcon> getIcons() {
        return icons;
    }

    public void setIcons(@NonNull List<BitmapStickerIcon> icons) {
        this.icons.clear();
        this.icons.addAll(icons);
        invalidate();
    }

    //undo
    public void saveStickerState() {
        List<com.app.friendschat.utils.custom_sticker.Sticker> stickersCopy = new ArrayList<>();
        for (com.app.friendschat.utils.custom_sticker.Sticker sticker : stickers) {
            Log.d("checkDragCurrent", "3,matrix: " + sticker.getMatrix().toString());

            DrawableSticker drawableSticker = (DrawableSticker) sticker;
            Drawable drawable = drawableSticker.getOriginalDrawable().getConstantState().newDrawable().mutate();

            DrawableSticker drawableStickerNew = new DrawableSticker(drawable, drawableSticker.getDrawablePath());
            drawableStickerNew.setMatrix(sticker.getMatrix());
            drawableStickerNew.setPagerSelect(sticker.getPagerSelect());
            drawableStickerNew.setPosSelect(sticker.getPosSelect());
            drawableStickerNew.setHide(sticker.isHide());
            drawableStickerNew.setLock(sticker.isLock());
            drawableStickerNew.setFlippedHorizontally(sticker.isFlippedHorizontally());
            drawableStickerNew.setFlippedVertically(sticker.isFlippedVertically());
            stickersCopy.add(drawableStickerNew);

        }
        undoList.add(stickersCopy);
        Log.d("checkDragCurrent", "4,matrix: " + undoList.size());
        for (int j = 0; j <= undoList.size() - 1; j++) {
            for (int k = 0; k <= undoList.get(j).size() - 1; k++) {
                Log.d("checkDragCurrent", "5,matrix: " + undoList.get(j).get(k).getMatrix().toString());
            }
        }
    }

    public void undo() {
        if (undoList.size() > 1) {
            //check từ phần tử thứ 2 trong list

            listUndoTemp.clear();
            listUndoTemp.addAll(undoList.get(undoList.size() - 1));

            undoList.remove(undoList.size() - 1);
            List<com.app.friendschat.utils.custom_sticker.Sticker> previousSticker = undoList.get(undoList.size() - 1);
            removeAllStickers();

            List<com.app.friendschat.utils.custom_sticker.Sticker> result = findModelsNotInList2(listUndoTemp, previousSticker);
            List<com.app.friendschat.utils.custom_sticker.Sticker> listResult = findModelsInList2NotInList1(listUndoTemp, previousSticker);
            Log.d("StickerDeleteUndo", "----------------------" + listUndoTemp.size() + ", " + previousSticker.size());
            if (!result.isEmpty()) {
                Log.d("StickerDeleteUndo", "Các sticker có trong list1 mà không có trong list2 là");
                if (onStickerOperationListener != null) {
                    onStickerOperationListener.onUndoDeleteSticker(result);
                }
                for (com.app.friendschat.utils.custom_sticker.Sticker sticker : result) {
                    Log.d("StickerDeleteUndo", "pager: " + sticker.getPagerSelect() + " , pos: " + sticker.getPosSelect());
                }
            } else {
                Log.d("StickerDeleteUndo", "Không có sticker nào trong list1 mà không có trong list2. Size= " + listResult.size());
                if (onStickerOperationListener != null) {
                    //
                    onStickerOperationListener.onUndoUpdateSticker(listResult);
                }
            }

            Log.d("checkDragCurrent", "undo: 1.");
            for (com.app.friendschat.utils.custom_sticker.Sticker sticker : previousSticker) {
                Log.d("checkDragCurrent", "undo: 2. " + sticker.getMatrix().toString());
                DrawableSticker drawableSticker = (DrawableSticker) sticker;
                Drawable drawable = drawableSticker.getOriginalDrawable().getConstantState().newDrawable().mutate();

                DrawableSticker drawableStickerNew = new DrawableSticker(drawable, drawableSticker.getDrawablePath());
                drawableStickerNew.setMatrix(sticker.getMatrix());
                drawableStickerNew.setPagerSelect(sticker.getPagerSelect());
                drawableStickerNew.setPosSelect(sticker.getPosSelect());
                drawableStickerNew.setHide(sticker.isHide());
                drawableStickerNew.setLock(sticker.isLock());
                drawableStickerNew.setFlippedHorizontally(sticker.isFlippedHorizontally());
                drawableStickerNew.setFlippedVertically(sticker.isFlippedVertically());
                stickers.add(drawableStickerNew);
                invalidate();
            }

        } else {
            removeAllStickers();
            undoList.clear();
            //phần tử cuối cùng của list ( chính là phần tử đầu tiên được add) -> xóa hết list
            if (onStickerOperationListener != null) {
                onStickerOperationListener.onUndoDeleteAll();
            }

        }
    }

    public void setListUndo(List<List<com.app.friendschat.utils.custom_sticker.Sticker>> listUndo) {
        for (int i = 0; i < listUndo.size(); i++) {
            List<com.app.friendschat.utils.custom_sticker.Sticker> stickerList = new ArrayList<>();
            for (int j = 0; j < listUndo.get(i).size(); j++) {
                if (listUndo.get(i).get(j) instanceof DrawableSticker) {
                    DrawableSticker drawableSticker = (DrawableSticker) listUndo.get(i).get(j);
                    Drawable drawable = drawableSticker.getOriginalDrawable().getConstantState().newDrawable().mutate();

                    DrawableSticker drawableStickerNew = new DrawableSticker(drawable, drawableSticker.getDrawablePath());
                    drawableStickerNew.setMatrix(listUndo.get(i).get(j).getMatrix());
                    drawableStickerNew.setPagerSelect(listUndo.get(i).get(j).getPagerSelect());
                    drawableStickerNew.setPosSelect(listUndo.get(i).get(j).getPosSelect());
                    drawableStickerNew.setLock(listUndo.get(i).get(j).isLock());
                    drawableStickerNew.setFlippedHorizontally(listUndo.get(i).get(j).isFlippedHorizontally());
                    drawableStickerNew.setFlippedVertically(listUndo.get(i).get(j).isFlippedVertically());
                    stickerList.add(drawableStickerNew);
                } else if (listUndo.get(i).get(j) instanceof TextSticker) {
                    //TextSticker

                }
            }
            undoList.add(stickerList);

        }
    }

    public List<List<com.app.friendschat.utils.custom_sticker.Sticker>> getUndoList() {
        return undoList;
    }

    public static List<com.app.friendschat.utils.custom_sticker.Sticker> findModelsNotInList2(List<com.app.friendschat.utils.custom_sticker.Sticker> list1, List<com.app.friendschat.utils.custom_sticker.Sticker> list2) {
        List<com.app.friendschat.utils.custom_sticker.Sticker> result = new ArrayList<>();

        for (com.app.friendschat.utils.custom_sticker.Sticker model : list1) {
            boolean found = false;
            for (com.app.friendschat.utils.custom_sticker.Sticker model2 : list2) {
                if (model.getPagerSelect() == model2.getPagerSelect() && model.getPosSelect() == model2.getPosSelect()) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.add(model);
            }
        }

        return result;
    }

    public static List<com.app.friendschat.utils.custom_sticker.Sticker> findModelsInList2NotInList1(List<com.app.friendschat.utils.custom_sticker.Sticker> list1, List<com.app.friendschat.utils.custom_sticker.Sticker> list2) {
        List<com.app.friendschat.utils.custom_sticker.Sticker> result = new ArrayList<>();

        for (com.app.friendschat.utils.custom_sticker.Sticker model2 : list2) {
            boolean found = false;

            for (com.app.friendschat.utils.custom_sticker.Sticker model : list1) {
                if (model2.getPagerSelect() == model.getPagerSelect() && model2.getPosSelect() == model.getPosSelect()) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.add(model2);
            }
        }

        return result;
    }

    public void recentSticker(List<List<com.app.friendschat.utils.custom_sticker.Sticker>> listUndoRecent) {
        removeAllStickers();

        stickers.addAll(listUndoRecent.get(listUndoRecent.size() - 1));
        invalidate();
    }


    public interface OnStickerOperationListener {
        void onStickerAdded(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker);

        void onStickerClicked(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker);

        void onStickerDeleted(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker);

        void onStickerDragFinished(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker);

        void onStickerTouchedDown(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker);

        void onStickerZoomFinished(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker);

        void onStickerFlipped(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker);

        void onStickerDoubleTapped(@NonNull com.app.friendschat.utils.custom_sticker.Sticker sticker);

        void onStickerHideOptionIcon();

        void onUndoDeleteSticker(@NonNull List<com.app.friendschat.utils.custom_sticker.Sticker> stickers);

        void onUndoUpdateSticker(@NonNull List<com.app.friendschat.utils.custom_sticker.Sticker> stickers);

        void onUndoDeleteAll();

        void onReplaceSticker(@NonNull Sticker sticker);
    }
}