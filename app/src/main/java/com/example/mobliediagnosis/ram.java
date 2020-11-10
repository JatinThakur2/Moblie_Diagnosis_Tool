package com.example.mobliediagnosis;

import android.app.ActivityManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobliediagnosis.database.DBStatic;
import com.timqi.sectorprogressview.SectorProgressView;

public class ram extends AppCompatActivity {

    SectorProgressView ram_progress;
    TextView total_ram_field, free_ram_field, percent_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram);
        setTitle("RAM");
        // initialize ram progress view
        ram_progress = findViewById(R.id.ram_progress);
        total_ram_field = findViewById(R.id.total_ram_field);
        free_ram_field = findViewById(R.id.free_ram_field);
        percent_field = findViewById(R.id.percent_field);


        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        double availram = mi.availMem /0x100000L;
        double totalram = mi.totalMem/0x100000L;
        double usedram =totalram-availram;

        total_ram_field.setText("TOTAL RAM : " + totalram + " MB");
        free_ram_field.setText("AVAILABLE RAM : " + availram + " MB");

        percent_field.setText("Ram Usage : " + (int) (usedram * 100 / totalram) + "%");

        ram_progress.setPercent((float) (usedram * 100 / totalram));

        System.out.println("()()()() " + availram + " | " + totalram + " | " + usedram);

        String extra = "Total RAM: " + totalram
                + "\nAvailable RAM: " + availram
                + "\nUsed RAM: " + usedram;
        DBStatic.insert("RAM Test", extra, getApplicationContext());
        // just fot the show and debugging
    }
}