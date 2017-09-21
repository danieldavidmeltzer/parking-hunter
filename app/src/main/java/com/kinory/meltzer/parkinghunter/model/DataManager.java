package com.kinory.meltzer.parkinghunter.model;

/**
 * Created by meltzer on 21/09/2017.
 */

/**
 * a class that holds the data of the app
 */
public class DataManager {
    /**
     *  the shared instance that holds the pointer
     */
    private static final DataManager sharedInstance = new DataManager();

    /**
     *
     * @return the singleton instance of the data
     */
    static DataManager getInstance() {
        return sharedInstance;
    }

    /**
     * constructor of data manger
     */
    private DataManager() {
    }
}
