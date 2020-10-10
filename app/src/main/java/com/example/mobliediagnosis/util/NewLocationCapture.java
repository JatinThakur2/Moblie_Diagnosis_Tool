package com.example.mobliediagnosis.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Looper;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class NewLocationCapture {

    private static Context context;
    private static double latitude;
    private static double longitude;

    private static FusedLocationProviderClient fusedLocationProviderClient;
    private static LocationRequest locationRequest;
    private static LocationCallback locationCallback;

    NewLocationCapture() {
    }

    // Building location request.
    private static void buildLocationRequest() {
        System.out.println("()()()() BUILD_LOCATION_REQUEST");
        locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(500);
        locationRequest.setSmallestDisplacement(20);
    }

    // Building the LocationCallback.
    private static void buildLocationCallback() {
        System.out.println("()()()() BUILD_LOCATION_CALLBACK");
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                System.out.println("()()()() ON_LOCATION_RESULT");
                for (Location location : locationResult.getLocations()) {
                    System.out.println(("()()()() LOCATION " + location.getLatitude() + "||" + location.getLongitude()));
                }
            }
        };
    }

    // If we have to get location then this method is must to be called.
    public static void mandatoryForGettingLocation(Context context, Activity activity) {
        System.out.println("()()()() MANDATORY_FOR_GETTING_LOCATION");
        NewLocationCapture.context = context;
        buildLocationRequest();
        buildLocationCallback();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        startLocationService(activity);
    }

    public static void startLocationService(Activity activity) {
        System.out.println("()()()() START_LOCATION_SERVICE");
        if (ActivityCompat.checkSelfPermission(NewLocationCapture.context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
    }

    public static void stopLocationService() {
        System.out.println("()()()() STOP_LOCATION_SERVICE");
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

}