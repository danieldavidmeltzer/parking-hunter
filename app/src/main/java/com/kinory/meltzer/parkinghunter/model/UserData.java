package com.kinory.meltzer.parkinghunter.model;

import java.util.Date;

/**
 * Created by meltzer on 21/09/2017.
 */

public class UserData {
    private String firstName = "";
    private String lastName = "";
    private long Score = 0;
    private String uniqueId = "";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getScore() {
        return Score;
    }

    public void setScore(long score) {
        Score = score;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
