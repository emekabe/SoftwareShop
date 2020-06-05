package com.softwareshopltd.softwareshop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {


    BottomNavigationView navView;
    NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        Objects.requireNonNull(getSupportActionBar()).setElevation(0);

        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        final AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


//        Thread t1 = new SetUpThread();
//        Thread t2 = new RemoveShadowThread();
//
//        t1.start();
//        t2.start();

//        Objects.requireNonNull(getSupportActionBar()).setElevation(0);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new ShadowTimerTask(), 500, 500);

        NavigationUI.setupWithNavController(navView, navController);


//        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                int id = item.getItemId();
//
//                if (id == R.id.navigation_home){
//                    Objects.requireNonNull(getSupportActionBar()).setElevation(5);
//                }
//
//                if (id == R.id.navigation_dashboard){
//                    Objects.requireNonNull(getSupportActionBar()).setElevation(5);
//
//                }
//
//                if (id == R.id.navigation_notifications){
//                    Toast.makeText(Main2Activity.this, "Yes!!!!", Toast.LENGTH_SHORT).show();
//                    Objects.requireNonNull(getSupportActionBar()).setElevation(0);
//                }
//
//                return true;
//            }
//        });

    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.navigation_home){
//            Objects.requireNonNull(getSupportActionBar()).setElevation(5);
//        }
//
//        if (id == R.id.navigation_dashboard){
//            Objects.requireNonNull(getSupportActionBar()).setElevation(5);
//        }
//
//        if (id == R.id.navigation_notifications){
//            Objects.requireNonNull(getSupportActionBar()).setElevation(0);
//        }
//        return true;
//    }

//    class SetUpThread extends Thread{
//        @Override
//        public void run(){
//            NavigationUI.setupWithNavController(navView, navController);
//        }
//    }
//
//    class RemoveShadowThread extends Thread{
//        @Override
//        public void run(){
//            navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                    int id = item.getItemId();
//
//                    if (id == R.id.navigation_home){
//                        Objects.requireNonNull(getSupportActionBar()).setElevation(5);
//                    }
//
//                    if (id == R.id.navigation_dashboard){
//                        Objects.requireNonNull(getSupportActionBar()).setElevation(5);
//                    }
//
//                    if (id == R.id.navigation_notifications){
//                        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
//                    }
//
//                    return true;
//                }
//            });
//        }
//    }

    public class ShadowTimerTask extends TimerTask {

        @Override
        public void run(){

            Main2Activity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    int itemId =  navView.getSelectedItemId();

                    if (itemId == R.id.navigation_notifications)
                        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
                    else
                        Objects.requireNonNull(getSupportActionBar()).setElevation(5);
                }
            });

        }
    }

}
