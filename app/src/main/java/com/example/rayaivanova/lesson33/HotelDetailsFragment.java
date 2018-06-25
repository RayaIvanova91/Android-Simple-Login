package com.example.rayaivanova.lesson33;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rayaivanova.lesson33.model.Hotel;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelDetailsFragment extends Fragment implements Serializable{

    public interface DetailsComunicator {
        void backToHotels();
    }

    private ImageView image;
    private TextView hotelName;
    private TextView rating;
    private TextView address;
    private TextView price;
    private Button back;

    public HotelDetailsFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hotel_details, container, false);
        if (getArguments() != null && getArguments().getSerializable("hotel") != null) {
            Hotel hotel = (Hotel) getArguments().getSerializable("hotel");
            image = root.findViewById(R.id.hotel_image);
            image.setImageResource(hotel.getImage());

            hotelName = root.findViewById(R.id.hotel_name);
            hotelName.setText(hotel.getName());

            rating = root.findViewById(R.id.hotel_rating_num);
            rating.setText("" + hotel.getRating());

            address = root.findViewById(R.id.hotel_address);
            address.setText(hotel.getAddress());

            price = root.findViewById(R.id.hotel_price);
            price.setText(price.getText() + " " + hotel.getPrice() + " " + getResources().getString(R.string.currency));

            back = root.findViewById(R.id.back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getActivity() instanceof DetailsComunicator) {
                        ((DetailsComunicator) getActivity()).backToHotels();
                    }
                }
            });
        }

        //setRetainInstance(true);
        Log.e("Details Tag ", this.getTag());
        return root;
    }

}
