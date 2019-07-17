package com.example.nba_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImageDesc = new ArrayList<>();
    private ArrayList<String> mLinks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing images");

        mImageUrls.add("https://www.nba.com/.element/img/1.0/teamsites/logos/teamlogos_500x500/bos.png");
        mNames.add("Celtics");
        mImageDesc.add("The Boston Celtics, based in Boston, Massachusetts compete in the National Basketball Association (NBA)as a member of the league's Eastern Conference Atlantic Division. Founded in 1946 as one of the league's original eight teams, the team play their home games at TD Garden, which they share with the National Hockey League (NHL)'s Boston Bruins. The Celtics are one of the most successful teams in NBA history; the franchise has won the most championships in the NBA with 17, accounting for 23.9 percent of all NBA championships since the league's founding.");
        mLinks.add("odZ4Zgjf6hM");

        mImageUrls.add("https://www.nba.com/.element/img/1.0/teamsites/logos/teamlogos_500x500/lal.png");
        mNames.add("Lakers");
        mImageDesc.add("The Los Angeles Lakers are an American professional basketball team based in Los Angeles. The Lakers compete in the National Basketball Association (NBA), as a member of the league's Western Conference in the Pacific Division. The Lakers play their home games at Staples Center, an arena shared with the NBA's Los Angeles Clippers, the Los Angeles Sparks of the Women's National Basketball Association, and the Los Angeles Kings of the National Hockey League. The Lakers are one of the most successful teams in the history of the NBA, and have won 16 NBA championships, the second-most behind the Boston Celtics.");
        mLinks.add("ECzuDTB-tmg");

        mImageUrls.add("https://www.caddocountry.net/wp-content/uploads/2018/12/houston_rockets-300x300.png");
        mNames.add("Rockets");
        mImageDesc.add("The Houston Rockets are an American professional basketball team based in Houston, Texas. The Rockets compete in the National Basketball Association (NBA) as a member of the league's Western Conference Southwest Division. The team plays its home games at the Toyota Center, located in downtown Houston. The Rockets have won two NBA championships and four Western Conference titles. The team was established in 1967 as the San Diego Rockets, an expansion team originally based in San Diego. In 1971, the Rockets moved to Houston.");
        mLinks.add("N6qj1qakVN4");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/6/67/Chicago_Bulls_logo.svg/200px-Chicago_Bulls_logo.svg.png");
        mNames.add("Chicago Bulls");
        mImageDesc.add("The Chicago Bulls are an American professional basketball team based in Chicago, Illinois. The Bulls compete in the National Basketball Association (NBA) as a member of the league's Eastern Conference Central Division. The team was founded on January 16, 1966. The team plays its home games at the United Center, an arena shared with the Chicago Blackhawks of the National Hockey League (NHL).");
        mLinks.add("yuurly9eZRI");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/0/01/Golden_State_Warriors_logo.svg/200px-Golden_State_Warriors_logo.svg.png");
        mNames.add("Golden State Warriors");
        mImageDesc.add("The Golden State Warriors are an American professional basketball team based in San Francisco, California. The Warriors compete in the National Basketball Association (NBA), as a member of the league's Western Conference Pacific Division. Founded in 1946 in Philadelphia, the Warriors relocated to the San Francisco Bay Area in 1962 and took the city's name, before changing its geographic moniker to Golden State in 1971. They will begin playing their home games at the Chase Center starting in October 2019.");
        mLinks.add("HR6BvC5IaN8");

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mImageDesc, mLinks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
