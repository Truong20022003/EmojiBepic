package com.app.friendschat.utils.custom_sticker;

import android.view.MotionEvent;

public class HideSelectIconEvent implements StickerIconEvent {
    @Override
    public void onActionDown(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event) {

    }

    @Override
    public void onActionMove(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event) {

    }

    @Override
    public void onActionUp(StickerView stickerView, MotionEvent event) {
        if (!stickerView.isLockCurrent()){
            stickerView.hideSelect();
        }
    }
}
