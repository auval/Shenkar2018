package com.amiru.shenkar2018.llg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class StaticView extends View {

    Paint lines;
    Paint textPaint;
    Paint touchPaint;
    boolean isTouched = false;
    float touchedX;
    float touchedY;

    public StaticView(Context context) {
        super(context);
        init();
    }

    public StaticView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StaticView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public StaticView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        lines = new Paint();
        lines.setColor(Color.WHITE);

        touchPaint = new Paint();
        touchPaint.setColor(0xff_ff_bb_bb);
        touchPaint.setAntiAlias(true);
        touchPaint.setStyle(Paint.Style.STROKE);
        touchPaint.setPathEffect(new DashPathEffect(new float[]{20, 20}, 0));
        // dash doesn't draw with hardware acceleration turned on (default in most cases)
        // we can turn it off if we need dash badly
        setLayerType(View.LAYER_TYPE_SOFTWARE, touchPaint);

        textPaint = new Paint();
        textPaint.setColor(Color.YELLOW);
        textPaint.setTextSize(40);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN ||
                event.getAction() == MotionEvent.ACTION_MOVE) {
            touchedX = event.getX();
            touchedY = event.getY();
            isTouched = true;
            postInvalidateOnAnimation();
            return true;
        } else {
            isTouched = false;
        }
        // will trigger a new call to onDraw()
        postInvalidateOnAnimation();
        return super.onTouchEvent(event);
    }

    /**
     * notice that the loops here are very short, so it's still ok to do it
     * inside a callback.
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0xffaa5599);

        for (int x = 0; x < getWidth(); x += 100) {
            canvas.drawLine(x, 0, x, 100, lines);
            canvas.drawText(Integer.toString(x), x, 50, textPaint);
        }

        for (int y = 0; y < getHeight(); y += 100) {
            canvas.drawLine(0, y, 100, y, lines);
            canvas.drawText(Integer.toString(y), 50, y, textPaint);
        }

        if (isTouched) {
            // paint touch location
            canvas.drawLine(touchedX, 0, touchedX, touchedY, touchPaint);
            canvas.drawLine(0, touchedY, touchedX, touchedY, touchPaint);

            canvas.drawCircle(touchedX, touchedY, 200, touchPaint);

            // logic for the location of the text
            int deltaX = touchedX > getWidth() / 2 ? -500 : 200;
            int deltaY = touchedY > getHeight() / 2 ? -100 : 100;

            // https://developer.android.com/reference/java/util/Formatter#syntax
            canvas.drawText(String.format("(%.2f,%.2f)", touchedX, touchedY), touchedX + deltaX, touchedY + deltaY, textPaint);

        }
    }
}
