package com.conways.autoanalytics.test;

import android.content.Context;

import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class CustomView extends View implements View.OnClickListener {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onClick(View v) {

    }


    private void init(){
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
