package com.jerry.helper.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 水波纹
 *
 * @author : 曹幼林
 * @date : 2019/2/20
 */
public class WaveView extends View {

    private static final String TAG = WaveView.class.getSimpleName();

    /**
     * 波浪从外部开始，在屏幕外结束
     */
    private static final float EXTRA_DISTANCE = 200;

    private Path mPath;
    private Paint mPaint;

    /**
     * 空间宽高
     */
    private int mWidth;
    private int mHeight;

    /**
     * 控制点坐标
     */
    private float mControlX;
    private float mControlY;

    /**
     * 波浪峰值
     */
    private float mWaveY;

    /**
     * 是否移动控制点
     */
    private boolean isMoveControl = true;

    public WaveView(Context context) {
        super(context);
        init();
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;

        mControlY = mHeight - mHeight / 8;
        mWaveY = mHeight - mHeight / 32;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //波浪从屏幕外开始，效果更好
        mPath.moveTo(-EXTRA_DISTANCE, mWaveY);
        mPath.quadTo(mControlX, mControlY, mWidth + EXTRA_DISTANCE, mWaveY);
        mPath.lineTo(mWidth, mHeight);
        mPath.lineTo(0, mHeight);
        mPath.close();
        canvas.drawPath(mPath, mPaint);

        //mControlX坐标在 -EXTRA_DISTANCE ~ mWidth + EXTRA_DISTANCE 范围内，先自增在自减形成波浪效果
        if (mControlX <= -EXTRA_DISTANCE) {
            isMoveControl = true;
        } else if (mControlX >= mWidth + EXTRA_DISTANCE) {
            isMoveControl = false;
        }
        mControlX = isMoveControl ? mControlX + 20 : mControlX - 20;
        //水平面上升
        if (mControlY >= 0) {
            mControlY -= 2;
            mWaveY -= 2;
        }

        mPath.reset();
        invalidate();

    }

    private void init() {
        mPaint = new Paint();
        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setColor(Color.RED);
    }

}
