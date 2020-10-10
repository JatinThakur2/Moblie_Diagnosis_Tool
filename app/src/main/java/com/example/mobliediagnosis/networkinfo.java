package com.example.mobliediagnosis;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class networkinfo extends AppCompatActivity {


    TextView output;
    Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networkinfo);
        setTitle("Network Info");
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        output = (TextView) findViewById(R.id.networkoutput);

        test = (Button) findViewById(R.id.networkButton);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayData();
            }
        });

    }

    public void displayData() {
        ConnectivityManager check = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = check.getAllNetworkInfo();

        //Network State
        for (int i = 0; i < info.length; i++) {
            if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                output.setText("Network State: " + info[i].getDetailedState().toString() + "\n\n");
            }
        }

        //Wifi
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        String ipAddress = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
        output.append("Local IP: " + ipAddress + "\n");
        output.append("MAC Address: " + wifiManager.getConnectionInfo().getMacAddress() + "\n");
        output.append("Wifi Frequency: " + wifiManager.getConnectionInfo().getFrequency() + " MHz \n\n");

        String ispData = "";
        HashMap<String, String> isp = new HashMap<String, String>();
        try {
            output.append("Your Ping to google.com: " + checkPing() + " ms\n");
            ispData = publicInfo();

            String[] s = ispData.split(",");

            for (String pair : s) {
                String[] splitStr = pair.split(":");
                isp.put(splitStr[0], splitStr[1]);
            }

            for (Map.Entry<String, String> entry : isp.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (entry.getKey().equals("regionName"))
                    output.append("Region: " + entry.getValue() + "\n");

                if (entry.getKey().equals("isp"))
                    output.append("ISP: " + entry.getValue() + "\n");

                if (entry.getKey().equals("query"))
                    output.append("Public IP: " + entry.getValue() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public long checkPing() throws IOException {
        String hostAddress = "www.google.com";
        int port = 80;
        long timeToRespond = -1;

        InetAddress inetAddress = InetAddress.getByName(hostAddress);
        InetSocketAddress socketAddress = new InetSocketAddress(inetAddress, port);

        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(true);

        Date start = new Date();
        if (sc.connect(socketAddress)) {
            Date stop = new Date();
            timeToRespond = (stop.getTime() - start.getTime());
        }

        return timeToRespond;
    }

    /*
    public String getLocalIP() throws IOException {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));

        String ip = in.readLine();
        return ip;
    }
     */

    public String publicInfo() throws IOException {
        URL whatismyip = new URL("http://www.ip-api.com/json");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));

        String ip = in.readLine().replaceAll("[{}]", "").replaceAll("\"", "");
        return ip;
    }

}