package com.example.nba_info;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
    SendInfoListener sendInfo;//Create an instance of my interface listener

    //Arrays to hold data for the recycler view
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImageDesc = new ArrayList<>();
    private ArrayList<String> mLinks = new ArrayList<>();


    //Fragment interface
    public interface SendInfoListener {
        void StartDetailFrag(String Url, String Name, String Desc, String Link);
    }

    @Override
    public void onAttach(Context context) {//Make sure it uses the implementation or crash
        super.onAttach(context);
        Activity activty = (Activity) context;

        try {
            sendInfo = (SendInfoListener) activty;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + "doesn't have the listener implementation");
        }
    }

    //Regular Fragment Stuff
    public MainFragment(){
        //Required public constructor for it to be called in other activities and after a config change
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // if (savedInstanceState == null){

            RecyclerViewM = inflater.inflate(R.layout.main_fragment,container, false);
            //Inflate the layout for the fragment, this way we can attach items to views without calling "onViewCreated"

            recyclerView = RecyclerViewM.findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            initImageBitmaps();
            recyclerView.setItemViewCacheSize(20);
            //Keep all the items in cache so it only runs onbindviewholder once instead of when an item is retrieved from offscreen
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), mNames, mImageUrls, mImageDesc, mLinks);//Innit the recyclerview
            recyclerView.setHasFixedSize(true);//Since everything has a standard height
            recyclerView.setAdapter(adapter);
        //}
        return RecyclerViewM;
    }

    //My code
    private void initImageBitmaps() {
        //Load everything for the recycler view
        mImageUrls.add("https://www.nba.com/.element/img/1.0/teamsites/logos/teamlogos_500x500/bos.png");
        mNames.add("Boston Celtics");
        mImageDesc.add("The Boston Celtics, based in Boston, Massachusetts compete in the National Basketball Association (NBA)as a member of the league's Eastern Conference Atlantic Division. Founded in 1946 as one of the league's original eight teams, the team play their home games at TD Garden, which they share with the National Hockey League (NHL)'s Boston Bruins. The Celtics are one of the most successful teams in NBA history; the franchise has won the most championships in the NBA with 17, accounting for 23.9 percent of all NBA championships since the league's founding.");
        mLinks.add("odZ4Zgjf6hM");

        mImageUrls.add("https://www.nba.com/.element/img/1.0/teamsites/logos/teamlogos_500x500/lal.png");
        mNames.add("Los Angeles Lakers");
        mImageDesc.add("The Los Angeles Lakers are an American professional basketball team based in Los Angeles. The Lakers compete in the National Basketball Association (NBA), as a member of the league's Western Conference in the Pacific Division. The Lakers play their home games at Staples Center, an arena shared with the NBA's Los Angeles Clippers, the Los Angeles Sparks of the Women's National Basketball Association, and the Los Angeles Kings of the National Hockey League. The Lakers are one of the most successful teams in the history of the NBA, and have won 16 NBA championships, the second-most behind the Boston Celtics.");
        mLinks.add("ECzuDTB-tmg");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/0/01/Golden_State_Warriors_logo.svg/200px-Golden_State_Warriors_logo.svg.png");
        mNames.add("Golden State Warriors");
        mImageDesc.add("The Golden State Warriors are an American professional basketball team based in San Francisco, California. The Warriors compete in the National Basketball Association (NBA), as a member of the league's Western Conference Pacific Division. Founded in 1946 in Philadelphia, the Warriors relocated to the San Francisco Bay Area in 1962 and took the city's name, before changing its geographic moniker to Golden State in 1971. They will begin playing their home games at the Chase Center starting in October 2019.");
        mLinks.add("HR6BvC5IaN8");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/3/36/Toronto_Raptors_logo.svg/200px-Toronto_Raptors_logo.svg.png");
        mNames.add("Toronto Raptors");
        mImageDesc.add("The Toronto Raptors are a Canadian professional basketball team based in Toronto, Ontario. The Raptors compete in the National Basketball Association (NBA) as a member club of the league's Eastern Conference Atlantic Division. They play their home games at the Scotiabank Arena, which they share with the Toronto Maple Leafs of the National Hockey League (NHL). The team was founded in 1995 as part of the NBA's expansion into Canada, along with the Vancouver Grizzlies. Since the 2001–02 season, the Raptors have been the only Canadian-based team in the league, as the Grizzlies relocated from Vancouver, British Columbia to Memphis, Tennessee.");
        mLinks.add("CDHw1HYiJt0");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/b/bb/Los_Angeles_Clippers_%282015%29.svg/284px-Los_Angeles_Clippers_%282015%29.svg.png");
        mNames.add("Los Angeles Clippers");
        mImageDesc.add("The Los Angeles Clippers (branded as the LA Clippers) are an American professional basketball team based in Los Angeles. The Clippers compete in the National Basketball Association (NBA) as a member of Pacific Division of the league's Western Conference. The Clippers play their home games at the Staples Center, an arena they share with fellow NBA team the Los Angeles Lakers, as well as the Los Angeles Sparks of the Women's National Basketball Association (WNBA) and the Los Angeles Kings of the National Hockey League (NHL).");
        mLinks.add("kUvzJGYpKmI");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/a/a2/San_Antonio_Spurs.svg/200px-San_Antonio_Spurs.svg.png");
        mNames.add("San Antonio Spurs");
        mImageDesc.add("The San Antonio Spurs are an American professional basketball team based in San Antonio, Texas. The Spurs compete in the National Basketball Association (NBA) as a member of the league's Western Conference Southwest Division. The team plays its home games at the AT&T Center in San Antonio.");
        mLinks.add("TpTE7SHLNy4");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/1/1b/Indiana_Pacers.svg/240px-Indiana_Pacers.svg.png");
        mNames.add("Indiana Pacers");
        mImageDesc.add("The Indiana Pacers are an American professional basketball team based in Indianapolis, Indiana. The Pacers compete in the National Basketball Association (NBA) as a member club of the league's Eastern Conference Central Division. The Pacers were first established in 1967 as a member of the American Basketball Association (ABA) and became a member of the NBA in 1976 as a result of the ABA–NBA merger. They play their home games at Bankers Life Fieldhouse. The team is named after Indiana's history with the Indianapolis 500's pace cars and with the harness racing industry.");
        mLinks.add("lwYNz6oBW70");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/5/5d/Oklahoma_City_Thunder.svg/200px-Oklahoma_City_Thunder.svg.png");
        mNames.add("Oklahoma City Thunder");
        mImageDesc.add("The Oklahoma City Thunder are an American professional basketball team based in Oklahoma City, Oklahoma. The Thunder compete in the National Basketball Association (NBA) as a member of the league's Western Conference Northwest Division.The team plays its home games at Chesapeake Energy Arena.");
        mLinks.add("wc0JPiHEUmg");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/2/25/New_York_Knicks_logo.svg/200px-New_York_Knicks_logo.svg.png");
        mNames.add("New York Knicks");
        mImageDesc.add("The New York Knickerbockers, more commonly referred to as the Knicks, are an American professional basketball team based in the New York City borough of Manhattan. The Knicks compete in the National Basketball Association (NBA) as a member of the Atlantic Division of the Eastern Conference. The team plays its home games at Madison Square Garden, an arena they share with the New York Rangers of the National Hockey League (NHL). They are one of two NBA teams located in New York City; the other is the Brooklyn Nets. Alongside the Boston Celtics, the Knicks are one of two original NBA teams still located in its original city.");
        mLinks.add("8rncU5eS90E");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/6/67/Chicago_Bulls_logo.svg/200px-Chicago_Bulls_logo.svg.png");
        mNames.add("Chicago Bulls");
        mImageDesc.add("The Chicago Bulls are an American professional basketball team based in Chicago, Illinois. The Bulls compete in the National Basketball Association (NBA) as a member of the league's Eastern Conference Central Division. The team was founded on January 16, 1966. The team plays its home games at the United Center, an arena shared with the Chicago Blackhawks of the National Hockey League (NHL).");
        mLinks.add("yuurly9eZRI");

        mImageUrls.add("https://www.caddocountry.net/wp-content/uploads/2018/12/houston_rockets-300x300.png");
        mNames.add("Rockets");
        mImageDesc.add("The Houston Rockets are an American professional basketball team based in Houston, Texas. The Rockets compete in the National Basketball Association (NBA) as a member of the league's Western Conference Southwest Division. The team plays its home games at the Toyota Center, located in downtown Houston. The Rockets have won two NBA championships and four Western Conference titles. The team was established in 1967 as the San Diego Rockets, an expansion team originally based in San Diego. In 1971, the Rockets moved to Houston.");
        mLinks.add("N6qj1qakVN4");
    }
}