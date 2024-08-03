package com.app.friendschat.utils.custom_sticker;

import android.view.MotionEvent;

/**
 * Created by shashi on 6/6/18
 */

public abstract class AbstractFlipEvent implements StickerIconEvent {

  @Override
  public void onActionDown(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event) {

  }

  @Override
  public void onActionMove(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event) {

  }

  @Override
  public void onActionUp(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event) {
    stickerView.flipCurrentSticker(getFlipDirection());
  }

  @StickerView.Flip protected abstract int getFlipDirection();
}
