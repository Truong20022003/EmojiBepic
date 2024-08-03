package com.app.friendschat.utils.custom_sticker;

/**
 * Created by shashi on 6/6/18
 */

public class FlipHorizontallyEvent extends AbstractFlipEvent {

  @Override
  @com.app.friendschat.utils.custom_sticker.StickerView.Flip protected int getFlipDirection() {
    return StickerView.FLIP_HORIZONTALLY;
  }
}
