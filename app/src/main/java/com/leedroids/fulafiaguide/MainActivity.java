package com.leedroids.fulafiaguide;

import Adaptors.SliderAdapter;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager ;
    int[] images;
    private CardView history,faculties,principalofficers,studentslife,map,more;
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
        studentslife = findViewById(R.id.StudentLife);
        map = findViewById(R.id.Map);
        more = findViewById(R.id.More);
        scrollView = findViewById(R.id.scrollView);
        bottomNavigationView = findViewById(R.id.bottomBar);




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent homeIntent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.contact:
                        // Create a new Dialog_calling object called dialog
                        DialogContact dialog = new DialogContact();
                        dialog.show(getFragmentManager(), "123");

                        break;
                    case R.id.share:

                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT,
                                "Hey check out the FULafia Guide App at: https://www.playstore.com");
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);
                        break;




                }
                return true;
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                History fragment = new History();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mFragment, fragment, "History");
                fragmentTransaction.commit();
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
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                More fragment = new More();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mFragment, fragment, "More");
                fragmentTransaction.commit();
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
