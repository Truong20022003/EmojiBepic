package com.app.friendschat.utils.custom_view.brushes.androidpathbrushes;


public class Pen extends PathBrush {

    public Pen(int minSizePx, int maxSizePx) {
        super(minSizePx, maxSizePx);
    }

    @Override
    public void setColor(int color) {
        mPaint.setColor(color);
    }
}
