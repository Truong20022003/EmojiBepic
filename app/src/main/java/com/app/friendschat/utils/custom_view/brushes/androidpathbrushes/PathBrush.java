package com.app.friendschat.utils.custom_view.brushes.androidpathbrushes;

import android.graphics.Paint;

import com.app.friendschat.utils.custom_view.brushes.Brush;


public abstract class PathBrush extends Brush {


    PathBrush(int minSizePx, int maxSizePx) {
        super(minSizePx, maxSizePx);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    public void setSizeInPercentage(float sizePercentage) {
        super.setSizeInPercentage(sizePercentage);
        mPaint.setStrokeWidth(getSizeInPixel());
    }

    @Override
    public int getSizeForSafeCrop() {
        return super.getSizeForSafeCrop() * 2;
    }
}
