package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnTracking, btnHistory;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTracking = findViewById(R.id.btnTracking);
        btnHistory = findViewById(R.id.btnHistory);

        btnTracking.setOnClickListener(v -> {
            Intent intent =
                    new Intent(MainActivity.this,
                            TrackingOrderActivity.class);
            startActivity(intent);
        });

        btnHistory.setOnClickListener(v -> {
            Intent intent =
                    new Intent(MainActivity.this,
                            OrderHistoryActivity.class);
            startActivity(intent);
        });
    }
}