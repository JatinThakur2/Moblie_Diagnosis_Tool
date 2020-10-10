package com.example.mobliediagnosis;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class phoneinfo extends AppCompatActivity {

    String Manufacturer_value;
    String IMEI;
    String Model_value,Board_Value,Hardware,Serial_nO_value,Build_ID,Build_User,Version_Value;

    int versionName;
    TextView textView,Board,Hardware_Value,Build_Time,Build_ID1,Build_User1,Version_Value1,textKernelVersion;
    IntentFilter intentfilter;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoneinfo);
        setTitle("Phone Info");
        TextView M= (TextView) findViewById(R.id.tvSize);
        TextView M1= (TextView) findViewById(R.id.density);
        TextView M2= (TextView) findViewById(R.id.densityDpi);
        textView= (TextView) findViewById(R.id.widthPixels);
        Board= (TextView) findViewById(R.id.Board);
        Hardware_Value= (TextView) findViewById(R.id.Hardware);
        Build_Time= (TextView) findViewById(R.id.Build_Time);
        Build_ID1= (TextView) findViewById(R.id.Build_ID);
        Build_User1= (TextView) findViewById(R.id.Build_User);
        Version_Value1= (TextView) findViewById(R.id.Version);
        textKernelVersion= (TextView) findViewById(R.id.KernalV);



        Manufacturer_value = Build.MANUFACTURER;
        M.setText("Brand Name: "+Manufacturer_value);

        IMEI = Build.SERIAL;
        M1.setText("IMEI: "+IMEI);

        Model_value = Build.MODEL;
        M2.setText("Model of Device: "+Model_value);

        Board_Value = Build.BOARD;
        Board.setText("Board Value: "+Board_Value);

        Hardware = Build.HARDWARE;
        Hardware_Value.setText("Hardware Value: "+Hardware);

        Build_User = Build.USER;
        Build_User1.setText("User: "+Build_User);

        Serial_nO_value = Build.HOST;;
        Build_Time.setText("Host: "+Serial_nO_value);

        Build_ID=Build.ID;
        Build_ID1.setText("Build ID: "+Build_ID);


        Version_Value=Build.VERSION.RELEASE;
        Version_Value1.setText("Version Number: "+Version_Value);


        textKernelVersion.setText("Kernal Version: "+System.getProperty("os.version"));


        versionName = Build.VERSION.SDK_INT;
        switch (versionName) {
            case 14:
                textView.setText("Version Name: Ice Cream Sandwich");
                break;
            case 15:
                textView.setText("Version Name: Ice Cream Sandwich");
                break;
            case 16:
                textView.setText("Version Name: Jelly Bean");
                break;
            case 17:
                textView.setText("Version Name: Jelly Bean");
                break;
            case 18:
                textView.setText("Version Name: Jelly Bean");
                break;
            case 19:
                textView.setText("Version Name: KitKat");
                break;
            case 21:
                textView.setText("Version Name: Lollipop");
                break;
            case 22:
                textView.setText("Version Name: Lollipop");
                break;
            case 23:
                textView.setText("Version Name: Marshmallow");
                break;
            case 24:
                textView.setText("Version Name: Nougat");
                break;
            case 25:
                textView.setText("Version Name: Nougat");
                break;
            case 26:
                textView.setText("Version Name: Oreo");
                break;

            case 28:
                textView.setText("Version Name: Pie");
                break;
            case 29:
                textView.setText("Version Name: Android 10");
            case 30:
                textView.setText("Version Name: Android 11");
                break;
            default:
                Toast.makeText(phoneinfo.this, "Not Found", Toast.LENGTH_LONG).show();
                break;





        }

    }

}