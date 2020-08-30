
package com.leedroids.fulafiaguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FulafiaMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private int mapType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fulafia_map);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mapType = getMapType();

        bottomNavigationView = findViewById(R.id.bottomBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new NavigationListener(this));
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.normalView:
                setMapType(GoogleMap.MAP_TYPE_NORMAL);
                this.recreate();
                return true;
            case R.id.sateliteView:
                setMapType(GoogleMap.MAP_TYPE_HYBRID);
                this.recreate();
                return true;
            case R.id.terrainView:
                setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                this.recreate();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //show menu from which user can select maptype
        //toolbar.inflateMenu(R.menu.map_menu);

        LatLng fulafiaPSite, fulafiaTSite, ict, library, cAdmin;
        fulafiaPSite = new LatLng(8.478464, 8.558770);
        mMap.addMarker(new MarkerOptions().position(fulafiaPSite).title("Federal University of Lafia(Permanent Site)"));
        fulafiaTSite = new LatLng(8.471179,8.587331);
        mMap.addMarker(new MarkerOptions().position(fulafiaTSite).title("Federal University of Lafia(Takeoff Site)"));
        ict = new LatLng(8.473772,8.558185);
        mMap.addMarker(new MarkerOptions().position(ict).title("ICT Building"));
        library = new LatLng(8.473613,8.555529);
        mMap.addMarker(new MarkerOptions().position(library).title("Library"));
        cAdmin = new LatLng(8.473701,8.556472);
        mMap.addMarker(new MarkerOptions().position(cAdmin).title("Central Administration"));
        mMap.setMapType(mapType);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fulafiaPSite));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(fulafiaPSite,13f));
    }

    private int getMapType(){
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        return prefs.getInt("Map Type", GoogleMap.MAP_TYPE_NORMAL);
    }

    private void setMapType(int mapType){
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Map Type",mapType);
        editor.apply();
    }
}