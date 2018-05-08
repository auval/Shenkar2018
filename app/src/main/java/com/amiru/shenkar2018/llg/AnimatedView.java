package com.amiru.shenkar2018.llg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * example for simple physics in animation
 */
public class AnimatedView extends View {
    private static final String TAG = AnimatedView.class.getSimpleName();
    private static final int CANNON_SIZE = 30;

    PointF point = new PointF();
    BulletLogic logic = new BulletLogic();
    Paint paint, cannonPaint;
    private long t0;
    private float v0;
    private float angleRad;
    private float angleDeg;
    private Path trianglePath;


    public AnimatedView(Context context) {
        super(context);
        init();
    }

    public AnimatedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public AnimatedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AnimatedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        cannonPaint = new Paint();
        cannonPaint.setAntiAlias(true);
        cannonPaint.setColor(Color.BLACK);
        cannonPaint.setStyle(Paint.Style.FILL);

        trianglePath = new Path();
        trianglePath.moveTo(0, 0);
        trianglePath.lineTo(CANNON_SIZE, CANNON_SIZE);
        trianglePath.lineTo(-CANNON_SIZE, CANNON_SIZE);
        trianglePath.close();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        long now = System.currentTimeMillis();
        logic.calculateBulletLocation(point, v0, angleRad, t0, now);

        canvas.translate(CANNON_SIZE * 1.5f, getHeight() / 2);

        canvas.drawCircle(point.x, point.y, CANNON_SIZE / 2, paint);

        drawCannon(canvas);

        if (point.x < getWidth()) {
            // no need to continue the paint loop
            postInvalidateOnAnimation();
        }
    }

    private void drawCannon(Canvas canvas) {
        int save = canvas.save();
       // canvas.translate(0, CANNON_SIZE * 2);
        canvas.drawPath(trianglePath, cannonPaint);
       // canvas.translate(0, -CANNON_SIZE * 2);
        canvas.rotate(angleDeg, 0, 0);
        canvas.drawCircle(0, 0, CANNON_SIZE, cannonPaint);
        canvas.drawRoundRect(0, CANNON_SIZE / 2,
                CANNON_SIZE * 2, -CANNON_SIZE / 2,
                CANNON_SIZE / 5, CANNON_SIZE / 5, cannonPaint);
        canvas.restoreToCount(save);
    }


    public void setT0(long t0) {
        this.t0 = t0;
        // trigger an onDraw() cycle
        postInvalidateOnAnimation();
    }

    public void setV0(float v0) {
        this.v0 = v0;
        // trigger an onDraw() cycle
        postInvalidateOnAnimation();
    }

    /**
     * @param angleDegrees 0..360
     */
    public void setAngle(float angleDegrees) {
        this.angleDeg = angleDegrees;
        this.angleRad = (float) Math.toRadians(angleDegrees);
        // trigger an onDraw() cycle
        postInvalidateOnAnimation();
    }
}
