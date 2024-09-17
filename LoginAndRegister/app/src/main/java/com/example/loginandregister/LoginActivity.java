package com.example.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText ie = findViewById(R.id.inputEmail);
        EditText ip = findViewById(R.id.inputPassword);

        Button btnlg = findViewById(R.id.btnLogin);

        btnlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = ie.getText().toString();
                String p = ip.getText().toString();
                Toast.makeText(LoginActivity.this, "Email: "+n +"\n Password: "+p, Toast.LENGTH_LONG).show();

            }
        });












        TextView btn = findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(LoginActivity.this, RegisterActivity.class)});
            }
        });



    }
}