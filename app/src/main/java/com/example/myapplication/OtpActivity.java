package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

public class OtpActivity extends AppCompatActivity {

    private EditText[] otpFields = new EditText[6];
    private TextView tvOtpDesc, tvResendCode;
    private MaterialButton btnConfirm;
    private ImageView btnBack;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        // Bind views
        tvOtpDesc = findViewById(R.id.tvOtpDesc);
        tvResendCode = findViewById(R.id.tvResendCode);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnBack = findViewById(R.id.btnBack);

        otpFields[0] = findViewById(R.id.etOtp1);
        otpFields[1] = findViewById(R.id.etOtp2);
        otpFields[2] = findViewById(R.id.etOtp3);
        otpFields[3] = findViewById(R.id.etOtp4);
        otpFields[4] = findViewById(R.id.etOtp5);
        otpFields[5] = findViewById(R.id.etOtp6);

        // Retrieve and show phone number
        String phoneNumber = getIntent().getStringExtra("phone_number");
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            phoneNumber = "090xxxx123";
        }
        tvOtpDesc.setText("Mã xác thực đã được gửi đến số " + phoneNumber + ". Vui lòng kiểm tra tin nhắn.");

        // Back button
        btnBack.setOnClickListener(v -> finish());

        // Setup OTP text change focus navigation
        setupOtpNavigation();

        // Start countdown timer
        startCountdown();

        // Confirm button click
        btnConfirm.setOnClickListener(v -> {
            StringBuilder code = new StringBuilder();
            for (EditText et : otpFields) {
                code.append(et.getText().toString().trim());
            }

            if (code.length() < 6) {
                Toast.makeText(this, "Vui lòng nhập đủ 6 chữ số mã OTP", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Xác thực thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OtpActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setupOtpNavigation() {
        for (int i = 0; i < 6; i++) {
            final int index = i;
            otpFields[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() == 1) {
                        if (index < 5) {
                            otpFields[index + 1].requestFocus();
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });

            // Handle backspace in empty boxes
            otpFields[i].setOnKeyListener((v, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (otpFields[index].getText().length() == 0 && index > 0) {
                        otpFields[index - 1].requestFocus();
                        otpFields[index - 1].setText("");
                        return true;
                    }
                }
                return false;
            });
        }
    }

    private void startCountdown() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                tvResendCode.setText("Không nhận được mã? Gửi lại mã (" + seconds + "s)");
                tvResendCode.setClickable(false);
            }

            @Override
            public void onFinish() {
                String promptText = "Không nhận được mã? Gửi lại mã";
                SpannableString spannable = new SpannableString(promptText);
                int colorPrimary = ContextCompat.getColor(OtpActivity.this, R.color.primary);

                int startClick = promptText.indexOf("Gửi lại mã");
                int endClick = startClick + "Gửi lại mã".length();

                spannable.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(OtpActivity.this, "Đã gửi lại mã OTP mới!", Toast.LENGTH_SHORT).show();
                        startCountdown();
                    }
                }, startClick, endClick, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                spannable.setSpan(new ForegroundColorSpan(colorPrimary), startClick, endClick, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), startClick, endClick, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                tvResendCode.setText(spannable);
                tvResendCode.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
                tvResendCode.setClickable(true);
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
