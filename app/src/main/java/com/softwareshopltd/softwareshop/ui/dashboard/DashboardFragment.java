package com.softwareshopltd.softwareshop.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.softwareshopltd.softwareshop.MapsActivity;
import com.softwareshopltd.softwareshop.R;
import com.softwareshopltd.softwareshop.UserProfileActivity;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    RelativeLayout detailsButton;

    TextView welcomeLabel;
    TextView emailLabel;
    TextView addressLabel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        welcomeLabel = root.findViewById(R.id.welcome_label);
        emailLabel = root.findViewById(R.id.email_label);
        addressLabel = root.findViewById(R.id.address_label);

        detailsButton = root.findViewById(R.id.details_button);

        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UserProfileActivity.class);
                startActivity(i);
            }
        });

        return root;
    }
}
