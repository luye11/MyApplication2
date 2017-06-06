package com.example.myapplication2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/6/6.
 */

public class VolumeView extends View {

    private int mWidth;
    private int mRectWidth;
    private int mRectHeight;
    private Paint mPaint;
    private double mRandom;
    private int mRectCount;
    private int offest=5;
    private float currentHeight;
    private LinearGradient mLinearGradinet;


    public VolumeView(Context context) {
        super(context);
        initView();
    }



    public VolumeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mRectCount=12;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=getWidth();
        mRectWidth = (int) (mWidth * 0.6 / mRectCount);
        mRectHeight=getHeight();
        mLinearGradinet = new LinearGradient(0, 0, mRectWidth, mRectHeight, Color.YELLOW, Color.BLUE, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradinet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i=1;i<mRectCount;i++) {
            mRandom=Math.random();
            currentHeight = (float) (mRectHeight * mRandom);
            canvas.drawRect(
                    (float)(mWidth*0.4/2+mRectWidth*i+offest),
                    currentHeight,
                    (float)(mWidth*0.4/2+mRectWidth*(i+1)),
                    mRectHeight,
                    mPaint);
        }
        postInvalidateDelayed(300);
    }


    //    private Paint mPaint;
//    private int mWidth;
//    private int mRectWidth;
//    private int mRectHight;
//    private int mRectCount;
//    private int offset = 5;
//    private double mRandom;
//    private LinearGradient mLinearGradient;
//
//
//    public VolumeView(Context context) {
//        super(context);
//        initView();
//    }
//
//
//    public VolumeView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        initView();
//    }
//
//    public VolumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        initView();
//    }
//
//    private void initView() {
//        mPaint = new Paint();
//        mPaint.setColor(Color.BLUE);
//        mPaint.setStyle(Paint.Style.FILL);
//        mRectCount = 12;
//    }
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        mWidth = getWidth();
//        mRectHight = getHeight();
//        mRectWidth = (int) (mWidth * 0.6 / mRectCount);
//        mLinearGradient = new LinearGradient(
//                0, 0, mRectWidth, mRectHight, Color.YELLOW, Color.BLUE, Shader.TileMode.CLAMP
//        );
//        mPaint.setShader(mLinearGradient);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        for (int i = 0; i < mRectCount; i++) {
//            mRandom = Math.random();
//            float currentHeight = (float) (mRectHight * mRandom);
//            canvas.drawRect(
//                    (float) (mWidth * 0.4 / 2 + mRectWidth * i + offset),
//                    currentHeight,
//                    (float) (mWidth * 0.4 / 2 + mRectWidth * (i + 1)),
//                    mRectHight,
//                    mPaint
//            );
//            postInvalidateDelayed(300);
//        }
//    }
}
