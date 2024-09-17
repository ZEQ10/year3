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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText in = findViewById(R.id.inputUsername);
        EditText ie = findViewById(R.id.inputEmail);
        EditText ip = findViewById(R.id.inputPassword);
        EditText icp = findViewById(R.id.inputConformPassword);

        Button btnrg = findViewById(R.id.btnRegister);

        btnrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = in.getText().toString();
                String e = ie.getText().toString();
                String p = ip.getText().toString();
                String cp = icp.getText().toString();
                Toast.makeText(RegisterActivity.this, "Username: "+n+"\n Email: "+e +"\n Password: "+p+"\n Comform Password: "+cp, Toast.LENGTH_LONG).show();

            }
        });




        TextView btn = findViewById(R.id.areadyhaveanaccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(RegisterActivity.this, LoginActivity.class)});
            }
        });
    }
}