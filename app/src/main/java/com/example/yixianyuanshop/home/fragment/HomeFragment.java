package com.example.yixianyuanshop.home.fragment;

import android.content.Context;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.yixianyuanshop.R;
import com.example.yixianyuanshop.base.BaseFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;

import static android.content.ContentValues.TAG;

public class HomeFragment extends BaseFragment {
    //测试github提交

    private static final String TAG =
            HomeFragment.class.getSimpleName();
    private RecyclerView rvHome;
    private ImageView ib_top;
    private TextView tv_search_home;
    private TextView tv_message_home;
    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.main_home,null);
        rvHome = (RecyclerView) view.findViewById(R.id.rv_home);
        ib_top = (ImageView) view.findViewById(R.id.ib_top);
        tv_search_home = (TextView)
                view.findViewById(R.id.tv_search_home);
        tv_message_home = (TextView)
                view.findViewById(R.id.tv_message_home);
        //设置点击事件
        initListener();
        return view;
    }
    @Override
    public void initData(){
        super.initData();
        System.out.println("sdfsdf");
        String url = "https://www.csdn.net/";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        System.out.println("请求失败"+id);
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        System.out.println("请求成功"+id);
                        System.out.println(response);
                    }


                });

    }

    private void initListener() {
        //置顶的监听
        ib_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回到顶部
                rvHome.scrollToPosition(0);
            }
        });
        //搜素的监听
        tv_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "搜索",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //消息的监听
        tv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "进入消息中心",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
