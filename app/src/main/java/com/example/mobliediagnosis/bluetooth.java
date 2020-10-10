package com.example.mobliediagnosis;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class bluetooth extends AppCompatActivity {
    ToggleButton tblbutton;
    BluetoothAdapter bluetoothAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        tblbutton= (ToggleButton) findViewById(R.id.toggleButton);
//tblbutton.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if (tblbutton.isChecked()) {
            //getting bluetooth object
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            //confirming that device support for bluetooth or not
            if (bluetoothAdapter == null) {
                Toast.makeText(this, "Device does not support to Bluetooth", Toast.LENGTH_LONG).show();
            }
//enable bt if is disabled
            if (!bluetoothAdapter.isEnabled()) {
                //enabled bluetooth
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, 1);
            }
//creating intent other discover other bt devices
            //enabled bluetooth
            Intent discoverintent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverintent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 3000);
            startActivity(discoverintent);
        }
        else{
            Toast.makeText(getApplicationContext()," Bluetooth turned off",Toast.LENGTH_LONG).show();}
        //get bt object if bt is enable making disable
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter.isEnabled())
        {
            //disable the bt
            if(bluetoothAdapter!=null)
            {
                bluetoothAdapter.disable();
            }
        }
    }
}