package com.example.nba_info;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    //Loads the Arrays for storing data to accept the data from the main activity
    private ArrayList<String> mImageNames;
    private ArrayList<String> mImages;
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images) {
        this.mImageNames = imageNames;
        this.mImages = images;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout,parent, false);
        ViewHolder holder = new ViewHolder(view);
        Log.d("hey3", "onCreate: 2");
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d("hey3", "onCreate: 3");

        //Load the details on the main page
        Glide.with(mContext).asBitmap().load(mImages.get(position)).into(holder.image);
        holder.imageName.setText(mImageNames.get(position));

        //Send over the data to the details page so it could display it
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragments(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("hey3", "onCreate: 1" + mImageNames.size());
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //Set the locations for the layouts
        ImageView image;
        TextView imageName;
        ConstraintLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.Image_A);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

    //Fragments
    public void switchFragments(int position){
        if (mContext == null){return;}

        if (mContext instanceof MainActivity){
            MainActivity mainActivity = (MainActivity) mContext;
            mainActivity.onInfoSent(mImages.get(position) , mImageNames.get(position), mImages.get(position) , mImageNames.get(position));
        }
    }
}
