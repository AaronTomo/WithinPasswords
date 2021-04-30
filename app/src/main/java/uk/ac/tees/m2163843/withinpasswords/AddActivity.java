package uk.ac.tees.m2163843.withinpasswords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText account, username, password;
    Button addInfo, back;
    private final String USER_CREDENTIALS = "shared_credentials";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        account = findViewById(R.id.accountName);
        username = findViewById(R.id.userName);
        password = findViewById(R.id.passwordName);
        addInfo = findViewById(R.id.addInfoButton);

        addInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper mydb = new MyDatabaseHelper(AddActivity.this);
                mydb.addAccount(account.getText().toString().trim(), username.getText().toString().trim(), password.getText().toString().trim());
            }
        });



    }
}