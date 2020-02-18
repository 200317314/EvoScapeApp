package com.evoscape.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.evoscape.app.R;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText currentPass;
    private EditText newPass;
    private EditText confirmNewPass;
    private Button btnChangePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        currentPass = findViewById(R.id.editTextCurrentPass);
        newPass = findViewById(R.id.editTextNewPass);
        confirmNewPass = findViewById(R.id.editTextConfirmNewPass);
        btnChangePass = findViewById(R.id.buttonChangePass);

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Change password

                finish();
            }
        });
    }
}
