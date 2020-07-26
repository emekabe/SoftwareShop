package com.softwareshopltd.softwareshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class InfoActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 5;

    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        Objects.requireNonNull(getSupportActionBar()).setElevation(0);

        viewPager2 = findViewById(R.id.pager1);
        FragmentStateAdapter pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        final String[] tabTitles = {"Overview", "Our Vision", "Our Mission", "Our Policies", "Our Team"};

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(tabTitles[position])).attach();

        for(int i=0; i < tabLayout.getTabCount(); i++) {
            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            if (i == 0) //First tab
                p.setMargins(16, 0, 40, 0);
            else if (i == tabLayout.getTabCount() - 1)  // Last tab
                p.setMargins(0, 0, 16, 0);
            else    // Other tabs
                p.setMargins(0, 0, 40, 0);

            tab.requestLayout();
        }

    }


    @Override
    public void onBackPressed() {
        if (viewPager2.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private static class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }


        @NonNull
        @Override
        public Fragment createFragment(int position) {

            if (position == 0) {
                return new AboutFragment1();
            }
            if (position == 1) {
                return new AboutFragment2();
            }
            if (position == 2) {
                return new AboutFragment3();
            }
            if (position == 3) {
                return new AboutFragment4();
            }
            if (position == 4) {
                return new AboutFragment5();
            }

            return new AboutFragment1();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }



    }
}
