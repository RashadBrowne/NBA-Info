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


    //Make me a class
    String tUrl ="";
    String tName = "";
    String tDesc = "";
    String tLink = "";

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
            //savedInstanceState.putString("app_launch","duh");//Just so night mode doesnt remove the fragment on first launch
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_land);
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            fragmentMain = new MainFragment();//Innit the fragment
            fragmentMain.setExitTransition(new Slide(Gravity.LEFT));
            fragmentMain.setEnterTransition(new Slide(Gravity.RIGHT));
            ft2.add(R.id.container, fragmentMain).commit();
            onInfoSent(tUrl, tName, tDesc, tLink);

        }

        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);
            if (getSupportFragmentManager().findFragmentById(R.id.container2) != null) {
                if (tUrl.equals("")){/*
                    FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                    fragmentMain = new MainFragment();//Innit the fragment
                    fragmentMain.setExitTransition(new Slide(Gravity.LEFT));
                    fragmentMain.setEnterTransition(new Slide(Gravity.RIGHT));
                    ft2.add(R.id.container, fragmentMain).commit();*/
                }
                else{
                    onInfoSent(tUrl, tName, tDesc, tLink);
                }
                getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentById(R.id.container2));
            }
        }
    }

    @Override
    public void onInfoSent(String Url, String Name, String Desc, String Link) {
        tUrl = Url;   tName = Name;   tDesc = Desc;   tLink = Link;//Set temp variables for switching

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
        }
    }
}
