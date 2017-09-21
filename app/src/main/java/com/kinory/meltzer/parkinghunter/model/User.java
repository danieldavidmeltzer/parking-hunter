package com.kinory.meltzer.parkinghunter.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by meltzer on 21/09/2017.
 */

public class User {

    /**
     *  the tag for the class
     */
    public static final String USR_TAG = "USR";
    /**
     * successful login tag
     */
    public static final String SUCCESSFUL_LOGIN_TAG = "sucsessful login";
    private String email = "";
    private String password = "";
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
    }

    /**
     * sign up the user
     * @param completeListener the listener to call after sign up
     */
    public void signUp(OnCompleteListener<AuthResult> completeListener) {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(completeListener);

    }

    /**
     *  log in the user to the app using email and password
     * @param completeListener the listener to call after log in
     */
    public void logIn(OnCompleteListener<AuthResult> completeListener)
    {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Log.d(USR_TAG, SUCCESSFUL_LOGIN_TAG);
                mUser = mAuth.getCurrentUser();
                completeListener.onComplete(task);
            }
            else{
                Log.d(USR_TAG, SUCCESSFUL_LOGIN_TAG);
                completeListener.onComplete(task);
            }
        });
    }


}

