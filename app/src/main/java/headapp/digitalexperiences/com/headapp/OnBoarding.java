package headapp.digitalexperiences.com.headapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFlat;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import headup.digitalexperiences.com.headup.R;

/**
 * Created by Giovanny on 10/26/2015.
 */
public class OnBoarding extends FragmentActivity {


    private ViewPager pager;
    private SmartTabLayout indicator;
    private ButtonFlat skip;
    private ButtonFlat next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_activity);

        pager = (ViewPager)findViewById(R.id.pager);
        indicator = (SmartTabLayout)findViewById(R.id.indicator);
        skip = (ButtonFlat)findViewById(R.id.skip);
        next = (ButtonFlat)findViewById(R.id.next);
        next.setVisibility(View.INVISIBLE);



        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0 : return new OnboardingFragment1();
                    case 1 : return new OnboardingFragment2();
                    case 2 : return new OnboardingFragment3();
                    default: return null;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        };
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 2) {
                    skip.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);
                }else if(position==1 | position==0){
                    skip.setVisibility(View.VISIBLE);
                    next.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pager.getCurrentItem()==2)
                    finishOnboarding();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishOnboarding();
            }
        });

    }

    private void finishOnboarding() {
        // Get the shared preferences
        SharedPreferences preferences =
                getSharedPreferences("my_preferences", MODE_PRIVATE);

        // Set onboarding_complete to true
        preferences.edit()
                .putBoolean("onboarding_complete",true).apply();

        // Launch the main Activity, called MainActivity
        Intent main = new Intent(this, HeadAppMain.class);
        startActivity(main);

        // Close the OnboardingActivity
        finish();
    }
}
