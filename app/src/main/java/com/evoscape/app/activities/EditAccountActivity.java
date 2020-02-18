package com.evoscape.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.evoscape.app.R;
import com.evoscape.app.models.profile.Profile;

public class EditAccountActivity extends AppCompatActivity {
    private Profile profile;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        btnSave = findViewById(R.id.buttonSave);

        profile = (Profile)getIntent().getSerializableExtra("profile");
        editTextName.setText(profile.getName());
        editTextEmail.setText(profile.getEmail());
        editTextPhone.setText(profile.getPhone());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextName.getText().toString() != profile.getName())
                    profile.setName(editTextName.getText().toString());

                if (editTextEmail.getText().toString() != profile.getEmail())
                    profile.setEmail(editTextEmail.getText().toString());

                if (editTextPhone.getText().toString() != profile.getPhone())
                    profile.setPhone(editTextPhone.getText().toString());

                //TODO: save to database
                System.out.println(profile.getName());
                System.out.println(profile.getEmail());
                System.out.println(profile.getPhone());

                finish();
            }
        });
    }
}
