package com.leedroids.fulafiaguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Splashscreen extends Activity {

    private static  int SPLASH_TIME_OUT = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        //Reference to all widgets
        final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.splashlinearlayout);




       // final Animation animation_1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.zoom_in);
        final Animation blink = AnimationUtils.loadAnimation(getBaseContext(), R.anim.blink);



        linearLayout.startAnimation(blink);
        blink.setAnimationListener(new Animation.AnimationListener() {
            @Override public void onAnimationStart(Animation animation) {

            }

            @Override public void onAnimationEnd(Animation animation) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();

            }

            @Override public void onAnimationRepeat(Animation animation) {

            }
        });










    }
}
