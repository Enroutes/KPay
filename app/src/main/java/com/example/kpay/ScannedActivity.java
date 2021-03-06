package com.example.kpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScannedActivity extends AppCompatActivity {


    TextView name ,amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned);

        name = findViewById(R.id.sAccountName);
        amount = findViewById(R.id.sAccountAmount);

        Intent intent = getIntent();
        String buffer = intent.getStringExtra("account");



        if (buffer.equals("1610019009")){




          name.setText("Micheal Sinkolongo");

          amount.setText("K500");


        }



    }
}
