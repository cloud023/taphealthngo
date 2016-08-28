package com.conduit.taphealthngo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.conduit.taphealthngo.patient.PatientFragmentPagerAdapter;
import com.google.firebase.database.FirebaseDatabase;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager_patients);

        viewPager.setAdapter(new PatientFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_patient);
        
        tabLayout.setupWithViewPager(viewPager);
    }

}
