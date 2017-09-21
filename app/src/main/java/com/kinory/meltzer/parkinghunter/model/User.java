package com.kinory.meltzer.parkinghunter.model;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by meltzer on 21/09/2017.
 */

public class User {
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
    protected void connectToApp(){

    }

    /**
     * sign up the user
     * @param completeListener
     */
    public void signUp(OnCompleteListener<AuthResult> completeListener) {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(completeListener);

    }

    /**
     * Created by meltzer on 21/09/2017.
     */
    public static enum ErrorCode{
        success, error
    }

    /**
     * Created by meltzer on 21/09/2017.
     */
    public static interface ListenerSigningUp {
        public void signUpFinished(ErrorCode errorCode);
    }
}

