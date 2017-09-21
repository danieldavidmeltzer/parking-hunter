package com.kinory.meltzer.parkinghunter.model;

/**
 * Created by meltzer on 21/09/2017.
 */

import java.util.ArrayList;

/**
 * a class that holds the data of the app
 */
public class DataManager {
    /**
     *  the shared instance that holds the pointer
     */
    private static final DataManager sharedInstance = new DataManager();


    /**
     * the user that uses currently the app
     */
    private User currentUser = new User();

    /**
     *  an ArrayList that holds the parking spot that should be used in the app
     */
    private ArrayList<ParkingSpot> parkingSpotArrayList = new ArrayList<ParkingSpot>();

    /**
     *
     * @return the singleton instance of the data
     */
    public  static DataManager getInstance() {
        return sharedInstance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<ParkingSpot> getParkingSpotArrayList() {
        return parkingSpotArrayList;
    }

    /**
     * constructor of data manger
     */
    private DataManager() {
    }
}
