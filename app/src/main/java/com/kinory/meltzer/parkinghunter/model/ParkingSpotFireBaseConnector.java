package com.kinory.meltzer.parkinghunter.model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

/**
 * Created by meltzer on 21/09/2017.
 */

public class ParkingSpotFireBaseConnector {

    public interface ParkingSpotUpdateListener {

        public void onParkingSpotUpdated(ParkingSpot parkingSpot);
    }

    private static final String PARKING_SPOT_KEY ="parking_spots";

    /**
     * Saves a given ParkingSpot to the database
     * @param parkingSpot The parking spot to save
     * @return The key of the saved parking spot.
     */
    public static String saveParkingSpotToDatabase(ParkingSpot parkingSpot) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference parkingSpotsRef = database.getReference(PARKING_SPOT_KEY);

        // Gets a unique key if needed
        if (parkingSpot.getKey() == null)
            parkingSpot.setKey(parkingSpotsRef.push().getKey());

        parkingSpotsRef.child(parkingSpot.getKey()).setValue(parkingSpot);
        return parkingSpot.getKey();
    }

    public static void getParkingSpotFromDatabase(String key, ParkingSpotUpdateListener listener) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference parkingSpotsRef = database.getReference(PARKING_SPOT_KEY);
        parkingSpotsRef.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ParkingSpot parkingSpot = dataSnapshot.getValue(ParkingSpot.class);
                listener.onParkingSpotUpdated(parkingSpot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

    }

}
