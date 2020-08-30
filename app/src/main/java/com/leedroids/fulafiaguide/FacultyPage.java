package com.leedroids.fulafiaguide;

import Adaptors.DepartmentAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import model.DepartmentModel;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacultyPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<DepartmentModel> departmentModel;
    private DepartmentAdapter departmentAdapter;
    private ImageView facultyPhoto;
    private String f_name;
    private int f_image;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    private String[] facultyOfArt = {"English","French","History","Visual and Creative Arts","Philosophy","Theater and Media Arts","Christian Religion Studies","Islamic Studies","Hausa Language","Arabic Studies"};
    private String[] facultyOfScience = {"Computer Science","Mathematics","Physics","Chemistry","Microbiology","Biochemistry","Statistics","Geography","Geology","Zoology","Science Laboratory Technology"};
    private String[] facultyOfSocialScience = {"Economics","Political Science","Sociology","Social Work","Mass Communications","Psychology","Business Administration","Accounting"};
    private String[] facultyOfAgriculture = {"Agricultural Economics and Extension Services","Agriculture and Fisheries","Forestry and Wildlife Management"};
    private String[] facultyOfEducation = {"Computer Science Education","Mathematics Education","Physics Education","Biology Education","Chemistry Education","Library and Information Science","Special Needs and Rehabilitation Education","Business Education","Integrated Science Education"};
    private String[] collegeOfMedicine = {"Medical Laboratory Science","Anatomy","Physiology","Medicine","Nursing","Radiography"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_page);

        //Reference to all widgets
        facultyPhoto = findViewById(R.id.facultyImage);
        recyclerView = findViewById(R.id.faculty_recycler_view);

        Bundle extras = getIntent().getExtras();
        f_image = extras.getInt("facultyImage");
        f_name = extras.getString("facultyName");

        facultyPhoto.setImageResource(f_image);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Departments In "+f_name);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        departmentModel = new ArrayList<DepartmentModel>();

        switch(f_name){
            case "Faculty of Arts":
                showDepartments(facultyOfArt);
                break;
            case "Faculty of Science":
                showDepartments(facultyOfScience);
                break;
            case "Faculty of Social Sciences":
                showDepartments(facultyOfSocialScience);
                break;
            case "Faculty of Education":
                showDepartments(facultyOfEducation);
                break;
            case "Faculty of Agriculture":
                showDepartments(facultyOfAgriculture);
                break;
            case "College of Medicine":
                showDepartments(collegeOfMedicine);
                break;
        }

        departmentAdapter = new DepartmentAdapter(FacultyPage.this, departmentModel);
        recyclerView.setAdapter(departmentAdapter);

        bottomNavigationView = findViewById(R.id.bottomBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new NavigationListener(this));

    }

    private void showDepartments(String[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            DepartmentModel item = new DepartmentModel(arr[i]);
            departmentModel.add(item);
        }
    }

}

