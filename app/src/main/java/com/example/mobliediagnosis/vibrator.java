package com.example.mobliediagnosis;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class vibrator extends AppCompatActivity {

    Button vibratorbt;
    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrator);

        vibratorbt = (Button)findViewById(R.id.Vibratorbt);

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        vibratorbt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                vibrator.vibrate(1000);

            }
        });

    }
}