package com.leedroids.fulafiaguide;

import Adaptors.SearchAdapter;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import model.SearchModel;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Faculties extends AppCompatActivity implements SearchAdapter.SearchAdapterListener {

    private RecyclerView recyclerView;
    private List<SearchModel> searchModelList;
    private SearchAdapter sAdapter;
    private SearchView searchView;

    private int[] FACULTYIMAGES = {R.drawable.facultyofart, R.drawable.facultyofscience};
    private String[] NAMESOFFACULTIES = {"Faculty of Arts", "Faculty of Science"};
    private TextView home,faculty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculties);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // toolbar fancy stuff
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.toolbar_title);


        recyclerView = findViewById(R.id.search_recycler_view);
        home = findViewById(R.id.home);
        faculty = findViewById(R.id.faculty);

        searchModelList = new ArrayList<>();
        sAdapter = new SearchAdapter(this, searchModelList, this);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);
       // recyclerView.setVisibility(View.GONE);

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
                Toast.makeText(getApplicationContext(),"You're already in the faculties page !",Toast.LENGTH_SHORT).show();
            }
        });
        fetchSearch();


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                SearchModel beanItem = searchModelList.get(position);
                int FacultyImage = beanItem.getFaculty_Image();
                String FacultyName = beanItem.getFaculty_Name();


                Bundle dataBundle = new Bundle();
                dataBundle.putInt("facultyImage", FacultyImage);
                dataBundle.putString("facultyName", FacultyName);



                // Sends bundle data to FacultyPage for display;
                Intent intent = new
                        Intent(getApplicationContext(), FacultyPage.class);
                intent.putExtras(dataBundle);
                startActivity(intent);


            }

            @Override
            public void onLongClick(View view, int positon) {

            }
        }));
    }

    private void fetchSearch() {
        for (int i= 0; i< FACULTYIMAGES.length; i++){

            SearchModel item = new SearchModel(FACULTYIMAGES[i], NAMESOFFACULTIES[i]);
            searchModelList.add(item);
        }
        sAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                sAdapter.getFilter().filter(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                sAdapter.getFilter().filter(query);
               // recyclerView.setVisibility(View.VISIBLE);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // close search view on back button pressed
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onSearchSelected(SearchModel searchModel) {
        // Toast.makeText(getApplicationContext(), "Selected: " + contact.getName() + ", " + contact.getPhone(), Toast.LENGTH_LONG).show();
       // final String doc_path = searchModel.getMoreInfo();
       // Intent i = new Intent(getApplicationContext(), PdfReader.class);
       // i.putExtra("name", doc_path);
       // startActivity((i));
    }
}
