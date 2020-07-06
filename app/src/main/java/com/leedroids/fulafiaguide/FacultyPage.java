package com.leedroids.fulafiaguide;

import Adaptors.DepartmentAdapter;
import Adaptors.PrincipalOfficersAdapter;
import Adaptors.SearchAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import model.DepartmentModel;
import model.PrincipalOfficersModel;
import model.SearchModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FacultyPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<DepartmentModel> departmentModel;
    private DepartmentAdapter departmentAdapter;
    private ImageView facultyPhoto;
    private TextView facultyName;
    private TextView home,faculty,depart;
    private  String f_name;

    private String[] FACULTYOFART = {"List of Departments in The Faculty","• Fine Art Department","• Theatre and Media Art Department","• etc..."};
    private String[] FACULTYOFSCIENCE = {"List of Departments in The Faculty","• Computer Science Department","• Chemistry Department","• Physics Department","• Mathematics Department"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_page);

        //Reference to all widgets
        facultyPhoto = findViewById(R.id.facultyImage);
        facultyName = findViewById(R.id.facultyName);
        recyclerView = findViewById(R.id.faculty_recycler_view);
        home = findViewById(R.id.home);
        faculty = findViewById(R.id.faculty);
        depart = findViewById(R.id.dept);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        departmentModel = new ArrayList<DepartmentModel>();

        Bundle extras = getIntent().getExtras();



        int f_image = extras.getInt("facultyImage");
         f_name = extras.getString("facultyName");
         depart.setText(f_name);
        facultyName.setText(f_name);
        facultyPhoto.setImageResource(f_image);

        if (f_name.equals("Faculty of Arts")) {

            for (int i= 0; i< FACULTYOFART.length; i++){

                DepartmentModel item = new DepartmentModel(FACULTYOFART[i]);
                departmentModel.add(item);
            }


        }
        if (f_name.equals("Faculty of Science")) {

            for (int i= 0; i< FACULTYOFSCIENCE.length; i++){

                DepartmentModel item = new DepartmentModel(FACULTYOFSCIENCE[i]);
                departmentModel.add(item);
            }

        }


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(homeIntent);
            }
        });
        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facultyIntent = new Intent(getApplicationContext(),Faculties.class);
                startActivity(facultyIntent);
            }
        });
        depart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You're already in "+f_name+" page !",Toast.LENGTH_SHORT).show();
            }
        });

        departmentAdapter = new DepartmentAdapter(FacultyPage.this, departmentModel);
        recyclerView.setAdapter(departmentAdapter);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                DepartmentModel beanItem = departmentModel.get(position);

                String DepartmentName = beanItem.getDepartmentName();


               //Toast Department Name
                Toast.makeText(getApplicationContext(),DepartmentName,Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onLongClick(View view, int positon) {

            }
        }));
    }

    }

