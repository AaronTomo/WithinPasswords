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
    private final String USER_CREDENTIALS = "shared_credentials";
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button)findViewById(R.id.loginButton);
        Button registerButton = (Button)findViewById(R.id.registerButton);
        Button mapsButton = (Button)findViewById(R.id.sos);
        username = (EditText)findViewById(R.id.usernameLogin);
        password = (EditText)findViewById(R.id.userPassword);

        db = new Database(this);

        //register button---------------------------------------------------

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextscreen = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(nextscreen);
            }
        });
        //-------------------------------------------------------------------

        //Login button-------------------------------------------------------

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SharedPreferences credentials = getSharedPreferences(USER_CREDENTIALS, Context.MODE_PRIVATE);
                //String strUsername = credentials.getString("Username", null);
                //String strPassword = credentials.getString("Password", null);
                //if (strUsername != null && strPassword != null && strUsername.equalsIgnoreCase(String.valueOf(username)))

                String usr = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                Boolean res= db.checkUser(usr, pwd);

                if (res == true){
                    Toast.makeText(MainActivity.this, "Correct!!", Toast.LENGTH_SHORT).show();
                    Intent nextScreen = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(nextScreen);


                } else {
                    Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //-------------------------------------------------------------------

        //Maps button--------------------------------------------------------

        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapsView = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapsView);
            }
        });
        //-------------------------------------------------------------------

    }


}