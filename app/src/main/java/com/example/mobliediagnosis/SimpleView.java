package com.example.mobliediagnosis;

import android.os.Bundle;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.aflak.libraries.callback.FingerprintCallback;
import me.aflak.libraries.view.Fingerprint;

public class SimpleView extends AppCompatActivity implements FingerprintCallback {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Fingerprint fingerprint = findViewById(R.id.activity_view_example_fingerprint);
        fingerprint.callback(this)
            .circleScanningColor(android.R.color.black)
            .fingerprintScanningColor(R.color.colorAccent)
            .authenticate();
    }

    @Override
    public void onAuthenticationSucceeded() {
        // Logic when fingerprint is recognized
    }

    @Override
    public void onAuthenticationFailed() {
        // Logic when fingerprint failed to recognize
    }

    @Override
    public void onAuthenticationError(int errorCode, String error) {
        // Logic when an error raised while authenticating
        // See Android Doc for errorCode meaning
    }
}
