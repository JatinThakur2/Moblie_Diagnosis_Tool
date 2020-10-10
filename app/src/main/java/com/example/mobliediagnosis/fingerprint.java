package com.example.mobliediagnosis;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fingerprint extends AppCompatActivity {
    private Button button;

    private TextView showTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("FINGERPRINT");
        button= (Button) findViewById(R.id.idBtnStart);
        showTextView=(TextView) findViewById(R.id.idTxtView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTextView.setText("Test has been successfully done");
            }
        });
    }
}