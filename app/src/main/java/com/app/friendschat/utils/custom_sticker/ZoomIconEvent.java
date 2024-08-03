package com.app.friendschat.utils.custom_sticker;

import android.view.MotionEvent;

/**
 * Created by shashi on 6/6/18
 */

public class ZoomIconEvent implements StickerIconEvent {
  @Override
  public void onActionDown(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event) {

  }

  @Override
  public void onActionMove(com.app.friendschat.utils.custom_sticker.StickerView stickerView, MotionEvent event) {
    stickerView.zoomAndRotateCurrentSticker(event);
  }

  @Override
  public void onActionUp(StickerView stickerView, MotionEvent event) {
    if (stickerView.getOnStickerOperationListener() != null) {
      stickerView.getOnStickerOperationListener()
          .onStickerZoomFinished(stickerView.getCurrentSticker());
    }
  }
}
