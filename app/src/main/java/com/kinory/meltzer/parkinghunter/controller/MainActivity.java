package com.kinory.meltzer.parkinghunter.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kinory.meltzer.parkinghunter.R;
import com.kinory.meltzer.parkinghunter.model.ParkingSpot;
import com.kinory.meltzer.parkinghunter.model.ParkingSpotFireBaseConnector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParkingSpot parkingSpot = new ParkingSpot(1, 1);
        String key = ParkingSpotFireBaseConnector.saveParkingSpotToDatabase(parkingSpot);
        ParkingSpotFireBaseConnector.getParkingSpotFromDatabase(key, parkingSpot1 -> {
            System.out.println(parkingSpot1.getLongitude() + ", " + parkingSpot1.getLatitude());
        });
    }
}
