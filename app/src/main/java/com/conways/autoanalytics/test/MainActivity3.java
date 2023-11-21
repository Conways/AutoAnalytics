package com.conways.autoanalytics.test;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainActivity3 extends Activity {



    private Disposable delay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        startDelay();
    }


    protected boolean openDelay(){
        return true;
    }

    protected long delayTime(){
        return 1000L;
    }

    public final void firstLoadDataFinish(){
        if (null!=delay&&!delay.isDisposed()){
            delay.dispose();
            finishDelay();
        }
    }


    private  void startDelay(){
        if (openDelay()){
            getWindow().setDimAmount(0.0001f);
            getWindow().getDecorView().setAlpha(0.0001f);
            delay= Observable
                    .just(666)
                    .delay(delayTime(), TimeUnit.MILLISECONDS)
                    .compose(getTransformer())
                    .subscribe(integer -> {
                        finishDelay();
                    });
        }
    }


    private void finishDelay(){
        setTheme(R.style.appTheme);
        getWindow().setDimAmount(1f);
        getWindow().getDecorView().setAlpha(1f);
        startTranslateAni();
    }

    private void startTranslateAni(){
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 1f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0);
        translateAnimation.setDuration(250L);
        translateAnimation.setRepeatCount(0);
        View view=getWindow().getDecorView();
        if (view instanceof ViewGroup){
            ViewGroup vg= (ViewGroup) view;
            for (int i = 0; i < vg.getChildCount(); i++) {
                vg.getChildAt(i).startAnimation(translateAnimation);
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null!=delay&&!delay.isDisposed()){
            delay.dispose();
        }
    }

    @Override
    public void finish() {
        super.finish();
    }

    public final static Scheduler scheduler = Schedulers.from(Executors.newFixedThreadPool(25));

    public static <T> ObservableTransformer<T, T> getTransformer() {
        return upstream -> upstream.subscribeOn(scheduler)
                .unsubscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread());
    }


}
