package com.example.myapplication2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/6/4.
 */

public class CircleProgressView extends View{


//    private Paint mArcPaint, mCirclePaint, mTextPaint, mPaint;
//
//    private float length;
//
//    private float mRadius;
//
//    private float mCircleXY;
//
//    private float mSweepValue = 0;
//
//    private String mShowText = "0%";
//
//    private RectF mRectF;
//
//    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        initView();
//    }
//
//    public CircleProgressView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        initView();
//    }
//
//    public CircleProgressView(Context context) {
//        super(context);
//        initView();
//    }
//
//    private void initView() {
//        mArcPaint = new Paint();
//        mArcPaint.setStrokeWidth(50);//设置线宽
//        mArcPaint.setAntiAlias(true);// 设置画笔的锯齿效果。 true是去除，大家一看效果就明白了
//        mArcPaint.setColor(Color.GREEN);
//        mArcPaint.setStyle(Paint.Style.STROKE);//设置画笔为空心
//
//        mCirclePaint = new Paint();
//        mCirclePaint.setColor(Color.GREEN);
//        mCirclePaint.setAntiAlias(true);
//
//        mTextPaint = new Paint();
//        mTextPaint.setAntiAlias(true);
//        mTextPaint.setColor(Color.RED);
//        mTextPaint.setStrokeWidth(0);
//        mTextPaint.setTextSize(120);//设置字体大小
//
//        mPaint = new Paint();
//        mPaint.setStrokeWidth(40);
//        mPaint.setAntiAlias(true);
//        mPaint.setColor(Color.YELLOW);
//        mPaint.setStyle(Paint.Style.STROKE);
//
//
//    }
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        length = w;
//        mCircleXY = length / 2;
//        mRadius = (float) (length * 0.5 / 2);
//
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        // 外切圆矩形
//        mRectF = new RectF((float) (length * 0.1), (float) (length * 0.1),
//                (float) (length * 0.9), (float) (length * 0.9));
//        //画圆
//        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
//        // 画弧线
//        canvas.drawArc(mRectF, 270, 360, false, mPaint);//用于确定圆弧形状与尺寸的椭圆边界，
//        // 开始角度（以时钟3点的方向为0度），扫过角度，是否包含圆心，绘制圆弧的画笔
//        canvas.drawArc(mRectF, 270, mSweepValue, false, mArcPaint);
//
//        // 绘制文字
//        float textWidth = mTextPaint.measureText(mShowText);   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
//
////        float a=80.0;
////        mShowText = (float) (360.0 * (a / 100.0)) + "%";
////        invalidate();
//
//        canvas.drawText(mShowText, (int)(length/2-textWidth/2), (int)(length/2+textWidth/6) , mTextPaint);
////        Paint.FontMetricsInt fontMetricsInt=mTextPaint.getFontMetricsInt();
////        int baseline=(getMeasuredHeight()-fontMetricsInt.bottom+fontMetricsInt.top)/2-fontMetricsInt.top;
//
////        canvas.drawText(mShowText, (int)(length/2-textWidth/2),baseline-4*textWidth/5, mTextPaint);
//    }
//
//    public void setProgress(float mSweepValue) {
////        float a = (float) mSweepValue;
////        if (a != 0) {
////            this.mSweepValue = (float) (360.0 * (a / 100.0));
////            mShowText = mSweepValue + "%";
//////            Log.e("this.mSweepValue:", this.mSweepValue + "");
////        } else {
////            this.mSweepValue = 25;
////            mShowText = 25 + "%";
////        }
////
////        invalidate();//刷新界面
//    }


    private int mMeasureHeigth;
    private int mMeasureWidth;

    private Paint mCirclePaint;
    private float mCircleXY;
    private float mRadius;

    private Paint mArcPaint;
    private Paint mArcPaint2;
    private RectF mArcRectF;
    private float mSweepAngle;
    private float mSweepValue=66;

    private Paint mTextPaint;
    private String mShowText;
    private float mShowTextSize;



    public CircleProgressView(Context context) {
        super(context);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeigth = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mMeasureWidth, mMeasureHeigth);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mArcRectF,270,360,false,mArcPaint2);
        canvas.drawArc(mArcRectF, 270, mSweepAngle, false, mArcPaint);
        mShowText=mSweepValue+"%";
        canvas.drawText(mShowText,0,mShowText.length(),
                mCircleXY,mCircleXY+(mShowTextSize/4),mTextPaint);
    }

    private void initView() {
        float length=0;
        if (mMeasureHeigth >= mMeasureWidth) {
            length=mMeasureWidth;
        }else{
            length=mMeasureHeigth;
        }
        mCircleXY=length/2;
        mRadius = (float) (length * 0.5 / 2);
        mCirclePaint=new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));

        mArcRectF=new RectF(
                (float)(length*0.1),
                (float)(length*0.1),
                (float)(length*0.9),
                (float)(length*0.9));
        mSweepAngle=(mSweepValue/100f)*360f;

        mArcPaint2=new Paint();
        mArcPaint2.setAntiAlias(true);
        mArcPaint2.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mArcPaint2.setStrokeWidth((float) (length * 0.1));
        mArcPaint2.setStyle((Paint.Style.STROKE));

        mArcPaint=new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(getResources().getColor(android.R.color.holo_green_dark));
        mArcPaint.setStrokeWidth((float) (length * 0.1));
        mArcPaint.setStyle(Paint.Style.STROKE);


        mShowTextSize=setShowTextSize();
        mTextPaint=new Paint();
        mTextPaint.setTextSize(mShowTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);


    }

    private float setShowTextSize() {
        this.invalidate();
        return 120;
    }


//    public void setSweepValue(float sweepValue) {
//        if (sweepValue != 0) {
//            mSweepValue = sweepValue;
//        } else {
//            mSweepValue = 25;
//        }
//        this.invalidate();
//    }

}
