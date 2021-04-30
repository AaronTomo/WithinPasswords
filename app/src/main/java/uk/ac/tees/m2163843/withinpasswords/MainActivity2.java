package uk.ac.tees.m2163843.withinpasswords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //ListView passwordListView = findViewById(R.id.passwordList);

        //ArrayList<String> accountList = new ArrayList<String>();

        //accountList.add("Aaron");
        //accountList.add("Likliklik");

        //this converts the array into the listview for the app to display.
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, accountList);

        //This takes the converted array and places into a list.
        //passwordListView.setAdapter(arrayAdapter);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(navListener);

        //sets the default fragment

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new StartFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()){

                case R.id.itemFragment:
                    Intent nextscreen = new Intent(MainActivity2.this, passwordHome.class);
                    startActivity(nextscreen);
                    break;

                case R.id.mapsFragment:
                    selectedFragment = new MapsFragmentV2();
                    break;

                case R.id.settingsFragment:
                    selectedFragment = new SettingsFragment();
                    break;


            }

            //Change fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selectedFragment).commit();

            return true;
        }
    };



}