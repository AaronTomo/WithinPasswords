package uk.ac.tees.m2163843.withinpasswords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Database db;
    EditText regUsername, regPassword, confirmPassword;
    Button signUp;

    private final String CREDENTIAL_SHARED_PREF = "shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        db = new Database(this);
        regUsername = findViewById(R.id.regUsername);
        regPassword = findViewById(R.id.regPassword);
        confirmPassword = findViewById(R.id.regPassword2);
        signUp = findViewById(R.id.signUpButton);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = regUsername.getText().toString().trim();
                String strPassword = regPassword.getText().toString().trim();
                String strPassword2 = confirmPassword.getText().toString().trim();

                if (strPassword.equals(strPassword2)){
                    long characterCheck = db.addUser(strUsername, strPassword);
                    if (characterCheck > 0){
                        Toast.makeText(MainActivity3.this, "User registered", Toast.LENGTH_SHORT).show();
                        Intent loginScreen = new Intent(MainActivity3.this, MainActivity.class);
                        startActivity(loginScreen);
                    }
                    else{
                        Toast.makeText(MainActivity3.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(MainActivity3.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}