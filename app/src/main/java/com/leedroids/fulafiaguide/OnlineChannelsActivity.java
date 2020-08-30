package com.leedroids.fulafiaguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import Adaptors.OnlineChannelAdapter;
import model.ChannelModel;

public class OnlineChannelsActivity extends AppCompatActivity {
    Toolbar toolbar;
    BottomNavigationView bottomBar;
    RecyclerView recyclerView;
    ArrayList<ChannelModel> data;
    OnlineChannelAdapter adapter;
    String[] channelNames = {
            "Website",
            "Facebook",
            "Twitter",
            "Instagram",
            "WhatsApp"
    };
    int[] icons = {
            R.drawable.website_icon,
            R.drawable.facebook_icon,
            R.drawable.twitter_icon,
            R.drawable.instagram_icon,
            R.drawable.whatsapp_icon
    };
    String[] url = {
            "https://fulafia.edu.ng",
            "https://facebook.com/official.fulafia.edu.ng/",
            "https://twitter.com/fulafiaofficial",
            "https://instagram.com/official_fulafia/?hl=en",
            "https://wa.me/2348112990109"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_channels);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setOnNavigationItemSelectedListener(new NavigationListener(this));

        recyclerView = findViewById(R.id.channels);
        LinearLayoutManager channelManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(channelManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<ChannelModel>();
        for(int i=0; i<icons.length; i++){
            ChannelModel channel = new ChannelModel(channelNames[i], icons[i],url[i]);
            data.add(channel);
        }

        adapter = new OnlineChannelAdapter(this,data);
        recyclerView.setAdapter(adapter);
    }
}
