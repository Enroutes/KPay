package com.example.kpay;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);

        tabLayout = findViewById(R.id.tablayout);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager);

        PagerViewAdapter adapter = new PagerViewAdapter(getSupportFragmentManager());

       adapter.addFragment(new PayFragment(),"Pay");
       adapter.addFragment(new ScanFragment(),"QRCode");

       viewPager.setAdapter(adapter);
       tabLayout = findViewById(R.id.tablayout);
       tabLayout.setupWithViewPager(viewPager);



    }










}
