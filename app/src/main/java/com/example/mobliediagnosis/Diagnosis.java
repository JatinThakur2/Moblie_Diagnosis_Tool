package com.example.mobliediagnosis;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Diagnosis extends AppCompatActivity {

    private CardView phoneinfo1, battery1, bluetooth1, wifi1, ram1, storage1, cpu1, networkinfo1, fingerprint1, Sensors1,
            vibrator1, flashlight1, speaker1, rearcamera1, brightness1, multitouch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("DIAGNOSIS");

        final TextView mNameEt = findViewById(R.id.phoneinfotext);
        phoneinfo1 = (CardView) findViewById(R.id.phoneinfo);
        battery1 = (CardView) findViewById(R.id.battery);
        bluetooth1 = (CardView) findViewById(R.id.bluetooth);
        cpu1 = (CardView) findViewById(R.id.cpu);
        wifi1 = (CardView) findViewById(R.id.wifi);
        ram1 = (CardView) findViewById(R.id.ram);
        storage1 = (CardView) findViewById(R.id.storage);
        networkinfo1 = (CardView) findViewById(R.id.networkinfo);
        fingerprint1 = (CardView) findViewById(R.id.fingerprint);
        Sensors1 = (CardView) findViewById(R.id.Sensorsbt);
        vibrator1 = (CardView) findViewById(R.id.vibrator);
        flashlight1 = (CardView) findViewById(R.id.flashlight);
        speaker1 = (CardView) findViewById(R.id.speaker);
        rearcamera1 = (CardView) findViewById(R.id.rearcamera);
        brightness1 = (CardView) findViewById(R.id.brightness);
        multitouch1 = (CardView) findViewById(R.id.multitouch);


        phoneinfo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(Diagnosis.this,phoneinfo.class));
            }
        });
        battery1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,battery.class));

            }
        });
        bluetooth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,bluetooth.class));

            }
        });


        wifi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,wifi.class));

            }
        });
        ram1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,ram.class));

            }
        });
        cpu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,cpu.class));

            }
        });
        storage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,storage.class));

            }
        });
        networkinfo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,networkinfo.class));

            }
        }); fingerprint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,fingerprint.class));

            }
        });
        Sensors1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this, Sensors.class));

            }
        });
        vibrator1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,vibrator.class));

            }
        });
        flashlight1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,flashlight.class));

            }
        });
        speaker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,speaker.class));

            }
        });


        rearcamera1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,rearcamera.class));

            }
        });
        brightness1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,brightness.class));

            }
        });

        multitouch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Diagnosis.this,MultitouchTest.class));

            }
        });
    }
    }

