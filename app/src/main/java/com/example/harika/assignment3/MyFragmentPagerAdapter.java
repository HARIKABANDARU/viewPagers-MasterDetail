package com.example.harika.assignment3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Harika on 9/19/2017.
 */



public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        int count;
        MovieBean movieBean;
        public MyFragmentPagerAdapter(FragmentManager fm, int size)
        {
            super(fm);
            count = size;
        }
        public android.support.v4.app.Fragment getItem(int position)
        {
            movieBean = new MovieBean();
            return Fragment_DetailView.newInstance((HashMap<String,?>)movieBean.getItem(position));


        }
        @Override
        public int getCount(){return count;}
        @Override
        public CharSequence getPageTitle(int position){
            Locale l = Locale.getDefault();
            HashMap<String,?> movie = (HashMap<String,?>)movieBean.getItem(position);
            String name = (String)movie.get("movieTitle");
            return name.toUpperCase(l);
    }
}
