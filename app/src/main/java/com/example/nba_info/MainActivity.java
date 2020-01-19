package com.example.nba_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Slide;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;


public class MainActivity extends AppCompatActivity implements MainFragment.SendInfoListener {
    private MainFragment fragmentMain;
    private DetailFragment fragmentDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {//Don't reset if the activity already started
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            fragmentMain = new MainFragment();//Innit the fragment
            fragmentMain.setExitTransition(new Slide(Gravity.LEFT));
            fragmentMain.setEnterTransition(new Slide(Gravity.RIGHT));

            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                ft.add(R.id.container, fragmentMain).commit();
                //Swap it into the FrameLayout with the id container
            }

            else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                onInfoSent("","", "", "");
                ft.add(R.id.container, fragmentMain).commit();
            }
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){

        }

        else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){

        }
    }

    @Override
    public void onInfoSent(String Url, String Name, String Desc, String Link) {
        fragmentDetail= new DetailFragment(Url , Name, Desc, Link);//Innit the fragment
        fragmentDetail.setExitTransition(new Slide(Gravity.LEFT));
        fragmentDetail.setEnterTransition(new Slide(Gravity.RIGHT));
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragmentDetail).addToBackStack(null).commit();
        }

        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container2, fragmentDetail).commit();
            Log.d("hey", "onCreate: 3");
        }
    }
}
