package com.kinory.meltzer.parkinghunter.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.kinory.meltzer.parkinghunter.R;
import com.kinory.meltzer.parkinghunter.model.DataManager;

public class SignUpActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ((Button)findViewById(R.id.registerBTN)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                settingDataFromActivityBeforeSigningUp();
                DataManager.getInstance().getCurrentUser().signUp(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    /**
     * This method is a helper method which sets the data that user has written down
     * to the model before starting singing up process
     */
    private void settingDataFromActivityBeforeSigningUp() {
        EditText passwordEditText = (EditText)findViewById(R.id.pass);
        EditText firstNameEditText = (EditText)findViewById(R.id.firstNameEditTextSignUpScreen);
        EditText lastNameEditText = (EditText)findViewById(R.id.lastNameEditTextSignUpScreen);
        EditText emailEditText = (EditText)findViewById(R.id.emailEditTextSignUpScreen);
        DataManager.getInstance().getCurrentUser().setPassword(passwordEditText.getText().toString());
        DataManager.getInstance().getCurrentUser().setEmail(emailEditText.getText().toString());
        DataManager.getInstance().getCurrentUser().getUserData().setFirstName(firstNameEditText.getText().toString());
        DataManager.getInstance().getCurrentUser().getUserData().setLastName(lastNameEditText.getText().toString());
    }

}
