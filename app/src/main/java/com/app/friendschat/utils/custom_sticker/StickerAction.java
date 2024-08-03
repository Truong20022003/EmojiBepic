package com.app.friendschat.utils.custom_sticker;

public class StickerAction {
    boolean status; //true: sticker đang được add mới, false: kéo thả vị trí
    com.app.friendschat.utils.custom_sticker.Sticker sticker;

    public StickerAction(boolean status, com.app.friendschat.utils.custom_sticker.Sticker sticker) {
        this.status = status;
        this.sticker = sticker;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public com.app.friendschat.utils.custom_sticker.Sticker getSticker() {
        return sticker;
    }

    public void setSticker(Sticker sticker) {
        this.sticker = sticker;
    }
}
