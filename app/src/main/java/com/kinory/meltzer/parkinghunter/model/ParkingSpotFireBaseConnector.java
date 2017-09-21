package com.kinory.meltzer.parkinghunter.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

/**
 * Created by meltzer on 21/09/2017.
 */

public class ParkingSpotFireBaseConnector extends Object {

    private static final String PARKING_SPOT_KEY ="parking_spots";

    private ParkingSpot parkingSpot;

    public ParkingSpotFireBaseConnector(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public void saveToDatabase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference parkingSpotsRef = database.getReference(PARKING_SPOT_KEY);
        String key = parkingSpotsRef.push().getKey();
        parkingSpotsRef.child(key).setValue(parkingSpot);
    }

}
