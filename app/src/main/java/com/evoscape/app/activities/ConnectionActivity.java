package com.evoscape.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.evoscape.app.R;
import com.evoscape.app.models.connection.ConnectionClient;

import java.net.URISyntaxException;

public class ConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
    }

    @Override
    public void onStart() {
        super.onStart();
        ConnectionClient.setCurrentActivity(this);

        try {
            ConnectionClient.newClient();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
