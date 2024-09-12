package com.example.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         EditText usernameet;
         EditText passwordet;
         Button loginbt;


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        usernameet = findViewById(R.id.username_input);
        passwordet = findViewById(R.id.password_input);
        loginbt = findViewById(R.id.login_btn);

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String undata = usernameet.getText().toString();
                String pwdata = passwordet.getText().toString();

                Log.d("Tdq", "username = "+undata+"; password = "+pwdata);
            }
        });




    }
}