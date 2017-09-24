package com.kinory.meltzer.parkinghunter.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

/**
 * Created by Gilad Kinory on 23/09/2017.
 * e-mail: giladkinory2000@gmail.com
 */

public class Utils {


    private static final String MAPS_API_KEY = "AIzaSyA7qYucw8vP0akzCxoh0uADnkeoWy9D2AM";
    private static final String REQUEST_ADDRESS_URL = "https://maps.googleapis.com/maps/api/geocode/json?latlng=%f,%f&sensor=true&key=%s&language=he";


    /**
     * Gets the address of a given location (latitude, longitude coordinates).
     * @param context The context (in order to execute the HTTP request).
     * @param latitude The latitude of the location.
     * @param longitude The longitude of the location.
     * @param listener A ResultListener to get the address.
     */
    public static void getAddressOfLocation(Context context, double latitude, double longitude, ResultListener<String> listener) {

        // Formats the url
        String url = String.format(Locale.getDefault(), REQUEST_ADDRESS_URL, latitude, longitude, MAPS_API_KEY);

        // Creates the request
        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {

            // Parses the JSON response
            try {

                // Gets the result and triggers the result listener
                JSONObject result = new JSONObject(response).getJSONArray("results").getJSONObject(0);
                listener.onGetResult(result.getString("formatted_address"));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, Throwable::printStackTrace);

        // Executes the request
        Volley.newRequestQueue(context).add(request);
    }

}
