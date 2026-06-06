package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private FrameLayout btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Bind views
        btnCart = findViewById(R.id.btnCart);

        // Cart button click listener
        btnCart.setOnClickListener(v -> 
            Toast.makeText(this, "Xem giỏ hàng...", Toast.LENGTH_SHORT).show()
        );

        // Setup bottom navigation selection
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
            bottomNavigationView.setOnItemSelectedListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_home) {
                    return true;
                } else if (itemId == R.id.nav_account) {
                    Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.nav_notification) {
                    // Let's see if we have activity_notification layout. It exists!
                    // Let's create NotificationActivity later or register it.
                    // For now, let's toast.
                    Toast.makeText(this, "Tính năng Thông báo", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Toast.makeText(this, "Đang phát triển...", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Make sure "Trang chủ" is selected when returning to this activity
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
        }
    }
}
