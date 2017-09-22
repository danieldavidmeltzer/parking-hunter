package com.kinory.meltzer.parkinghunter.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;

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
    public static final String SUCCESSFUL_LOGIN_TAG = "successful login";

    /**
     * failed successful tag
     */
    public static final String UNSUCCESSFUL_LOGIN_TAG = "failed login";

    /**
     * user email
     */
    private String email = "";

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * user password
     */
    private String password = "";

    /**
     * Firebase auth, used for authentication
     */
    private FirebaseAuth mAuth;

    //the user in Firebase
    private FirebaseUser mUser;

    // the data of the user
    private UserData userData = new UserData();

    //Initialize user data
    public User() {
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
                UserDataFirebaseConnector.getSharedInstance().syncUserData(mUser.getUid(), new UserDataFirebaseConnector.UserDataFireBaseConnectorSyncingInterface() {
                    @Override
                    public void userDataUpdated(UserData usrData, DatabaseError databaseError) {
                        if(databaseError == null) {
                            userData = usrData;
                            UserDataFirebaseConnector.getSharedInstance().unSyncUserData(mUser.getUid());
                            completeListener.onComplete(task);
                        }
                    }
                });

            }
            else{
                Log.d(USR_TAG, UNSUCCESSFUL_LOGIN_TAG);
                completeListener.onComplete(task);
            }
        });
    }

    /**
     * check if user is connected
     * @return true if user is connected, false otherwise
     */
    protected boolean isConnected(){
        return mUser != null;
    }

    /**
     * get user data
     * @return user data
     */
    public UserData getUserData() {
        return userData;
    }


}

