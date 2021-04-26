package uk.ac.tees.m2163843.withinpasswords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView passwordListView = findViewById(R.id.passwordList);

        ArrayList<String> accountList = new ArrayList<String>();

        accountList.add("Aaron");
        accountList.add("Likliklik");

        //this converts the array into the listview for the app to display.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, accountList);

        //This takes the converted array and places into a list.
        passwordListView.setAdapter(arrayAdapter);

    }
}