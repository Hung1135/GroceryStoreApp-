package com.example.myapplication;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    private EditText etPhone;
    private MaterialButton btnSendOtp;
    private ImageView btnBack;
    private MaterialButton btnGoogle;
    private MaterialButton btnFacebook;
    private TextView tvFooter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Bind views
        etPhone = findViewById(R.id.etPhone);
        btnSendOtp = findViewById(R.id.btnSendOtp);
        btnBack = findViewById(R.id.btnBack);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnFacebook = findViewById(R.id.btnFacebook);
        tvFooter = findViewById(R.id.tvFooter);

        // Set up back button
        btnBack.setOnClickListener(v -> finish());

        // Format footer terms links
        setupFooterText();

        // Phone number input text watcher to toggle button states
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString().trim();
                // Simple validation: check if phone number has at least 9 characters
                if (input.length() >= 9) {
                    btnSendOtp.setEnabled(true);
                    btnSendOtp.setBackgroundTintList(ColorStateList.valueOf(
                            ContextCompat.getColor(LoginActivity.this, R.color.primary)));
                    btnSendOtp.setTextColor(Color.WHITE);
                } else {
                    btnSendOtp.setEnabled(false);
                    btnSendOtp.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E5E7EB")));
                    btnSendOtp.setTextColor(Color.parseColor("#9CA3AF"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Send OTP click
        btnSendOtp.setOnClickListener(v -> {
            String phoneNumber = "+84 " + etPhone.getText().toString().trim();
            Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
            intent.putExtra("phone_number", phoneNumber);
            startActivity(intent);
        });

        // Mock Social Logins
        btnGoogle.setOnClickListener(v -> {
            Toast.makeText(this, "Đăng nhập bằng Google...", Toast.LENGTH_SHORT).show();
            // Go straight to Home for demonstration
            startActivity(new Intent(this, HomeActivity.class));
        });

        btnFacebook.setOnClickListener(v -> {
            Toast.makeText(this, "Đăng nhập bằng Facebook...", Toast.LENGTH_SHORT).show();
            // Go straight to Home for demonstration
            startActivity(new Intent(this, HomeActivity.class));
        });
    }

    private void setupFooterText() {
        String originalText = "Bằng việc tiếp tục, bạn đồng ý với\nĐiều khoản dịch vụ và Chính sách bảo mật.";
        SpannableString spannable = new SpannableString(originalText);

        int colorPrimary = ContextCompat.getColor(this, R.color.primary);

        // Highlight "Điều khoản dịch vụ"
        int startTerms = originalText.indexOf("Điều khoản dịch vụ");
        int endTerms = startTerms + "Điều khoản dịch vụ".length();
        if (startTerms >= 0) {
            spannable.setSpan(new ForegroundColorSpan(colorPrimary), startTerms, endTerms, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), startTerms, endTerms, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // Highlight "Chính sách bảo mật"
        int startPrivacy = originalText.indexOf("Chính sách bảo mật");
        int endPrivacy = startPrivacy + "Chính sách bảo mật".length();
        if (startPrivacy >= 0) {
            spannable.setSpan(new ForegroundColorSpan(colorPrimary), startPrivacy, endPrivacy, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), startPrivacy, endPrivacy, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        tvFooter.setText(spannable);
    }
}
