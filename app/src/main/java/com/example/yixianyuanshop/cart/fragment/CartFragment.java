package com.example.yixianyuanshop.cart.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.yixianyuanshop.base.BaseFragment;

public class CartFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        textView=new TextView(context);
        textView.setText("我是购物车");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        return textView;
    }
    @Override
    public void initData(){
        super.initData();
    }
}
