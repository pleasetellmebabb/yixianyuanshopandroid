package com.example.yixianyuanshop.type.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.yixianyuanshop.base.BaseFragment;

public class TypeFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        textView=new TextView(context);
        textView.setText("我是分类页面");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        return textView;
    }
    @Override
    public void initData(){
        super.initData();
        System.out.println("sdfsdf");
    }
}
