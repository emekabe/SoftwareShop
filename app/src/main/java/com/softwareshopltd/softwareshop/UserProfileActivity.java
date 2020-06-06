package com.softwareshopltd.softwareshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class UserProfileActivity extends AppCompatActivity {

    private Button saveButton;
    private Button passwordResetButton;

    TextView skipButton;

    RadioButton maleRadio;
    RadioButton femaleRadio;

    TextInputLayout firstNameField;
    TextInputLayout lastNameField;
    TextInputLayout emailField;
    TextInputLayout addressField;

    TextInputLayout currentPasswordField;
    TextInputLayout newPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        firstNameField = findViewById(R.id.first_name_field);
        lastNameField = findViewById(R.id.last_name_field);
        emailField = findViewById(R.id.email_field);
        addressField = findViewById(R.id.address_field);

        currentPasswordField = findViewById(R.id.current_password_field);
        newPasswordField = findViewById(R.id.new_password_field);


        maleRadio = findViewById(R.id.male_radio);
        femaleRadio = findViewById(R.id.female_radio);

        saveButton = findViewById(R.id.save_button);
        passwordResetButton = findViewById(R.id.password_reset_button);
        skipButton = findViewById(R.id.skip_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        passwordResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
