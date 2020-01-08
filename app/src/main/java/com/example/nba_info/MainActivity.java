package com.example.nba_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MainFragment fragmentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentMain= new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMain).commit();
        //Put the main fragment into the container
    }

    /*
    Design Doc
    * I did have a line in to stop the scrolling from being glitchy (cutting off content and moving slow) but the fragment implementation fixed that.
    *This change dropped cpu usage while scrolling from ~60-65% to a maximum of 27.

    *Converted the heroimg into a webp and this removed all the speed problems on the main activity.
    *Note webp's are only supported api 18 and up aka not a problem.
    *Memory usage when up from 50mb avg after the load settles that one time to 100mb. avg.

    *Attempted to use the recommended splash screen but that crashed my phone.
    *It's more than likely to do with my image that I used being oversized and the way I dealt with it but skim.
    *The older way never failed so set that to 500ms.
    */

}
