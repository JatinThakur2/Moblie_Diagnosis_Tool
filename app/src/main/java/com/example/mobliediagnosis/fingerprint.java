package com.example.mobliediagnosis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class fingerprint extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint);
        findViewById(R.id.activity_menu_simple_view).setOnClickListener(onView);

    }

    private View.OnClickListener onView = new View.OnClickListener() {
        @Override

        public void onClick(View view) {
            startActivity(new Intent(fingerprint.this, SimpleView.class));
        }
    };

}
