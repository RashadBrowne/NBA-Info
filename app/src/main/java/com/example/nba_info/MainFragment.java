package com.example.nba_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainFragment extends Fragment {

    private View RecyclerViewM;
    private RecyclerView recyclerView;

    private ArrayList<String> ImageNames;
    private ArrayList<String> ImageUrls;

    public MainFragment(){
        //Required public constructor for it to be called in other activities
    }

    public MainFragment(ArrayList<String> images, ArrayList<String> imageNames){//Main constructor
        ImageNames = imageNames;
        ImageUrls = images;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerViewM = inflater.inflate(R.layout.main_fragment,container, false);
        //Inflate the layout for the fragment

        //Put in the images and names for each item
        recyclerView = RecyclerViewM.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setItemViewCacheSize(20);
        //Keep all the items in cache so it only runs onbindviewholder once instead of when an item is retrieved from offscreen
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), ImageNames, ImageUrls);
        //Send over the information to the recycler view
        recyclerView.setHasFixedSize(true);
        //Since everything has a standard height
        recyclerView.setAdapter(adapter);

        return RecyclerViewM;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null){
            //fragmentActionListener = (MainActivity)getActivity();
        }
    }
}