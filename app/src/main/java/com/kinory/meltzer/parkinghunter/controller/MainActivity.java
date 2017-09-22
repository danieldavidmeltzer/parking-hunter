package com.kinory.meltzer.parkinghunter.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.kinory.meltzer.parkinghunter.R;
import com.kinory.meltzer.parkinghunter.model.DataManager;
import com.kinory.meltzer.parkinghunter.model.ParkingSpot;
import com.kinory.meltzer.parkinghunter.model.ParkingSpotFireBaseConnector;
import com.kinory.meltzer.parkinghunter.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.textView);
        ParkingSpot parkingSpot = new ParkingSpot(1, 1);
        String key = ParkingSpotFireBaseConnector.saveParkingSpotToDatabase(parkingSpot);
        ParkingSpotFireBaseConnector.getParkingSpotFromDatabase(key, parkingSpot1 -> {

          //  textView.setText(parkingSpot1.getLongitude() + ", " + parkingSpot1.getLatitude());
           // Toast.makeText(getApplicationContext(),parkingSpot1.getLongitude() + ", " + parkingSpot1.getLatitude(), Toast.LENGTH_LONG);
        });
        DataManager.getInstance().getCurrentUser().setEmail("m@m.com");
        DataManager.getInstance().getCurrentUser().setPassword("123456");
        DataManager.getInstance().getCurrentUser().logIn(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                textView.setText(DataManager.getInstance().getCurrentUser().getUserData().getFirstName());
            }
        });



    }

    public void moveToMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
