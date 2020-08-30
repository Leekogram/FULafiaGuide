package com.leedroids.fulafiaguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationListener implements BottomNavigationView.OnNavigationItemSelectedListener {
    Context context;

    public NavigationListener(Context context){
        this.context = context;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent homeIntent = new Intent(context,MainActivity.class);
                context.startActivity(homeIntent);
                break;
            case R.id.contact:
                // Create a new Dialog_calling object called dialog
                DialogContact dialog = new DialogContact();
                Activity activity = (Activity)context;
                dialog.show(activity.getFragmentManager(), "123");
                break;
            case R.id.share:

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out the FULafia Guide App at: https://www.playstore.com");
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
                break;

        }
        return true;
    }
}
