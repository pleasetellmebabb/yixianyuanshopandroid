package com.example.yixianyuanshop.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yixianyuanshop.R;
import com.example.yixianyuanshop.home.bean.ResultBeanData;
import com.youth.banner.Banner;


import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter {
    @NonNull
    /*横幅广告*/
    public static final int BANNER=0;
    /*频道  菜单*/
    public static final int CHANNEL=1;
    /*活动*/
    public static final int ACT=2;
    /*秒杀*/
    public static final int SECKILL=3;
    /*推荐*/
    public static final int RECOMMEND=4;
    /*热卖*/
    public static final int HOT=5;
    private  LayoutInflater mLayoutInflater;
    private  Context context;
    private  ResultBeanData result;


    /*当前类型*/
    private int currenType=BANNER;

    public HomeFragmentAdapter(Context context, ResultBeanData result) {
        this.context=context;
        this.result=result;
        mLayoutInflater=LayoutInflater.from(context);
    }
    class BannerViewHolder extends RecyclerView.ViewHolder{
        private Context context;
        private View itemView;
        public Banner banner;

        public BannerViewHolder(Context context, View itemView) {
            super(itemView);
            this.context=context;
            this.banner=(Banner)itemView.findViewById(R.id.banner);

        }

        public void setData(List<ResultBeanData.DataBean.BannerBean> banner) {
            //设置banner数据



        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==BANNER){
            return new BannerViewHolder(context,mLayoutInflater.inflate(R.layout.banner_viewpager,null));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if(getItemViewType(position)==BANNER){
                BannerViewHolder bannerviewholder =(BannerViewHolder) holder;
                bannerviewholder.setData(result.getData().getBanner());
            }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    //得到类型
    @Override
    public int getItemViewType(int position){
        switch(position){
            case BANNER:
                currenType=BANNER;
                break;
            case CHANNEL:
                currenType=CHANNEL;
                break;
            case ACT:
                currenType=ACT;
                break;
            case SECKILL:
                currenType=SECKILL;
                break;
            case RECOMMEND:
                currenType=RECOMMEND;
                break;
            case HOT:
                currenType=HOT;
                break;
            default:

                break;
        }
        return currenType;
    }
}
