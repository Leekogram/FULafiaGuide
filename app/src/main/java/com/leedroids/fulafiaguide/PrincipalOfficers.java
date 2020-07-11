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

    private int[] IMAGE1 = {R.drawable.chancellor,R.drawable.liman,R.drawable.dvc,
		R.drawable.registrar,R.drawable.librarian,R.drawable.bursar};
    private String[] NAME = {"King W.S Joshua Igbugburu","Professor Muhammed Sanusi Liman","Professor Idris Amali",
		"Dr Abubakar Mamuda","Dr Abiodun Iyaro","Mr Daniel Anjola Wilson"};
    private String[] POST = {"Chancellor","Vice Chancellor","Vice Chancellor",
		"Registrar","Librarian","Bursar"};

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
