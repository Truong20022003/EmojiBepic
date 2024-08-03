package com.app.friendschat.utils.custom_sticker;

import android.view.MotionEvent;

/**
 * Created by shashi on 6/6/18
 */

public interface StickerIconEvent {
  void onActionDown(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event);

  void onActionMove(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event);

  void onActionUp(StickerView stickerView, MotionEvent event);
}
