package com.softwareshopltd.softwareshop.ui.notifications;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.TextViewCompat;
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

    LinearLayout aboutBackground;
    LinearLayout contactBackground;
    LinearLayout locationBackground;
    LinearLayout messageBackground;

    ImageView aboutImage;
    ImageView contactImage;
    ImageView locationImage;
    ImageView messageImage;

    TextView aboutText;
    TextView contactText;
    TextView locationText;
    TextView messageText;

    CardView aboutCard;
    CardView contactCard;
    CardView locationCard;
    CardView messageCard;

    View infoButton;
    View mapButton;
    View callButton;
    View smsButton;


//    View websiteButton;


    public static final int ABOUT_US = 1000;
    public static final int CONTACT = 2000;
    public static final int LOCATION = 3000;
    public static final int MESSAGE = 4000;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        aboutBackground = root.findViewById(R.id.about_background);
        contactBackground = root.findViewById(R.id.contact_background);
        locationBackground = root.findViewById(R.id.location_background);
        messageBackground = root.findViewById(R.id.message_background);

        aboutImage = root.findViewById(R.id.about_image);
        contactImage = root.findViewById(R.id.contact_image);
        locationImage = root.findViewById(R.id.location_image);
        messageImage = root.findViewById(R.id.message_image);

        aboutText = root.findViewById(R.id.about_text);
        contactText = root.findViewById(R.id.contact_text);
        locationText = root.findViewById(R.id.location_text);
        messageText = root.findViewById(R.id.message_text);

        aboutCard = root.findViewById(R.id.about_card);
        contactCard = root.findViewById(R.id.contact_card);
        locationCard = root.findViewById(R.id.location_card);
        messageCard = root.findViewById(R.id.message_card);


        infoButton = root.findViewById(R.id.info_button);

        infoButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    setTouchedState(aboutText, aboutBackground, ABOUT_US, aboutCard);
                    //aboutText.setText("Emeka!!!");
                // setTouchedState ()
                /*  Change text color to white
                    Change icon color to white ie change it to the white image
                    Change background color to red

                    Arguments (TextView, LinearLayout, int ImageID)
                * */

                if (event.getAction() == MotionEvent.ACTION_UP)
                    setDefaultState(aboutText, aboutBackground, ABOUT_US, aboutCard);
                    //aboutText.setText("Simi!!!");
                // setDefaultState

                return false;
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getActivity(), InfoActivity.class);
//                startActivity(i);
            }
        });
//
        mapButton = root.findViewById(R.id.map_button);

        mapButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    setTouchedState(locationText, locationBackground, LOCATION, locationCard);

                if (event.getAction() == MotionEvent.ACTION_UP)
                    setDefaultState(locationText, locationBackground, LOCATION, locationCard);

                return false;
            }
        });
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MapsActivity.class);
                startActivity(i);
            }
        });
//
        callButton = root.findViewById(R.id.call_button);
        callButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    setTouchedState(contactText, contactBackground, CONTACT, contactCard);

                if (event.getAction() == MotionEvent.ACTION_UP)
                    setDefaultState(contactText, contactBackground, CONTACT, contactCard);

                return false;
            }
        });
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "2348080808585"));
                startActivity(intent);
            }
        });
//
        smsButton = root.findViewById(R.id.sms_button);
        smsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    setTouchedState(messageText, messageBackground, MESSAGE, messageCard);

                if (event.getAction() == MotionEvent.ACTION_UP)
                    setDefaultState(messageText, messageBackground, MESSAGE, messageCard);

                return false;
            }
        });
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+"2348080808585"));
                intent.putExtra("sms_body", "I want to buy software");
                startActivity(intent);
            }
        });
//
//        websiteButton = root.findViewById(R.id.website_button);
//        websiteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_VIEW);
//                String url = "https://softwareshopltd.com";
//                sendIntent.setData(Uri.parse(url));
//
//                Toast.makeText(getActivity(), "Accessing softwareshopltd.com", Toast.LENGTH_LONG).show();
//
//                startActivity(sendIntent);
//            }
//        });
//
//
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



    private void setTouchedState(TextView textView, LinearLayout background, int imageId, CardView cardView){
        /*  Change text color to white
            Change icon color to white ie change it to the white image
            Change background color to red
            Change cardView elevation
        * */

        textView.setTextColor(Color.rgb(255, 255, 255));
        background.setBackgroundColor(Color.rgb(255, 0, 0));

        switch (imageId){
            case ABOUT_US:
                aboutImage.setImageResource(R.drawable.ic_about_us_figma_white);
                break;
            case CONTACT:
                contactImage.setImageResource(R.drawable.ic_call_figma_white);
                break;
            case LOCATION:
                locationImage.setImageResource(R.drawable.ic_location_figma_white);
                break;
            case MESSAGE:
                messageImage.setImageResource(R.drawable.ic_message_figma_white);
                break;
            default:
                Toast.makeText(getActivity(), "Ahhhh", Toast.LENGTH_SHORT).show();
                break;
        }

        cardView.setCardElevation(2);

    }

    private void setDefaultState(TextView textView, LinearLayout background, int imageId, CardView cardView){

        textView.setTextColor(Color.rgb(255, 0, 0));
        background.setBackgroundColor(Color.parseColor("#FFE6E6E6"));

        switch (imageId){
            case ABOUT_US:
                aboutImage.setImageResource(R.drawable.ic_about_us_figma);
                break;
            case CONTACT:
                contactImage.setImageResource(R.drawable.ic_call_figma);
                break;
            case LOCATION:
                locationImage.setImageResource(R.drawable.ic_location_figma);
                break;
            case MESSAGE:
                messageImage.setImageResource(R.drawable.ic_message_figma);
                break;
            default:
                Toast.makeText(getActivity(), "Yaeeee", Toast.LENGTH_SHORT).show();
                break;
        }

        cardView.setCardElevation(8);

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
