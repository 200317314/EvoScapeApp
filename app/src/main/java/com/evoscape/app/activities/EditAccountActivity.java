package com.evoscape.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.evoscape.app.R;
import com.evoscape.app.models.profile.Profile;

public class EditAccountActivity extends AppCompatActivity {
    private Profile profile;
    private TextView textViewName;
    private TextView textViewEmail;
    private TextView textViewPhone;
    private TextView btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewPhone = findViewById(R.id.textViewPhone);
        btnSave = findViewById(R.id.buttonSave);

        profile = (Profile)getIntent().getSerializableExtra("profile");
        textViewName.setText(profile.getName());
        textViewEmail.setText(profile.getEmail());
        textViewPhone.setText(profile.getPhone());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewName.getText() != profile.getName())
                    profile.setName(textViewName.getText().toString());

                if (textViewEmail.getText() != profile.getEmail())
                    profile.setEmail(textViewEmail.getText().toString());

                if (textViewPhone.getText() != profile.getPhone())
                    profile.setPhone(textViewPhone.getText().toString());

                //TODO: save to database
                System.out.println(profile.getName());
                System.out.println(profile.getEmail());
                System.out.println(profile.getPhone());

                finish();
            }
        });
    }
}
