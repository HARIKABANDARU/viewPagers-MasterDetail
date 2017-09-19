package com.example.harika.assignment3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MainFragment.coverPage {

    MainFragment mainFragment;
    Fragment AboutMe;
    private FragmentTransaction fragmentTransaction;
    public final static String MAIN_FRAGMENT_TAG="MAIN_FRAGMENT";

    @Override
    public void loadCoverPage()
    {

        AboutMe = new AboutMe();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, AboutMe).commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, mainFragment).commit();
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
