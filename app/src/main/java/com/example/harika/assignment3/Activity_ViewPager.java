package com.example.harika.assignment3;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import java.util.HashMap;


public class Activity_ViewPager extends AppCompatActivity {
    MovieBean movieBean;
    ViewPager mViewPager;
    MyFragmentPagerAdapter mPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        movieBean = new MovieBean();
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),movieBean.getSize());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(3);
        customiseViewPager();
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }
    private void customiseViewPager(){
        mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                final float normalised_position = Math.abs(Math.abs(position) - 1);
                page.setRotationY(position * -30);
            }
        });
    }
}
