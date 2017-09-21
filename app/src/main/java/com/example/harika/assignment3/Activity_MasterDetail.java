package com.example.harika.assignment3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

/**
 * Created by Harika on 9/20/2017.
 */

public class Activity_MasterDetail extends AppCompatActivity implements Fragment_List.OnListItemSelectedListemer {
    private boolean mTwoPane;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
        if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.main_container,Fragment_List.newInstance())
                    .commit();
        }
        if(findViewById(R.id.detail_container)!=null)
            mTwoPane = true;
    }
    public void onListItemSelected(int position, HashMap<String,?>moive)
    {
        if(mTwoPane)
        {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.detail_container,Fragment_DetailView.newInstance(movie))
                    .addToBackStack(null)
                    .commit();

        }
        else{
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.main_container,Fragment_DetailView.newInstance(movie))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
