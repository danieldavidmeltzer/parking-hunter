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

        void onParkingSpotUpdated(ParkingSpot parkingSpot);
    }

    private static final String PARKING_SPOT_KEY = "parking_spots";
    // Gets the database reference
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference parkingSpotsRef = database.getReference(PARKING_SPOT_KEY);
    /**
     * Saves a given ParkingSpot to the database
     * @param parkingSpot The parking spot to save
     * @return The key of the saved parking spot.
     */
    public static String saveParkingSpotToDatabase(ParkingSpot parkingSpot) {

        // Gets the database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference parkingSpotsRef = database.getReference(PARKING_SPOT_KEY);

        // Gets a unique key if needed
        if (parkingSpot.getUniqueKey() == null)
            parkingSpot.setUniqueKey(parkingSpotsRef.push().getKey());

        // Saves the data
        parkingSpotsRef.child(parkingSpot.getUniqueKey()).setValue(parkingSpot);

        return parkingSpot.getUniqueKey();
    }

    /**
     * Gets a parking spot with a given key from the database (each time it is updated)
     * @param key The key of the parking spot
     * @param listener The listener
     */
    public static void getParkingSpotFromDatabase(String key, ParkingSpotUpdateListener listener) {



        // Adds the value event listener
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
