package com.example.harika.assignment3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

/**
 * Created by Harika on 9/20/2017.
 */

public class Activity_MasterDetail extends AppCompatActivity implements  Fragment_List.onButtonClickListener{
    private boolean mTwoPane;
    MovieBean movieBean;
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        movieBean = new MovieBean();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
        if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.main_container,new Fragment_List())
                    .commit();
        }
        if(findViewById(R.id.detail_container)!=null) {
            mTwoPane = true;
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.detail_container,Fragment_DetailView.newInstance((HashMap<String,?>)movieBean.getItem(position)))
                    .commit();
        }
    }

    @Override
    public void onButtonClicked(int position) {
        if(mTwoPane == true) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.detail_container, Fragment_DetailView.newInstance((HashMap<String, ?>) movieBean.getItem(position)))
                    .addToBackStack(null)
                    .commit();
        }
        else
        {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.main_container, Fragment_DetailView.newInstance((HashMap<String, ?>) movieBean.getItem(position)))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
