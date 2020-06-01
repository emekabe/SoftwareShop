package com.softwareshopltd.softwareshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button enterButton;

    private static final int SPLASH_SCREEN_TIMEOUT = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, SoftwareShopActivity.class));
//                finish();
            }
        }, SPLASH_SCREEN_TIMEOUT);

        enterButton = findViewById(R.id.enter_button);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Visit www.softwareshopltd.com", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, SoftwareShopActivity.class));
            }
        });
    }
}
