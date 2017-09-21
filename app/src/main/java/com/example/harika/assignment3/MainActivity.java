package com.example.harika.assignment3;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MainFragment.coverPage {

    MainFragment mainFragment;
    Fragment AboutMe;
    private FragmentTransaction fragmentTransaction;
    public final static String MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT";

    @Override
    public void loadCoverPage(int index)
    {

       if(index==1){
        AboutMe = new AboutMe();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, AboutMe).addToBackStack(null).commit();}
        else if(index == 2) {
      Intent lIntent = new Intent(MainActivity.this, Activity_ViewPager.class);
        startActivity(lIntent);
       }
       else if(index ==3)
       {
           Intent mIntent = new Intent(MainActivity.this, Activity_MasterDetail.class);
           startActivity(mIntent);
       }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.coverPage:
                AboutMe = new AboutMe();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, AboutMe).addToBackStack(null).commit();
                return true;
            case R.id.viewpager:
                Intent vPager = new Intent(this,Activity_ViewPager.class);
                startActivity(vPager);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       if(savedInstanceState == null) {
            mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, mainFragment)
                    .commit();
        }
    }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag("MAIN_FRAGMENT") != null) {
            Log.d("Back Button","Back pressed");
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}

