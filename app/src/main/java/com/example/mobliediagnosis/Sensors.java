package com.example.mobliediagnosis;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Sensors extends AppCompatActivity {


    private CardView proximityBtn, accelerometerBtn, lightBtn, GPSBtn, magnetometerBtn, pressureBtn, gyroscopeBtn, gravitybtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        setTitle("Sensors");
        //set instance of Android's sensorManager to access sensor services
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //set up all button instances
        final TextView mNameEt = findViewById(R.id.proximityText);
        proximityBtn = findViewById(R.id.proximityBtn);
        accelerometerBtn = findViewById(R.id.accelerometerBtn);
        lightBtn = findViewById(R.id.lightBtn);
        GPSBtn = findViewById(R.id.GPSBtn);
        magnetometerBtn = findViewById(R.id.magnetometerBtn);
        pressureBtn = findViewById(R.id.pressureBtn);
        gyroscopeBtn=findViewById(R.id.gyroscopeBtn);
        gravitybtn=findViewById(R.id.gravitybtn);

        //add logic for each sensor where the button is disabled if that specific sensor is
        //not available on the current device. Notice that the GPS does
        //not have logic for this because all phones have GPS

        if(sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null) {

            //set listener for button
            proximityBtn.setOnClickListener(new View.OnClickListener () {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent proximityIntent = new Intent(Sensors.this, proximityActivity.class);
                    startActivity(proximityIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            proximityBtn.setEnabled(false);
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {

            //set listener for button
            accelerometerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent accelerometerIntent = new Intent(Sensors.this, accelerometerActivity.class);
                    startActivity(accelerometerIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            accelerometerBtn.setEnabled(false);
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {

            //set listener for button
            lightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent lightIntent = new Intent(Sensors.this, lightActivity.class);
                    startActivity(lightIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            lightBtn.setEnabled(false);
        }

        //GPS does not need if/ else statement
        GPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //add intent that takes use to the sensor's activity if the button pressed
                Intent GPSIntent = new Intent(Sensors.this, gps.class);
                startActivity(GPSIntent);
            }
        });

        if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {

            //set listener for button
            magnetometerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent magnetometerIntent = new Intent(Sensors.this, magnetometerActivity.class);
                    startActivity(magnetometerIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            magnetometerBtn.setEnabled(false);
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null) {

            //set listener for button
            gyroscopeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent magnetometerIntent = new Intent(Sensors.this, gyroscope.class);
                    startActivity(magnetometerIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            gyroscopeBtn.setEnabled(false);
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) != null) {

            //set listener for button
            gravitybtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent magnetometerIntent = new Intent(Sensors.this, Gravity.class);
                    startActivity(magnetometerIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            gravitybtn.setEnabled(false);
        }

        if(sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {

            //set listener for button
            pressureBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent pressureIntent = new Intent(Sensors.this, pressureActivity.class);
                    startActivity(pressureIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            pressureBtn.setEnabled(false);
        }
    }
}
