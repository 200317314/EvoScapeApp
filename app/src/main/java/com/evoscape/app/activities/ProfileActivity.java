package com.evoscape.app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.evoscape.app.R;
import com.evoscape.app.adapters.ProfileAdapter;
import com.evoscape.app.models.profile.Option;
import com.evoscape.app.models.profile.Profile;
import com.evoscape.app.models.service.Service;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private RecyclerView rvProfileOptions;
    private ImageView profilePicture;
    private TextView profileName;
    private TextView profileEmail;
    private TextView profilePhone;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilePicture = findViewById(R.id.civProfilePicture);
        profileName = findViewById(R.id.textViewName);
        profileEmail = findViewById(R.id.textViewEmail);
        profilePhone = findViewById(R.id.textViewPhone);

        //TODO: should be passed in from previous view or grabbed form server
        profile = new Profile("!", "John Doe", "email@email.com", "+1 (111) 111-1111", "profile_placeholder");
        profilePicture.setImageResource(getResources().getIdentifier(profile.getImage(), "drawable", getPackageName()));
        profileName.setText(profile.getName());
        profileEmail.setText(profile.getEmail());
        profilePhone.setText(profile.getPhone());

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Option> options = new ArrayList<Option>(){{
            add(new Option("1", "Edit Account", "ic_edit_account", EditAccountActivity.class));
            add(new Option("2", "Change Password", "ic_change_pass", ChangePasswordActivity.class));
            add(new Option("3", "Notification Settings", "ic_notif_settings", NotificationSettingsActivity.class));
            add(new Option("4", "Saved Addresses", "ic_saved_addresses", SavedAddressesActivity.class));
            add(new Option("5", "Gift Cards", "ic_saved_cards", EditAccountActivity.class));
            add(new Option("6", "Logout", "ic_logout", EditAccountActivity.class));
        }};

        rvProfileOptions = findViewById(R.id.rvProfileOptions);
        rvProfileOptions.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        ProfileAdapter adapter = new ProfileAdapter(getBaseContext(), options, profile);
        rvProfileOptions.setAdapter(adapter);
    }
}
