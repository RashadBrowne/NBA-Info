package com.example.nba_info;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class DetailFragment extends Fragment {
    private View mActivity;
    private static final String TAG = "DetailsActivity";
    private String YoutubeAPIKey = "AIzaSyCJvC9glzmX1cp_1DdocZdHwsXDPAwIknwkey";// Needed to use the api
    YouTubePlayerView Vidview;
    YouTubePlayer.OnInitializedListener listener;

    String ImageUrl;
    String Name;
    String Desc;
    String Link;

    public interface DetailInterface{
        void RecieveInfo()
    }

    public DetailFragment(String imageUrl, String name, String desc, String videoLink){
        ImageUrl = imageUrl;
        Name = name;
        Desc = desc;
        Link = videoLink;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = inflater.inflate(R.layout.detail_fragment, container, false);
        setInfo(ImageUrl, Name, Desc, Link);
        return mActivity;
    }

    //MyActivity
    private void setInfo(String imageUrl, String imageName, String imageDesc, final String link) {
        //Insert the Data into the Layout
        Log.d(TAG, "instance initializer: setting the information");
        TextView name = mActivity.findViewById(R.id.team_name);
        TextView desc = mActivity.findViewById(R.id.team_desc);
        name.setText(imageName);
        desc.setText(imageDesc);
        ImageView image = mActivity.findViewById(R.id.Image_B);
        Glide.with(this).asBitmap().load(imageUrl).into(image);


        /*
        //The only way to load a video using the youtube api
        final Button playbtn = (Button) mActivity.findViewById(R.id.playvid);

        //Load the youtube video
        Vidview = mActivity.findViewById(R.id.Video);
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

        //Set a listening to the button so it actually does something aka activate the youtube video
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Loading vid");
                Vidview.initialize(YoutubeAPIKey, listener);
                playbtn.setVisibility(playbtn.INVISIBLE);//Hide the button after pressing it
            }
        });*/
    }
}
