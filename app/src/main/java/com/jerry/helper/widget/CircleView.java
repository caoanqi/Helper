package com.jerry.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.jerry.helper.R;

/**
 * 自定义圆
 *
 * @author : 曹幼林
 * @date : 2019/2/20
 */
public class CircleView extends View {

    private Canvas canvas;
    private Paint circlePaint;
    private Paint outCirclePaint;
    private Context context;
    int circleColor;
    private float radius;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        if (ta != null) {
            circleColor = ta.getColor(R.styleable.CircleView_circleColor, 0);
            ta.recycle();
        }

        radius = 100.0f;

        circlePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(circleColor);

        outCirclePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        outCirclePaint.setColor(circleColor);
        outCirclePaint.setStyle(Paint.Style.STROKE);
        outCirclePaint.setStrokeWidth(200.0f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(100.0f,100.0f,radius,circlePaint);
        canvas.drawArc(new RectF(200 * 0.1f, 200 * 0.1f, 200 * 0.9f, 200 * 0.9f),
                360,180,false,outCirclePaint);

    }
}
