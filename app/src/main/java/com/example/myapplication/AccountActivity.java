package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        
        // Đoạn code làm nổi (highlight) item "Tài khoản" trên menu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(R.id.nav_account);
        }
    }
}