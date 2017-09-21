package com.kinory.meltzer.parkinghunter.model;

/**
 * Created by meltzer on 21/09/2017.
 */

public class User {
    private String email = "";
    private String password = "";

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    protected void connectToApp(){

    }
    public void signUp(ListenerSigningUp listenerSigningUp){
        listenerSigningUp.signUpFinished(ErrorCode.success);
    }
}

interface ListenerSigningUp {
    public void signUpFinished(ErrorCode errorCode);
}
enum ErrorCode{
    success, error
}