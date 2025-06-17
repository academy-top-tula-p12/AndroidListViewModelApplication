package com.example.androidlistviewmodelapplication.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidlistviewmodelapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AirlineAdapter extends ArrayAdapter {
    private LayoutInflater inflater;
    private int itemLayout;
    private ArrayList<Airline> airlinesList;

    public AirlineAdapter(Context context, int layout, ArrayList<Airline> airlines){
        super(context, layout, airlines);
        this.airlinesList = airlines;
        this.itemLayout = layout;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View oldView, ViewGroup parent){

        ViewStore viewStore;

        if(oldView == null){
            oldView = inflater.inflate(this.itemLayout, parent, false);
            viewStore = new ViewStore(oldView);
            oldView.setTag(viewStore);
        }
        else{
            viewStore = (ViewStore) oldView.getTag();
        }

        Airline airline = airlinesList.get(position);

        viewStore.imageViewLogo.setImageResource(airline.getLogo());
        viewStore.textViewTitle.setText(airline.getTitle());
        viewStore.textViewCity.setText(airline.getCity());
        viewStore.textViewCount.setText(String.valueOf(airline.getCount()));

        viewStore.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                airline.setCount(airline.getCount() + 1);
                viewStore.textViewCount.setText(String.valueOf(airline.getCount()));
            }
        });

        viewStore.buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(airline.getCount() <= 0) return;

                airline.setCount(airline.getCount() - 1);
                viewStore.textViewCount.setText(String.valueOf(airline.getCount()));
            }
        });

        return oldView;
    }
}

class ViewStore{
    final ImageView imageViewLogo;
    final TextView textViewTitle;
    final TextView textViewCity;
    final TextView textViewCount;

    final Button buttonAdd;
    final Button buttonDel;

    ViewStore(View view){
        imageViewLogo = view.findViewById(R.id.imageViewLogo);
        textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewCity = view.findViewById(R.id.textViewCity);
        textViewCount = view.findViewById(R.id.textViewCount);
        buttonAdd = view.findViewById(R.id.buttonAdd);
        buttonDel = view.findViewById(R.id.buttonDel);
    }
}
