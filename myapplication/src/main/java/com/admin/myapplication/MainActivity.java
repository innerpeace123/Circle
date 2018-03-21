package com.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    CircleView mCircleView;
    Button mButtonStart, mButtonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCircleView = (CircleView) findViewById(R.id.circleview);
        mButtonStart = (Button) findViewById(R.id.start);
        mButtonStop = (Button) findViewById(R.id.stop);
        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCircleView.stop();
            }
        });
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCircleView.start();
            }
        });
    }
}
