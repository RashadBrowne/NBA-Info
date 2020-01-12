package com.example.nba_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Slide;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import java.util.ArrayList;


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
            ft.add(R.id.container, fragmentMain).commit();
            //Swap it into the FrameLayout with the id container
            Log.d("hey", "onCreate: 1");
        }
        else {
            Log.d("hey", "onCreate: 2");
        }
    }

    @Override
    public void onInfoSent(String Url, String Name, String Desc, String Link) {
        fragmentDetail= new DetailFragment(Url , Name, Desc, Link);//Innit the fragment
        fragmentDetail.setExitTransition(new Slide(Gravity.LEFT));
        fragmentDetail.setEnterTransition(new Slide(Gravity.RIGHT));

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragmentDetail).addToBackStack(null).commit();
        Log.d("hey", "onCreate: 3");
    }
}


/*
Design Doc:
    * I did have a line in to stop the scrolling from being glitchy (cutting off content and moving slow) but the fragment implementation fixed that.
    *This change dropped cpu usage while scrolling from ~60-65% to a maximum of 27.

    *Stuff I forgot to mention, recyclerview caches all the items, to reduce calling onbindviewholder.
    *With this the recyclerview doesn't bash memory and cpu on scrolling.

    *Converted the hero image into a webp and this removed all the speed problems on the main activity.
    *Note webp's are only supported api 18 and up aka not a problem.

    *Memory usage when up from 50mb avg after the load settles that one time to 100mb. avg.

    *Hardware acceleration was enabled for the entire app.
    *Ram usages went up to 120mb max and cpu dropped to 15% avg. It just scrolls smoother barely noticeable but very satisfying.
    *"Energy" usage went down from high-medium to straight up low

    *Hardware acceleration was disabled for the splashscreen cause that was causing a harsh transition upon loading the main activity.

    *Added the lazy nightmode, weird graphical glitches around the cardview in the nightmode.
    *"app:cardBackgroundColor="@android:color/transparent"" solved this.

    *Fully switched to both activties being fragments. The youtube is still a bitch, it now crashes when nightmode activates or when it rotates in the detail activty.
    *Its a mess at this point. Also screw the youtube api.
    *But at least we have transitions between the fragments. Yeah they don't come with em naturally. #UseYaOwn!
    *And yes you need four animations for it to work.

    *Without the default constructor for a fragment it will crash on config change

Tips:
    *Keep the view-group that onbindviewholder() would be calling to simplified state as complex layouts slow down this function.
    **Text views can slow down the recycler views.

    *Fragment xml thingy crashes the app. Use FrameLayout instead

    *I can pass everything to a fragment on the start in the same way as a class

Sources:
    https://github.com/mikescamell/shared-element-transitions


*/
