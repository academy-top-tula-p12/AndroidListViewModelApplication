package com.example.androidlistviewmodelapplication.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidlistviewmodelapplication.R;

import java.util.List;

public class AirlineAdapter extends ArrayAdapter {
    private LayoutInflater inflater;
    private int itemLayout;
    private List<Airline> airlinesList;

    public AirlineAdapter(Context context, int layout, List<Airline> airlines){
        super(context, layout, airlines);
        this.airlinesList = airlines;
        this.itemLayout = layout;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View oldView, ViewGroup parent){
        View view = inflater.inflate(this.itemLayout, parent, false);

        ImageView imageViewLogo = view.findViewById(R.id.imageViewLogo);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        TextView textViewCity = view.findViewById(R.id.textViewCity);

        Airline airline = airlinesList.get(position);

        imageViewLogo.setImageResource(airline.getLogo());
        textViewTitle.setText(airline.getTitle());
        textViewCity.setText(airline.getCity());

        return view;
    }
}
