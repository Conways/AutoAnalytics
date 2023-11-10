package com.conways.autoanalytics.test;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;



public class SplashActivity extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private static final int test = 450;
    public static final int test1 = 451;
    private static int test2 = 452;
    public static int test3 = 453;

    public static int test4;


    private int test5=8;


    static {
        test4 = 4;
        test3();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "onClick: "+v.getContext()+temp);
                lambdaSimple(test5,savedInstanceState,v);
            }
        });

        findViewById(R.id.test1).setOnClickListener(this);

        findViewById(R.id.test2).setOnClickListener(v -> {
            lambdaSimple(test5,savedInstanceState,v);
            Log.d("test", "onClick: "+v.getContext()+temp);
        });
        findViewById(R.id.test3).setOnClickListener(v -> lambdaSimple(test5,savedInstanceState,v));
        findViewById(R.id.test3).setOnClickListener(new Click());









        RadioGroup group = findViewById(R.id.radio0);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("test", "run: ");
            }
        });


    }

    private void lambdaSimple(int test, Bundle intent,View view){
        SpannableString spannableString=new SpannableString("测试span点击");
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Log.d("zzzz", "业务内容: ");
            }
        },2,6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        TextView tv=findViewById(R.id.test4);
        tv.setText(spannableString);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
//        tv.setFocusable(true);
    }

    private int temp;
    @Override
    protected void onStart() {
        super.onStart();
        test4 = 6;
        CheckBox box = findViewById(R.id.box1);
        box.setOnCheckedChangeListener((buttonView, isChecked) -> {
           temp=9;
        });

        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("zzz", "onStart: "+hashCode());

            }
        });
    }




    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,MainActivity3.class));

    }


    private void test1() {
        Log.d("zzzzzzzzzzzzzz", "test1: ");
    }

    public static void test2() {
        Log.d("zzzzzzzzzzzzzz", "test2: ");
    }


    private static void test3() {
        Log.d("zzzzzzzzzzzzzz", "test3: ");
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {


    }


    public class Click implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            AlertDialog dialog=new AlertDialog.Builder(v.getContext())
                    .setMessage("test")
                    .setNegativeButton("cancel", (dialog1, which) -> dialog1.dismiss())
                    .setPositiveButton("ok", (dialog12, which) -> {
                        dialog12.dismiss();
                    }).show();
        }
    }


    public class Span extends ClickableSpan{
        @Override
        public void onClick(@NonNull View widget) {

        }
    }




}
