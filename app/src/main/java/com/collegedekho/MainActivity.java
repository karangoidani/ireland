package com.collegedekho;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    MainFragment mHomeFragment = new MainFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.layout_frame_main, mHomeFragment, "FragmentHome");
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_notification:
                    NotificationFragment mNotificationFragment = new NotificationFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.layout_frame_main, mNotificationFragment, "FragmentNotify");
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_setting:
                    SettingFragment mSettingFragment = new SettingFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.layout_frame_main, mSettingFragment, "FragmentSetting");
                    fragmentTransaction3.commit();
                    return true;
                case R.id.navigation_home2:
                    FAQFragment mFaqFragment = new FAQFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.layout_frame_main, mFaqFragment, "FragmentHome");
                    fragmentTransaction.commit();
                    return true;
//                case R.id.navigation_setting2:
////                    HomeFragment mHomeFragment = new HomeFragment();
////                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
////                    fragmentTransaction1.replace(R.id.layout_frame_main,mHomeFragment,"FragmentHome");
////                    fragmentTransaction1.commit();
//                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrameLayout = (FrameLayout) findViewById(R.id.layout_frame_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // getUserProfileData();

        MainFragment mHomeFragment = new MainFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.layout_frame_main, mHomeFragment, "FragmentHome");
        fragmentTransaction1.commit();
    }


    public void onHandleClick(String Tag) {

        if (Tag.equalsIgnoreCase("CollegeListOnClick")) {
            SettingFragment mSettingFragment = new SettingFragment();
            FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction3.replace(R.id.layout_frame_main, mSettingFragment, "FragmentSetting");
            fragmentTransaction3.commit();
        }
        if (Tag.equalsIgnoreCase("HowToApply")) {
            WebFragment mWebFragment = new WebFragment();
            FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction3.replace(R.id.layout_frame_main, mWebFragment, "FragmentSetting");
            fragmentTransaction3.commit();
        }


    }
}
