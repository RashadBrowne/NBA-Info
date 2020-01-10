package com.example.nba_info;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private MainFragment fragmentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState==null){//Todo: Make this a class /////https://www.youtube.com/watch?v=Njj9qb5v2aw
            fragmentMain= new MainFragment();//Innit the fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMain).commit();
            //Swap it into the FrameLayout with the id container
        }
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
    *"cardUseCompatPadding" solved this.

Tips:
    *Keep the view-group that onbindviewholder() would be calling to simplified state as complex layouts slow down this function.
    **Text views can slow down the recycler views.

    *Fragment xml thingy crashes the app. Use FrameLayoust instead


Questions:
    *Could I pass everything to a fragment on the start in the same way as a class?
*/
