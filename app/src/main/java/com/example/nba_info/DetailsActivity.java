package com.example.nba_info;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class DetailsActivity extends YouTubeBaseActivity {

    private static final String TAG = "DetailsActivity";


    String Link = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    private String YoutubeAPIKey = "AIzaSyCJvC9glzmX1cp_1DdocZdHwsXDPAwIknwkey";
    YouTubePlayerView Vidview;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Log.d(TAG, "onCreate: Detail Started");


        //Youtube api shit
        //Button playbtn = (Button) findViewById(R.id.playvid);
        //Vidview = findViewById(R.id.Video);


        //Load info from recycler view
        getIncomingIntent();

        /*
        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("iQ7zFGJryIY");
                Log.d(TAG, "onInitializationSuccess: player");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationFailure: Failed Loading Vids");
            }
        };

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Loading vid");
                Vidview.initialize(YoutubeAPIKey, listener);
            }
        });
        */
    }


    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intent");
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")) {
            Log.d(TAG, "getIncomingIntent: found intent extras");
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageDesc = getIntent().getStringExtra("image_desc");
            String link = getIntent().getStringExtra("link");

            setInfo(imageUrl, imageName, imageDesc, link);
        } else {
            Log.d(TAG, "getIncomingIntent: failed");
        }
    }


    private void setInfo(String imageUrl, String imageName, String imageDesc, final String link) {
        Log.d(TAG, "instance initializer: setting the information");
        TextView name = findViewById(R.id.team_name);
        TextView desc = findViewById(R.id.team_desc);
        name.setText(imageName);
        desc.setText(imageDesc);

        ImageView image = findViewById(R.id.TeamIMG);
        Glide.with(this).asBitmap().load(imageUrl).into(image);
        //Vidview.loadVideo(link);


        Button playbtn = (Button) findViewById(R.id.playvid);
        Vidview = findViewById(R.id.Video);

        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(link);
                Log.d(TAG, "onInitializationSuccess: player");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationFailure: Failed Loading Vids");
            }
        };

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Loading vid");
                Vidview.initialize(YoutubeAPIKey, listener);
            }
        });
    }

}