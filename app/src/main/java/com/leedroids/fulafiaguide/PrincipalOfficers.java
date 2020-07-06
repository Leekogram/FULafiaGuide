package com.leedroids.fulafiaguide;

import Adaptors.PrincipalOfficersAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import model.PrincipalOfficersModel;

import android.os.Bundle;

import java.util.ArrayList;

public class PrincipalOfficers extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<PrincipalOfficersModel> principalOfficersModels;
    private PrincipalOfficersAdapter principalOfficersAdapter;

    private int[] IMAGE1 = {R.drawable.braide,R.drawable.braide,R.drawable.braide};
    private String[] NAME = {"Braide","Braide","Braide"};
    private String[] POST = {"Vice Chancellor","Vice Chancellor","Vice Chancellor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_officers);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager photoLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(photoLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        principalOfficersModels = new ArrayList<PrincipalOfficersModel>();

        for (int i= 0; i< IMAGE1.length; i++){

            PrincipalOfficersModel item = new PrincipalOfficersModel(IMAGE1[i], NAME[i],POST[i]);
            principalOfficersModels.add(item);
        }

        principalOfficersAdapter = new PrincipalOfficersAdapter(PrincipalOfficers.this, principalOfficersModels);
        recyclerView.setAdapter(principalOfficersAdapter);
    }
}
