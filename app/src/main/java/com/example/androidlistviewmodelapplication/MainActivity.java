package com.example.androidlistviewmodelapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidlistviewmodelapplication.models.Airline;
import com.example.androidlistviewmodelapplication.models.AirlineAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Airline> airlines = new ArrayList<>();
    ListView listViewAirlines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAirlinesList();

        TextView textViewSelectedAirline = findViewById(R.id.textViewSelectedAirline);
        listViewAirlines = findViewById(R.id.listViewAirlines);
        AirlineAdapter airlineAdapter = new AirlineAdapter(this, R.layout.airline_item_layout, airlines);
        listViewAirlines.setAdapter(airlineAdapter);

        AdapterView.OnItemClickListener itemSelectedListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Airline airlineSelected = (Airline) parent.getItemAtPosition(position);
                textViewSelectedAirline.setText(airlineSelected.getTitle());
            }
        };

        listViewAirlines.setOnItemClickListener(itemSelectedListener);
    }

    private void initAirlinesList(){
        airlines.add(new Airline("Aeroflot", "Moscow", R.drawable.logo_aeroflot));
        airlines.add(new Airline("NordStar", "Krasnoyarsk", R.drawable.logo_nordstar));
        airlines.add(new Airline("S7 Airlines", "Novosibirsk", R.drawable.logo_s7));
        airlines.add(new Airline("Ural", "Yekaterinburg", R.drawable.logo_ural));
        airlines.add(new Airline("Yamal", "Salehard", R.drawable.logo_yamal));
    }
}