package com.example.bt_tablayoutbottomnavigation;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       bottomNavigationView = findViewById(R.id.bNv);

       if (savedInstanceState ==null){
           getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new BN_FirstFragment()).commit();
       }

       bottomNavigationView.setOnItemSelectedListener(item -> {
           Fragment selectedFrag = null;
           int id = item.getItemId();

             if (id == R.id.nav_home) {
                 selectedFrag = new BN_FirstFragment();
             }
               else if (id == R.id.nav_flag){

                   selectedFrag = new BN_SecondFragment();

           }
           if (selectedFrag != null) {
               getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, selectedFrag).commit();
               return true;
           }
           return false;
       });

    }
}