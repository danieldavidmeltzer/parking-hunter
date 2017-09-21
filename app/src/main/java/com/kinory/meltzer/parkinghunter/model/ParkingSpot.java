package com.kinory.meltzer.parkinghunter.model;

/**
 * Created by meltzer on 21/09/2017.
 */

public class ParkingSpot {

    private String key;
    private double longitude;
    private double latitude;
    private boolean isAvailable = true;

    public ParkingSpot() {}

    public ParkingSpot(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void takeParkingSpace() {
        setAvailable(false);
    }

    public void freeParkingSpace() {
        setAvailable(true);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
