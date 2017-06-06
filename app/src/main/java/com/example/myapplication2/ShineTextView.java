package com.example.myapplication2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/3.
 */

public class ShineTextView extends android.support.v7.widget.AppCompatTextView {

    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private Paint mPaint;
    private int mViewWidth=0;
    private int mTranslate=0;

    public ShineTextView(Context context) {
        super(context);
    }

    public ShineTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth=getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint=getPaint();
                //线性渐变（0,0,0,0，int[] color,float[] position,Shader.TitleModl title）
                // 渐变起始位置，渐变结束位置；颜色的int数组，相对位置的数组，为null时均匀分布渐变线，
                //渲染器平铺模式
                mLinearGradient = new LinearGradient( 0,0,mViewWidth,0,new int[]{Color.BLUE,0xffffffff,
                                Color.BLUE},null,Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);//使用线性渐变来填充图形
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null) {
            mTranslate+=mViewWidth/5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate=-mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);//矩阵平移
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);//刷新矩阵毫秒数
        }
    }
}
