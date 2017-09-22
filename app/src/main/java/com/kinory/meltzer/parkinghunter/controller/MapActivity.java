package com.kinory.meltzer.parkinghunter.controller;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kinory.meltzer.parkinghunter.R;
import com.kinory.meltzer.parkinghunter.model.ParkingSpot;
import com.kinory.meltzer.parkinghunter.model.ParkingSpotFireBaseConnector;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Gets the map fragment
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);

        // Sets the callback on the fragment
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Adds a click listener
        googleMap.setOnMapClickListener(latLng -> {

            // Adds the clicked point to the map as a new marker
            googleMap.addMarker(new MarkerOptions().position(latLng));

            // Adds the clicked point to the database as a new parking spot
            ParkingSpotFireBaseConnector.saveParkingSpotToDatabase(new ParkingSpot(latLng.longitude, latLng.latitude));
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
