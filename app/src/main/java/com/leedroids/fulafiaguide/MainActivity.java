package com.leedroids.fulafiaguide;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Timer;
import java.util.TimerTask;

import Adaptors.SliderAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager ;
    int[] images;
    private CardView history,faculties,principalofficers, onlineChannels,map,more;
    private ScrollView scrollView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        history = findViewById(R.id.History);
        faculties = findViewById(R.id.Faculties);
        principalofficers = findViewById(R.id.PrincipalOfficer);
        onlineChannels = findViewById(R.id.onlineChannels);
        map = findViewById(R.id.Map);
        more = findViewById(R.id.More);
        scrollView = findViewById(R.id.scrollView);

        bottomNavigationView = findViewById(R.id.bottomBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new NavigationListener(this));

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),History.class);
                startActivity(intent);
            }
        });

       faculties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent facultyIntent = new Intent(getApplicationContext(),Faculties.class);
               startActivity(facultyIntent);
            }
        });

        principalofficers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent principalIntent = new Intent(getApplicationContext(),PrincipalOfficers.class);
                startActivity(principalIntent);
            }
        });

        onlineChannels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ocIntent = new Intent(getApplicationContext(),OnlineChannelsActivity.class);
                startActivity(ocIntent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent= new Intent(getApplicationContext(),FulafiaMapActivity.class);
                startActivity(mapIntent);
            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                More fragment = new More();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction
                        .replace(R.id.mFragment, fragment, "More")
                        .addToBackStack("more")
                        .commit();
            }
        });


        // reference to silder images, stored in an array
        images = new int[] {
                R.drawable.image1,
                R.drawable.permlight,
                R.drawable.permdark,
                R.drawable.central_admin,
                R.drawable.female_hostel,
                R.drawable.male_hostel,
                R.drawable.mallamadamulectureandofficecomplex,
                R.drawable.temp,
                R.drawable.images3
        };

        viewPager.setAdapter(new SliderAdapter(this, images));
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new SliderTimer(),1000,10000);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitAlert = new AlertDialog.Builder(this);
        exitAlert.setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finishAffinity();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    private class  SliderTimer extends TimerTask {
        @Override
        public  void  run(){
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()< images.length - 1){
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
