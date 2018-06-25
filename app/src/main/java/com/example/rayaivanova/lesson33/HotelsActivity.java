package com.example.rayaivanova.lesson33;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.rayaivanova.lesson33.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelsActivity extends AppCompatActivity implements HotelDetailsFragment.DetailsComunicator, HotelListFragment.HotelListComunicator {

    private RecyclerView recyclerView;
    private List<Hotel> hotels;
    Fragment allHotels;
    Hotel hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fTransaction = fm.beginTransaction();
        allHotels = new HotelListFragment();

        if (findViewById(R.id.land_id) == null) {

            fTransaction.replace(R.id.hotels_activity, allHotels, "HotelList").commit();
        } else {
            Log.e("mamati", findViewById(R.id.land_id) == null ? "null" : "not null");
            fTransaction.replace(R.id.land_id, allHotels, "HotelList").commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("HotelsActivity", "onDestroy");
    }

    @Override
    public void showDetails(Hotel hotel) {
        FragmentManager fm = getSupportFragmentManager();

        Bundle bundle = new Bundle();
        bundle.putSerializable("hotel", hotel);
        HotelDetailsFragment hotelDetailsFragment = new HotelDetailsFragment();
        hotelDetailsFragment.setArguments(bundle);
        FragmentTransaction fTransaction = fm.beginTransaction();

        if (findViewById(R.id.land_id) == null) {
            //portrait mode
            //do whatever we do in portrait - replace fragment
            fTransaction.replace(R.id.hotels_activity, hotelDetailsFragment, "HotelDetails").commit();
        } else {
            //land mode
            //add fragment
            //if no details on screen, add fragment
            if (fm.findFragmentByTag("HotelDetails") == null) {
                fTransaction.add(R.id.land_id, hotelDetailsFragment, "HotelDetails").commit();
            }
            //if any details in landscape, replace just the details fragment (not all fragments on the screen)
            else {
                fTransaction.remove(fm.findFragmentByTag("HotelDetails")).add(R.id.land_id, hotelDetailsFragment, "HotelDetails").commit();
            }
        }
    }

    @Override
    public void backToHotels() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //in landscape remove details and only the list should stay
        if(findViewById(R.id.land_id)!=null){
            ft.remove(fm.findFragmentByTag("HotelDetails")).commit();
        }
        //in portrait replace the details with the list
        else{
        allHotels = new HotelListFragment();
        ft.replace(R.id.hotels_activity, allHotels, "HotelList").commit();}
    }

}
