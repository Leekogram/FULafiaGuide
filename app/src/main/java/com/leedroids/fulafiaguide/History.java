package com.leedroids.fulafiaguide;

import Adaptors.TabAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import fragments.HistoryOfFulafia;
import fragments.PastVcs;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class History extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        viewPager = findViewById(R.id.viewPager1);
        tabLayout = findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new HistoryOfFulafia(),"History of FULafia");
        adapter.addFragment(new PastVcs(),"Past Vice Chacellors");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
