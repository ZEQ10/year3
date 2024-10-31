package com.example.ltdtdd_contentprovider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView LvSMS;
    ArrayList<sms> arrSMS = new ArrayList<>();
    private SMSAdapter smsAdapter;
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

        LvSMS = findViewById(R.id.lvSMS);

        smsAdapter = new SMSAdapter(this, R.layout.row_listview, arrSMS);
        LvSMS.setAdapter(smsAdapter);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS},1);
        }
        else {
            readSMS();
        }

    }



        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
        {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if(requestCode==1){
                if(grantResults.length>0&& grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    readSMS();
                }
                else {
                    Toast.makeText(this, "Yêu cầu quyền truy cập bị từ chối", Toast.LENGTH_SHORT).show();
                }
            }


        }



    public void readSMS(){
        Uri uriSMS = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uriSMS,null, null, null,null);

        if(cursor != null){
            while (cursor.moveToNext()){
                String address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                String body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
                sms m = new sms(address,body);
                arrSMS.add(m);
                Log.d("SMS", "Sender: " + address + ", Message: " + body);
            }
            cursor.close();
        }

    }
}