package com.example.rayaivanova.lesson33;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.rayaivanova.lesson33.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private List<Hotel> hotels;
    private Context context;

    HotelAdapter(List<Hotel> hotels, Context context) {
        this.hotels = hotels;
        this.context = context;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View hotelRow = inflater.inflate(R.layout.hotel, parent, false);
        return new HotelViewHolder(hotelRow);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        Hotel hotel = hotels.get(position);
        holder.image.setImageResource(hotel.getImage());
        holder.name.setText(hotel.getName());
        double rating = hotel.getRating();
        holder.rating.setText("" + rating);
        String hotelRating = getStringRating(rating);
        holder.ratingString.setText(hotelRating);
        holder.address.setText("" + hotel.getDistanceFromCenter() + context.getResources().getString(R.string.distance)+" " + hotel.getAddress());
        holder.price.setText("" + hotel.getPrice() + context.getResources().getString(R.string.currency));
        holder.prepayment.setText("");
        for (int i=0; i<5;i++){
            holder.stars.get(i).setVisibility(View.INVISIBLE);
        }
        if(hotel.getCountStars()>Hotel.MIN_STARS_COUNT){
            int numStars=hotel.getCountStars();
            for (int i=0; i<numStars;i++){
                holder.stars.get(i).setVisibility(View.VISIBLE);
            }
        }
        if (context instanceof HotelsActivity) {
            if (!hotel.isPrepayment()) {
                holder.prepayment.setText(context.getResources().getString(R.string.noPrepayment));
            }
        }
    }

    @NonNull
    private String getStringRating(double rating) {
        String hotelRating = "";
        if (rating < 8) {
            hotelRating = context.getResources().getString(R.string.good);
        }
        if (rating >= 8 && rating <= 8.5) {
            hotelRating = context.getResources().getString(R.string.veryGood);
        }
        if (rating > 8.5 && rating < 9) {
            hotelRating = context.getResources().getString(R.string.excellent);
        }
        if (rating >= 9) {
            hotelRating = context.getResources().getString(R.string.wonderful);
        }
        return hotelRating;
    }


    @Override
    public int getItemCount() {
        return hotels.size();
    }


    //the View Holder
    class HotelViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        List<RatingBar> stars;
        TextView rating;
        TextView ratingString;
        TextView address;
        TextView prepayment;
        TextView price;

        HotelViewHolder(View v) {
            super(v);
            stars=new ArrayList<>();
            this.image = v.findViewById(R.id.hotel_image);
            this.name = v.findViewById(R.id.hotel_name);
            this.rating = v.findViewById(R.id.hotel_rating_num);
            this.ratingString = v.findViewById(R.id.hotel_rating_string);
            this.address = v.findViewById(R.id.hotel_address);
            this.prepayment = v.findViewById(R.id.hotel_prepayment);
            this.price = v.findViewById(R.id.hotel_price);
            stars.add((RatingBar) v.findViewById(R.id.hotel_ratingStar1));
            stars.add((RatingBar) v.findViewById(R.id.hotel_ratingStar2));
            stars.add((RatingBar) v.findViewById(R.id.hotel_ratingStar3));
            stars.add((RatingBar) v.findViewById(R.id.hotel_ratingStar4));
            stars.add((RatingBar) v.findViewById(R.id.hotel_ratingStar5));

        }
    }
}
