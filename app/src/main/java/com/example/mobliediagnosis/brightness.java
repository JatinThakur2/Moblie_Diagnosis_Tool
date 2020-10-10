package com.example.mobliediagnosis;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.SeekBar;
import android.widget.TextView;

public class brightness extends AppCompatActivity {
    private static final String SCREEN_BRIGHTNESS_VALUE_PREFIX = "Screen brightness value is ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brightness);

        setTitle("Brightness");

        // Get display screen brightness value text view object.
        final TextView screenBrightnessValueTextView = (TextView)findViewById(R.id.change_screen_brightness_value_text_view);

        // Get the seekbar instance.
        SeekBar seekBar = (SeekBar)findViewById(R.id.change_screen_brightness_seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                Context context = getApplicationContext();

                boolean canWriteSettings = Settings.System.canWrite(context);

                if(canWriteSettings) {

                    // Because max screen brightness value is 255
                    // But max seekbar value is 100, so need to convert.
                    int screenBrightnessValue = i*100/10;

                    // Set seekbar adjust screen brightness value in the text view.
                    screenBrightnessValueTextView.setText(SCREEN_BRIGHTNESS_VALUE_PREFIX + screenBrightnessValue/10 +"%");

                    // Change the screen brightness change mode to manual.
                    Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
                    // Apply the screen brightness value to the system, this will change the value in Settings ---> Display ---> Brightness level.
                    // It will also change the screen brightness for the device.
                    Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, screenBrightnessValue);
                }else
                {
                    // Show Can modify system settings panel to let user add WRITE_SETTINGS permission for this app.
                    Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                    ((Context) context).startActivity(intent);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Getting Current screen brightness.
        int currBrightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS,0);
        // Set current screen brightness value in the text view.
        screenBrightnessValueTextView.setText( SCREEN_BRIGHTNESS_VALUE_PREFIX + currBrightness);
        // Set current screen brightness value to seekbar progress.
        seekBar.setProgress(currBrightness);
    }
}