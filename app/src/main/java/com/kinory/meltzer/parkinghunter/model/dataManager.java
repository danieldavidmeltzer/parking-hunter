package com.kinory.meltzer.parkinghunter.model;
//

/**
 * Created by meltzer on 20/09/2017.
 */

class dataManager {
    private static final dataManager ourInstance = new dataManager();

    static dataManager getInstance() {
        return ourInstance;
    }

    private dataManager() {
    }
}
