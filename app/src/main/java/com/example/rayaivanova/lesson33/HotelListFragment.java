package com.example.rayaivanova.lesson33;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rayaivanova.lesson33.model.Hotel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class  HotelListFragment extends Fragment {
    RecyclerView recyclerView;
    private List<Hotel> hotels;

    public HotelListFragment() {

    }

    public interface HotelListComunicator {
        void showDetails(Hotel hotel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_hotel_list, container, false);

        //1) namiram konkretnoto RecyclerView
        recyclerView = root.findViewById(R.id.hotels);

        //2) List s hoteli
        hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel(3, R.drawable.hotel1, "Aspria Hamburg", 7.5, "Winterhude, Hamburg", 12, 220, true));
        hotels.add(new Hotel(2, R.drawable.hotel2, "Holiday Inn", 8.3, "St. Pauli, Hamburg", 5, 350, true));
        hotels.add(new Hotel(0, R.drawable.hotel3, "Hotel Mare", 5, "Hamburg City Center (New Town), Hamburg", 15, 100, false));
        hotels.add(new Hotel(5, R.drawable.hotel4, "Dorint Hotel", 9, "St. Georg, Hamburg", 2, 400, true));
        hotels.add(new Hotel(4, R.drawable.hotel5, "Crowne Plaza", 8, "Hamburg City Center (Old Town), Hamburg", 4, 300, false));
        hotels.add(new Hotel(2, R.drawable.hotel6, "NIPPON HOTEL Hamburg Boutique 072 Hamburg St. Georg", 4, "Harvestehude, Hamburg", 10, 150, false));
        hotels.add(new Hotel(5, R.drawable.hotel7, "Sofitel Hamburg", 7, "Stellingen, Hamburg", 11, 50, true));
        hotels.add(new Hotel(1, R.drawable.hotel8, "Hyperion Hotel", 7.5, "Lokstedt, Hamburg", 4, 800, false));
        hotels.add(new Hotel(1, R.drawable.hotel1, "Aspria Hamburg", 7.5, "Winterhude, Hamburg", 12, 220, true));
        hotels.add(new Hotel(4, R.drawable.hotel2, "Holiday Inn", 8.3, "St. Pauli, Hamburg", 5, 350, true));
        hotels.add(new Hotel(5, R.drawable.hotel3, "Hotel Mare", 5, "Hamburg City Center (New Town), Hamburg", 15, 100, false));
        hotels.add(new Hotel(5, R.drawable.hotel4, "Dorint Hotel", 9, "St. Georg, Hamburg", 2, 400, true));
        hotels.add(new Hotel(4, R.drawable.hotel5, "Crowne Plaza", 8, "Hamburg City Center (Old Town), Hamburg", 4, 300, false));
        hotels.add(new Hotel(3, R.drawable.hotel6, "NIPPON HOTEL Hamburg", 4, "Harvestehude, Hamburg", 10, 150, false));
        hotels.add(new Hotel(5, R.drawable.hotel7, "Sofitel Hamburg", 7, "Stellingen, Hamburg", 11, 50, true));
        hotels.add(new Hotel(5, R.drawable.hotel8, "Hyperion Hotel", 7.5, "Lokstedt, Hamburg", 4, 800, false));
        hotels.add(new Hotel(5, R.drawable.hotel1, "Aspria Hamburg", 7.5, "Winterhude, Hamburg", 12, 220, true));
        hotels.add(new Hotel(2, R.drawable.hotel2, "Holiday Inn", 8.3, "St. Pauli, Hamburg", 5, 350, true));
        hotels.add(new Hotel(4, R.drawable.hotel3, "Hotel Mare", 5, "Hamburg City Center (New Town), Hamburg", 15, 100, false));
        hotels.add(new Hotel(4, R.drawable.hotel4, "Dorint Hotel", 9, "St. Georg, Hamburg", 2, 400, true));
        hotels.add(new Hotel(5, R.drawable.hotel5, "Crowne Plaza", 8, "Hamburg City Center (Old Town), Hamburg", 4, 300, false));
        hotels.add(new Hotel(4, R.drawable.hotel6, "NIPPON HOTEL Hamburg", 4, "Harvestehude, Hamburg", 10, 150, false));
        hotels.add(new Hotel(1, R.drawable.hotel7, "Sofitel Hamburg", 7, "Stellingen, Hamburg", 11, 50, true));
        hotels.add(new Hotel(4, R.drawable.hotel8, "Hyperion Hotel", 7.5, "Lokstedt, Hamburg", 4, 800, false));

        //3) Adapter i LayoutManager na RecyclerView-to
        recyclerView.setAdapter(new HotelAdapter(hotels, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }

}
