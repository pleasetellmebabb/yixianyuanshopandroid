package com.example.yixianyuanshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yixianyuanshop.base.BaseFragment;
import com.example.yixianyuanshop.cart.fragment.CartFragment;
import com.example.yixianyuanshop.community.fragment.CommunityFragment;
import com.example.yixianyuanshop.home.fragment.HomeFragment;
import com.example.yixianyuanshop.type.fragment.TypeFragment;
import com.example.yixianyuanshop.user.fragment.UserFragment;

import java.util.ArrayList;



public class MainActivity extends FragmentActivity {



/*    @Bind(R.id.frameLayout)
    FrameLayout frame;*/
private int position = 0;
private Fragment tempFragemnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置默认选中


        //存储所有  framget
        ArrayList<BaseFragment> fragmentList=new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new TypeFragment());
        fragmentList.add(new CommunityFragment());
        fragmentList.add(new CartFragment());
        fragmentList.add(new UserFragment());

        //设置radiobutton监听事件
        RadioGroup r_main=(RadioGroup)findViewById(R.id.rg_main) ;

        r_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId){
                   case R.id.rb_home: //首页
                       position=0;
                       break;
                   case R.id.rb_type: //分类
                       position=1;
                       break;
                   case R.id.rb_community://发现
                       position=2;
                       break;
                   case R.id.rb_cart://购物车
                       position=3;
                       break;
                   case R.id.rb_user://个人中心
                       position=4;
                       break;
                   default:
                       position=0;
                       break;
               }

               //根据id获取不同fragment  实现
                    BaseFragment baseFragment = null;
                //System.out.println("长度="+fragmentList.size());
                if(fragmentList!=null&&fragmentList.size()>0){
                    System.out.println(position);
                     baseFragment=fragmentList.get(position);
                }

                //切换Fragment
                if(tempFragemnt!=baseFragment){
                    //修改初始值


                    if(baseFragment!=null){
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        //判断baseFragment是否添加
                        if(!baseFragment.isAdded()){
                            //隐藏当前fragment
                           // System.out.println("进入");
                            if(tempFragemnt!=null){
                                //System.out.println("进入隐藏");
                                transaction.hide(tempFragemnt);
                            }
                            //添加Fragment
                            transaction.add(R.id.frameLayout,baseFragment).commit();

                        }else{
                            //隐藏当前fragment
                            if(tempFragemnt!=null){
                                //System.out.println("进入隐藏2");
                                transaction.hide(tempFragemnt);
                            }
                            transaction.show(baseFragment).commit();

                        }
                        tempFragemnt=baseFragment;
                    }
                }



            }



        });
        //默认点击首页
        r_main.check(R.id.rb_home);




        //设置选中

        
    }
}