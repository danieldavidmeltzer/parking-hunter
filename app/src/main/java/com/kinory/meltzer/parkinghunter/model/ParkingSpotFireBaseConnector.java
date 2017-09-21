package com.kinory.meltzer.parkinghunter.model;

import java.util.Objects;

/**
 * Created by meltzer on 21/09/2017.
 */

public class ParkingSpotFireBaseConnector extends Object {

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


}
