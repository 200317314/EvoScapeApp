package com.evoscape.app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.evoscape.app.R;
import com.evoscape.app.adapters.ProfileAdapter;
import com.evoscape.app.models.profile.Option;
import com.evoscape.app.models.service.Service;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private RecyclerView rvProfileOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Option> options = new ArrayList<Option>(){{
            add(new Option("1", "Edit Account", "ic_edit_account", ProfileActivity.class));
            add(new Option("2", "Change Password", "ic_change_pass", ProfileActivity.class));
            add(new Option("3", "Notification Settings", "ic_notif_settings", ProfileActivity.class));
            add(new Option("4", "Saved Addresses", "ic_saved_addresses", ProfileActivity.class));
            add(new Option("5", "Saved Cards", "ic_saved_cards", ProfileActivity.class));
            add(new Option("6", "Logout", "ic_logout", ProfileActivity.class));
        }};

        rvProfileOptions = findViewById(R.id.rvProfileOptions);
        rvProfileOptions.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        ProfileAdapter adapter = new ProfileAdapter(getBaseContext(), options);
        rvProfileOptions.setAdapter(adapter);
    }
}
