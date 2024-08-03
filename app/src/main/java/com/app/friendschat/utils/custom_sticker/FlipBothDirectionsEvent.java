package com.app.friendschat.utils.custom_sticker;

/**
 * Created by shashi on 6/6/18
 */

public class FlipBothDirectionsEvent extends AbstractFlipEvent {

  @Override
  @com.app.friendschat.utils.custom_sticker.StickerView.Flip protected int getFlipDirection() {
    return com.app.friendschat.utils.custom_sticker.StickerView.FLIP_VERTICALLY | StickerView.FLIP_HORIZONTALLY;
  }
}
