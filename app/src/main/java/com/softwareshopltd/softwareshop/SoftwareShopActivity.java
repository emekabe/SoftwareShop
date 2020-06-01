package com.softwareshopltd.softwareshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

public class SoftwareShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_shop);

        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
    }

    public void enterInfo(View v){
        Intent i = new Intent(SoftwareShopActivity.this, InfoActivity.class);
        startActivity(i);
    }

    public void enterMap(View v){
        // Create Google Maps activity for this
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }

    public void enterDial(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "2348080808585"));
        startActivity(intent);
    }

    public void enterSMS(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+"2348080808585"));
//        intent.putExtra("sms_body", "I want to buy software");
        startActivity(intent);
    }

    public void enterWebsite(View v){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_VIEW);
        String url = "https://softwareshopltd.com";
        sendIntent.setData(Uri.parse(url));

        Toast.makeText(this, "Accessing softwareshopltd.com", Toast.LENGTH_LONG).show();

        startActivity(sendIntent);
    }

    public void enterCVHub(View v){
        Intent i = new Intent(this, CVHubActivity.class);
        startActivity(i);
    }


}
