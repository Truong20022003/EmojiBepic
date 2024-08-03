package com.app.friendschat.utils.custom_sticker;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.Toast;

import com.app.friendschat.R;
import com.app.friendschat.utils.Constants;

public class CopyIconEvent implements StickerIconEvent {
    private Context context;
    public CopyIconEvent(Context context){
        this.context = context;
    }
    @Override
    public void onActionDown(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event) {

    }

    @Override
    public void onActionMove(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event) {

    }

    @Override
    public void onActionUp(StickerView stickerView, MotionEvent event) {
        if (!stickerView.isLockCurrent()) {
            if (stickerView.getStickerCount() > Constants.COUNT_EMOJI){
                Toast.makeText(context, context.getResources().getString(R.string.more_than_50_items_at_once), Toast.LENGTH_SHORT).show();
            }else {
                stickerView.clone(stickerView.getCurrentSticker());
            }
        }
    }
}
