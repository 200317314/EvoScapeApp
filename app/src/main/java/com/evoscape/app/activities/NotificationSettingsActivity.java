package com.evoscape.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;

import com.evoscape.app.R;

public class NotificationSettingsActivity extends AppCompatActivity {
    private Switch switchPushNotifs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);

        switchPushNotifs = findViewById(R.id.switchPushNotifs);
        switchPushNotifs.toggle();
    }
}
