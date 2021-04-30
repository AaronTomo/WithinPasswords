package uk.ac.tees.m2163843.withinpasswords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class passwordHome extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_Button;

    MyDatabaseHelper myDB;
    ArrayList<String> column_id, account, username, password;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_home);

        recyclerView = findViewById(R.id.recyleView);
        add_Button = findViewById(R.id.add_Button);
        add_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(passwordHome.this, AddActivity.class);
                startActivity(intent);            }
        });

        myDB = new MyDatabaseHelper(passwordHome.this);
        column_id = new ArrayList<>();
        account = new ArrayList<>();
        username = new ArrayList<>();
        password = new ArrayList<>();

        storeData();

        customAdapter = new CustomAdapter(passwordHome.this, column_id, account, username, password);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(passwordHome.this));

    }

    void storeData(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                column_id.add(cursor.getString(0));
                account.add(cursor.getString(1));
                username.add(cursor.getString(2));
                password.add(cursor.getString(3));
            }
        }
    }


    }
