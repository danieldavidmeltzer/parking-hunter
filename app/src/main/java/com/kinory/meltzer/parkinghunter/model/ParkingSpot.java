package com.kinory.meltzer.parkinghunter.model;

/**
 * Created by meltzer on 21/09/2017.
 */

public class ParkingSpot {

    /**
     * the unique key of the parking spot
     */
    private String uniqueKey;

    /**
     * the longitude of the parking spot
     */
    private double longitude;

    /**
     * the latitude of the parking spot
     */
    private double latitude;

    /**
     * boolean to the determine is the parking spot available
     */
    private boolean isAvailable = true;

    /**
     * empty constructor, please don't delete as for fireabse uses it
     * @important: don't delete, firebase uses
     */
    public ParkingSpot() {}

    /**
     * constructor for parking spot using longitude and latitude
     * @param longitude longitude of the parking spot
     * @param latitude latitude of the parking spot
     */
    public ParkingSpot(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * get the longitude of the parking spot
     * @return the longitude of the parking spot
     */
    public double getLongitude() {
        return longitude;
    }

    /***
     * set the longitude of the parking spot
     * @param longitude  the longitude of the parking spot to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * get the latitude of the parking spot
     * @return the latitude of the parking spot
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * set latitude of the parking spot
     * @param latitude the latitude of the parking spot to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * check if the parking spot is available
     * @return true if the parking spot is available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * set the parking spot availability, should be used only within the class
     * @param available true if the spot available, false otherwise.
     */
    private void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * make the parking space unavailable
     */
    public void takeParkingSpace() {
        setAvailable(false);
    }

    /**
     * make the parking space available
     */
    public void freeParkingSpace() {
        setAvailable(true);
    }

    /**
     * get the uniqueKey of the parking spot
     * @return the uniqueKey of the parking spot
     */
    public String getUniqueKey() {
        return uniqueKey;
    }

    /***
     * set the unique key of the parking spot
     * @param uniqueKey the parking spot unique id
     */
    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
}
