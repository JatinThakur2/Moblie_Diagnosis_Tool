package com.example.mobliediagnosis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobliediagnosis.database.DBStatic;
import com.timqi.sectorprogressview.ColorfulRingProgressView;

import java.util.Timer;
import java.util.TimerTask;


public class battery extends AppCompatActivity {

    private ColorfulRingProgressView battery_progress;
    private Intent batteryStatus;
    private TextView charging_type_field, charging_status_field, charging_percentage_view, battery_health_view;
    Context context;
    private boolean takeData = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        setTitle("Battery");

        // Initializing context;
        context = getApplicationContext();

        // Initializing the widgets.
        battery_progress = findViewById(R.id.battery_progress);
        charging_type_field = findViewById(R.id.charging_type_field);
        charging_status_field = findViewById(R.id.charging_status_field);
        charging_percentage_view = findViewById(R.id.charging_percentage_view);
        battery_health_view = findViewById(R.id.battery_health_view);

        // Business logic for taking battery info

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                batteryStatusExtractor();
            }
        }, 0, 1000);

    }

    private void batteryStatusExtractor() {

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        batteryStatus = registerReceiver(null, ifilter);

        // Are we charging / charged?
        final int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        final boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;

        // How are we charging?
        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        final boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        final boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

        // What is battery charge level?
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        final float batteryPct = level * 100 / (float)scale;

        if (takeData) {
            takeData = false;
            String extra = "Percentage: " + batteryPct
                    + "\nIs Charging: " + isCharging
                    + "\nUSB Charging: " + usbCharge
                    + "\nAC Charging: " + acCharge;
            DBStatic.insert("BatteryTest ", extra, getApplicationContext());
            System.out.println("()()()()INSERTED INSERTED: " + extra);
        }
        // How is battery health?
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int deviceHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);

                if(deviceHealth == BatteryManager.BATTERY_HEALTH_COLD){
                    battery_health_view.setText("BATTERY HEALTH : COLD");
                }

                if(deviceHealth == BatteryManager.BATTERY_HEALTH_DEAD){
                    battery_health_view.setText("BATTERY HEALTH : DEAD");
                }

                if (deviceHealth == BatteryManager.BATTERY_HEALTH_GOOD){
                    battery_health_view.setText("BATTERY HEALTH : HEALTHY");
                }

                if(deviceHealth == BatteryManager.BATTERY_HEALTH_OVERHEAT){
                    battery_health_view.setText("BATTERY HEALTH : OVERHEATED");
                }

                if (deviceHealth == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE){
                    battery_health_view.setText("BATTERY HEALTH : OVER-VOLTAGE");
                }

                if (deviceHealth == BatteryManager.BATTERY_HEALTH_UNKNOWN){
                    battery_health_view.setText("BATTERY HEALTH : HEALTH UNKNOWN");
                }

                if (deviceHealth == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE){
                    battery_health_view.setText("BATTERY HEALTH : UNSPECIFIC FAILURE");
                }
            }
        }, ifilter);

        // Showing up the stats in UI
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if(status == BatteryManager.BATTERY_STATUS_CHARGING){
                    charging_status_field.setText("STATUS : CHARGING");
                    if (acCharge)
                        charging_type_field.setText("CHARGING TYPE : AC");
                    if (usbCharge)
                        charging_type_field.setText("CHARGING TYPE : DC (Over USB)");
                }

                if(status == BatteryManager.BATTERY_STATUS_DISCHARGING){
                    charging_status_field.setText("STATUS : DISCHARGING");
                    charging_type_field.setText("CHARGING TYPE : ---");
                }

                if (status == BatteryManager.BATTERY_STATUS_FULL){
                    charging_status_field.setText("STATUS : CHARGING (FULL)");
                    if (acCharge)
                        charging_type_field.setText("CHARGING TYPE : AC");
                    if (usbCharge)
                        charging_type_field.setText("CHARGING TYPE : DC (Over USB)");
                }

                if(status == BatteryManager.BATTERY_STATUS_UNKNOWN){
                    charging_status_field.setText("STATUS : UNKNOWN");
                    charging_type_field.setText("CHARGING TYPE : ---");
                }

                if (status == BatteryManager.BATTERY_STATUS_NOT_CHARGING){
                    charging_status_field.setText("STATUS : NOT-CHARGING");
                    charging_type_field.setText("CHARGING TYPE : ---");
                }

                battery_progress.setPercent(batteryPct);
                charging_percentage_view.setText(batteryPct + "%");
            }
        });

        System.out.println("()()()() IS CHARGING : " + isCharging);
        System.out.println("()()()() AC : " + acCharge);
        System.out.println("()()()() DC : " + usbCharge);
    }
}