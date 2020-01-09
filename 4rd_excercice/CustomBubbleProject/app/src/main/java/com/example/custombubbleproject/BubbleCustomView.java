package com.example.custombubbleproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class BubbleCustomView extends View {

    private Rect rectangle;
    private Paint paint;
    private static final int OFFSET = 15;

    public BubbleCustomView(Context context) {
        super(context);
    }

    public BubbleCustomView(Context context, AttributeSet attr) {
        super(context, attr);
        int x = 0;
        int y = 0;
        int sideLength = 200;

        // create a rectangle that we'll draw later
        rectangle = new Rect(x, y, sideLength, sideLength);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.GRAY);
    }

    public BubbleCustomView(Context context, AttributeSet attr, int defStyleAttr) {
        super(context, attr, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect r = rectangle;
        RectF rect = new RectF(r);
        rect.inset(OFFSET, OFFSET);

        //Build a path
        Path path = new Path();

        //up arrow
        path.moveTo(OFFSET, OFFSET);
        path.lineTo(OFFSET * 2, 0);
        path.lineTo(OFFSET * 3, OFFSET);

        //top horizontal line.
        path.lineTo(r.width() - OFFSET, OFFSET);

        //top right arc
        path.arcTo(new RectF(r.right - OFFSET*2, OFFSET, r.right, OFFSET*3), 270, 90);

        //right vertical line.
        path.lineTo(r.width(), r.height()-OFFSET);

        //bottom right arc.
        path.arcTo(new RectF(r.right - OFFSET * 2, r.bottom- OFFSET * 2, r.right, r.bottom), 0, 90);

        //bottom horizontal line.
        path.lineTo(OFFSET, r.height());

        //bottom left arc.
        path.arcTo(new RectF(0, r.bottom- OFFSET * 2, OFFSET * 2, r.bottom), 90, 90);

        //left horizontal line.
        path.lineTo(0, OFFSET);

        //top right arc.
        path.arcTo(new RectF(0, OFFSET, OFFSET*2, OFFSET*3), 180, 90);


        path.close();

        paint.setColor(android.graphics.Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
    }
}
