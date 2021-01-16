package com.example.yixianyuanshop.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yixianyuanshop.R;
import com.example.yixianyuanshop.home.bean.ResultBeanData;
import com.example.yixianyuanshop.util.Constants;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import com.youth.banner.listener.OnLoadImageListener;


import java.util.ArrayList;
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
    private  ResultBeanData.DataBean result;


    /*当前类型*/
    private int currenType=BANNER;

    public HomeFragmentAdapter(Context context, ResultBeanData.DataBean result) {
        this.context=context;
        this.result=result;
        mLayoutInflater=LayoutInflater.from(context);
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{
        private Context context;
        private View itemView;
        private Banner banner;


        public BannerViewHolder(Context context, View itemView) {
            super(itemView);
            this.context=context;
            this.banner=(Banner)itemView.findViewById(R.id.banner);

        }

        public void setData(List<ResultBeanData.DataBean.BannerBean> banner_info) {
            //设置banner数据
            List<String> imageurl=new ArrayList<>();
            for (int i=0;i<banner_info.size();i++){
                String imgurl=banner_info.get(i).getUrl();
                imageurl.add(imgurl);
            }
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
           /* //设置手风琴
            banner.setBannerAnimation(null);*/
            banner.setImages(imageurl, new OnLoadImageListener() {
                @Override
                public void OnLoadImage(ImageView view, Object url) {
                    //联网请求图片-Glide
                    Glide.with(context).load(Constants.BASE_URL_IMAGE + url).into(view);
                }
            });


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
                bannerviewholder.setData(result.getBanner());
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
