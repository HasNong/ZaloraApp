package com.example.zaloraapp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText etCurrentPassword, etNewPassword, etConfirmPassword;
    private Button btnUpdatePassword;
    private TextView tvBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password); // make sure your changepass XML is named activity_change_password.xml

        etCurrentPassword  = findViewById(R.id.etCurrentPassword);
        etNewPassword      = findViewById(R.id.etNewPassword);
        etConfirmPassword  = findViewById(R.id.etConfirmPassword);
        btnUpdatePassword  = findViewById(R.id.btnUpdatePassword);
        tvBackToLogin      = findViewById(R.id.tvBackToLogin);

        // Update Password button
        btnUpdatePassword.setOnClickListener(v -> {
            String current = etCurrentPassword.getText().toString().trim();
            String newPass  = etNewPassword.getText().toString().trim();
            String confirm  = etConfirmPassword.getText().toString().trim();

            if (TextUtils.isEmpty(current)) {
                etCurrentPassword.setError("Enter your current password");
                return;
            }
            if (TextUtils.isEmpty(newPass)) {
                etNewPassword.setError("Enter a new password");
                return;
            }
            if (newPass.length() < 6) {
                etNewPassword.setError("Password must be at least 6 characters");
                return;
            }
            if (!newPass.equals(confirm)) {
                etConfirmPassword.setError("Passwords do not match");
                return;
            }

            // TODO: Replace this with your actual password update logic (e.g. Firebase)
            Toast.makeText(this, "Password updated successfully!", Toast.LENGTH_SHORT).show();

            // Go back to Login after updating
            Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        // Back to Login link
        tvBackToLogin.setOnClickListener(v -> {
            finish(); // just pop this activity off the stack
        });
    }
}