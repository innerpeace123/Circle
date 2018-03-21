package com.admin.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/**
 * author  : zhangxue
 * date    : 2018/3/19
 */

public class CircleView extends View {

    private Paint mCircleBordor;
    private Paint mCircleContent;
    private float mRadius = 0;//半径
    private float xCircleCenter;
    private float yCircleCenter;
    private float progress = 0;
    private float mWaveProgress;
    private float currentX;
    private float currentY;

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void init() {
        mCircleBordor = new Paint();
        mCircleBordor.setColor(Color.parseColor("#990000"));
        mCircleBordor.setStrokeWidth(5);
        mCircleBordor.setStyle(Paint.Style.STROKE);
        mCircleBordor.setFlags(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        mCircleContent = new Paint();
        mCircleContent.setColor(Color.parseColor("#009900"));
        mCircleContent.setStyle(Paint.Style.FILL);
        mCircleContent.setStrokeWidth(5);
        mCircleContent.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();//宽
        int height = getHeight();//高
        mRadius = width / 2;
        xCircleCenter = width / 2;
        yCircleCenter = height / 2;
        canvas.drawCircle(xCircleCenter, yCircleCenter, mRadius, mCircleBordor);
        /**
         * Math.cos(a)此处的a是指弧度并非角度，弧度等于2*Math.Pi/360*角度
         */
        currentX = (float) (mRadius + mRadius * Math.cos(2 * Math.PI / 360 * progress));
        currentY = (float) (mRadius + mRadius * Math.sin(2 * Math.PI / 360 * progress));

        canvas.drawCircle(currentX, currentY, 10, mCircleContent);


    }

    Runnable runnale = new Runnable() {
        @Override
        public void run() {

           postDelayed(runnale, 2);
            progress++;
            invalidate();
        }
    };

    /**
     * 开始
     */
    public void start() {
        if (runnale != null)
            runnale.run();

    }

    /**
     * 结束
     */
    public void stop() {
        if (runnale != null) {
       removeCallbacks(runnale);
        }
    }

}
