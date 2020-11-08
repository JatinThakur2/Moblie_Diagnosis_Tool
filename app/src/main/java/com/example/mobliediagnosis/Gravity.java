package com.example.mobliediagnosis;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

;

public class Gravity extends AppCompatActivity implements SensorEventListener {

    //set instances for the sensorManager, accelerometer, and textViews
    private SensorManager sensorManager;
    private Sensor Gravity;
    private TextView xValue;
    private TextView yValue;
    private TextView zValue;

    public void onSensorChanged(SensorEvent sensorEvent) {

        //get the current values of the accelerometer for each axis
        setTitle("Gravity");
        float current_xValue = sensorEvent.values[0];
        float current_yValue = sensorEvent.values[1];
        float current_zValue = sensorEvent.values[2];

        //display the current values of the  accelerometer for each axis onto the
        //textView widgets
        xValue.setText(getResources().getString(R.string.Gravity_x_value, current_xValue));
        yValue.setText(getResources().getString(R.string.Gravity_y_value, current_yValue));
        zValue.setText(getResources().getString(R.string.Gravity_z_value, current_zValue));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

        //accelerometer does not report accuracy changes
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);

        //retrieve widgets
        xValue = findViewById(R.id.xValue);
        yValue = findViewById(R.id.yValue);
        zValue = findViewById(R.id.zValue);

        //define instances
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Gravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
    }

    //register the listener once the activity starts
    @Override
    protected void onStart() {
        super.onStart();

        if(Gravity != null) {

            sensorManager.registerListener(this, Gravity, sensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    //stop the sensor when the activity stops to reduce battery usage
    @Override
    protected void onStop() {
        super.onStop();

        sensorManager.unregisterListener(this);
    }
}