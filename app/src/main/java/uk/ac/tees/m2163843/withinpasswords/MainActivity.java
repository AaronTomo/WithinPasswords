package uk.ac.tees.m2163843.withinpasswords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button)findViewById(R.id.loginButton);
        Button registerButton = (Button)findViewById(R.id.registerButton);
        Button mapsButton = (Button)findViewById(R.id.sos);
        username = (EditText)findViewById(R.id.usernameLogin);
        password = (EditText)findViewById(R.id.userPassword);

        SharedPreferences sharedPreferences = this.getSharedPreferences("uk.ac.tees.m2163843.withinpasswords", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", "Aaron").apply();
        sharedPreferences.getString("username", "");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("password")){
                    Toast.makeText(MainActivity.this, "Correct!!", Toast.LENGTH_SHORT).show();
                    Intent nextScreen = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(nextScreen);


                } else {
                    Toast.makeText(MainActivity.this, "Nope!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapsView = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapsView);
            }
        });

    }


}