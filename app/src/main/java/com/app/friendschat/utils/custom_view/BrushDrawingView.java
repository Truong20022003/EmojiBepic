package com.app.friendschat.utils.custom_view;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class BrushDrawingView extends View {
    //vẽ mới =))
    private Paint brushPaint;
    private Path brushPath;

    public BrushDrawingView(Context context) {
        super(context);
        init();
    }

    public BrushDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BrushDrawingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        brushPaint = new Paint();
        brushPaint.setColor(Color.BLACK);
        brushPaint.setStyle(Paint.Style.STROKE);
        brushPaint.setStrokeWidth(5); // Độ rộng của brush

        brushPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(brushPath, brushPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                brushPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                brushPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                // Nothing to do here for now
                break;
            default:
                return false;
        }

        invalidate(); // Gọi hàm này để vẽ lại View
        return true;
    }
}
