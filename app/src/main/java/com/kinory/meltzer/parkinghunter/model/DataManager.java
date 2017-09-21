package com.kinory.meltzer.parkinghunter.model;
//

/**
 * Created by meltzer on 20/09/2017.
 */

class DataManager {
    private static final DataManager ourInstance = new DataManager();

    static DataManager getInstance() {
        return ourInstance;
    }

    private DataManager() {
    }
}
