package com.example.myapplication2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/3.
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    private Paint mPaint1;
    private Paint mPaint2;

    public MyTextView(Context context) {
        super(context);
        init();
    }



    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        canvas.drawRect(
                10,
                10,
                getMeasuredWidth()-10,
                getMeasuredHeight()-10,
                mPaint2);
        canvas.save();
        canvas.translate(10,0);
        super.onDraw(canvas);
        canvas.restore();
    }

}
