package com.softwareshopltd.softwareshop.ui.notifications;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.softwareshopltd.softwareshop.Banner1Fragment;
import com.softwareshopltd.softwareshop.Banner2Fragment;
import com.softwareshopltd.softwareshop.Banner3Fragment;
import com.softwareshopltd.softwareshop.CVHubActivity;
import com.softwareshopltd.softwareshop.InfoActivity;
import com.softwareshopltd.softwareshop.Main2Activity;
import com.softwareshopltd.softwareshop.MapsActivity;
import com.softwareshopltd.softwareshop.R;
import com.softwareshopltd.softwareshop.SoftwareShopActivity;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    private static final int NUM_PAGES = Integer.MAX_VALUE;

    private ViewPager2 banner;

    private FragmentStateAdapter pagerAdapter;

    View infoButton;
    View mapButton;
    View callButton;
    View smsButton;
    View websiteButton;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        infoButton = root.findViewById(R.id.info_button);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), InfoActivity.class);
                startActivity(i);
            }
        });

        mapButton = root.findViewById(R.id.map_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MapsActivity.class);
                startActivity(i);
            }
        });

        callButton = root.findViewById(R.id.call_button);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "2348080808585"));
                startActivity(intent);
            }
        });

        smsButton = root.findViewById(R.id.sms_button);
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+"2348080808585"));
//                intent.putExtra("sms_body", "I want to buy software");
                startActivity(intent);
            }
        });

        websiteButton = root.findViewById(R.id.website_button);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                String url = "https://softwareshopltd.com";
                sendIntent.setData(Uri.parse(url));

                Toast.makeText(getActivity(), "Accessing softwareshopltd.com", Toast.LENGTH_LONG).show();

                startActivity(sendIntent);
            }
        });


        banner = root.findViewById(R.id.pager);
        pagerAdapter = new NotificationsFragment.ScreenSlidePagerAdapter(getActivity());
        banner.setAdapter(pagerAdapter);

        try {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new NotificationsFragment.MyTimerTask(), 500, 2000);
        } catch (Exception e){
            Toast.makeText(getActivity(), "I dey crash o!", Toast.LENGTH_LONG).show();
        }


        return root;
    }

    public void enterInfo(View v){
        Intent i = new Intent(getActivity(), InfoActivity.class);
        startActivity(i);
    }

    public void enterMap(View v){
        // Create Google Maps activity for this
        Intent i = new Intent(getActivity(), MapsActivity.class);
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

        Toast.makeText(getActivity(), "Accessing softwareshopltd.com", Toast.LENGTH_LONG).show();

        startActivity(sendIntent);
    }

    public void enterCVHub(View v){
        Intent i = new Intent(getActivity(), CVHubActivity.class);
        startActivity(i);
    }

    private static class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }


        @NonNull
        @Override
        public Fragment createFragment(int position) {

            if (position%3== 0) {
                return new Banner1Fragment();
            }

            if (position%3 == 1) {
                return new Banner2Fragment();
            }

            if (position%3 == 2) {
                return new Banner3Fragment();
            }
            return new Banner2Fragment();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }

    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run(){

            try {
                requireActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        banner.setCurrentItem(banner.getCurrentItem() + 1);
                    }
                });
            } catch (Exception e){
//                Toast.makeText(getActivity(), "I dey crash o!", Toast.LENGTH_LONG).show();
            }


        }
    }
}
