package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.bntMyTextView);
        Button button1 = (Button) findViewById(R.id.shineTextView);
        Button button2 = (Button) findViewById(R.id.circleTextView);
        Button button3 = (Button) findViewById(R.id.volumeView);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bntMyTextView:
             setContentView(R.layout.my_textview);
                break;
            case R.id.shineTextView:

                setContentView(R.layout.shine_textview);
                break;
            case R.id.circleTextView:
                setContentView(R.layout.circle_progress);
//                CircleProgressView cirlce = (CircleProgressView) findViewById(R.id.circle);
//                cirlce.setSweepValue(60);
                break;
            case R.id.volumeView:
                setContentView(R.layout.volume);
            default:
                break;
        }
    }

}
