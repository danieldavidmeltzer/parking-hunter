package com.kinory.meltzer.parkinghunter.model;

/**
 * Created by Gilad Kinory on 21/09/2017.
 * e-mail: giladkinory2000@gmail.com
 */

public class DataManager {
    private static final DataManager ourInstance = new DataManager();

    static DataManager getInstance() {
        return ourInstance;
    }

    private DataManager() {
    }
}
