package com.example.nba_info;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Slide;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;


public class MainActivity extends AppCompatActivity implements MainFragment.SendInfoListener {
    private MainFragment fragmentMain;
    private DetailFragment fragmentDetail;
    private String Orientation = "?";


    //Make me a class
    static String tUrl ="";
    static String tName = "";
    static String tDesc = "";
    static String tLink = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {//Don't reset if the activity already started
            StartMainFrag();

            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                Orientation = "P";
            }

            else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                Orientation = "L";
                StartDetailFrag(tUrl, tName, tDesc, tLink);
            }
            //Just so night mode doesnt remove the fragment on first launch
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            if (Orientation.equals("L")){return;}
            setContentView(R.layout.activity_land);
            StartMainFrag();
            StartDetailFrag(tUrl, tName, tDesc, tLink);
            Orientation = "L";

        }

        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            if (Orientation.equals("P")){return;}
            setContentView(R.layout.activity_main);
            if (getSupportFragmentManager().findFragmentById(R.id.container2) != null) {
                if (tUrl.equals("")){
                    StartMainFrag();
                }
                else{
                    StartDetailFrag(tUrl, tName, tDesc, tLink);
                }
                getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentById(R.id.container2));
            }
            Orientation = "P";
        }
    }

    //Saving the data on config change
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (savedInstanceState != null) {//Save variables before resetting
            savedInstanceState.putString("Url", tUrl);
            savedInstanceState.putString("Name", tName);
            savedInstanceState.putString("Desc", tDesc);
            savedInstanceState.putString("Link", tLink);
            savedInstanceState.putString("Orientation", Orientation);
        }
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        if (savedInstanceState != null) {//Get variables
            tUrl = savedInstanceState.getString("Url");
            tName = savedInstanceState.getString("Name");
            tDesc = savedInstanceState.getString("Desc");
            tLink = savedInstanceState.getString("Link");
            Orientation = savedInstanceState.getString("Orientation");
        }
    }

    public void StartMainFrag(){
        FragmentTransaction mainFrag = getSupportFragmentManager().beginTransaction();
        fragmentMain = new MainFragment();//Innit the fragment
        fragmentMain.setExitTransition(new Slide(Gravity.LEFT));
        fragmentMain.setEnterTransition(new Slide(Gravity.RIGHT));
        mainFrag.add(R.id.container, fragmentMain).commit();
        //Swap it into the FrameLayout with the id container
    }

    @Override
    public void StartDetailFrag(String Url, String Name, String Desc, String Link) {
        tUrl = Url;   tName = Name;   tDesc = Desc;   tLink = Link;//Set temp variables for switching orientations
        fragmentDetail= new DetailFragment(Url , Name, Desc, Link);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            fragmentDetail.setExitTransition(new Slide(Gravity.LEFT));
            fragmentDetail.setEnterTransition(new Slide(Gravity.RIGHT));
            ft.replace(R.id.container, fragmentDetail).addToBackStack(null).commit();
        }

       else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            fragmentDetail.setExitTransition(new Slide(Gravity.BOTTOM));
            fragmentDetail.setEnterTransition(new Slide(Gravity.TOP));
            ft.replace(R.id.container2, fragmentDetail).commit();
        }
    }
}
