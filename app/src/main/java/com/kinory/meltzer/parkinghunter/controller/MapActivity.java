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

        // Adds a marker titled "Marker" in (0,0)
        googleMap.addMarker(
                new MarkerOptions()
                        .position(new LatLng(0, 0))
                        .title("Marker"));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
