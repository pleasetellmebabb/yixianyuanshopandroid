package com.example.yixianyuanshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        //两秒后进入主页面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //执行主体代码
                //启动主页面
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                //关闭当前页面
                finish();
            }
        },3000);

    }
}