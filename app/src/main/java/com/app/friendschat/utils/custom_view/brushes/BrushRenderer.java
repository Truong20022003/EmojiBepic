package com.app.friendschat.utils.custom_view.brushes;


import android.graphics.Canvas;

import com.app.friendschat.utils.custom_view.DrawingEvent;

public interface BrushRenderer {
    void draw(Canvas canvas);
    void onTouch(DrawingEvent drawingEvent);
    void setBrush(Brush brush);
}
