package com.example.zaloraapp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvForgotPassword;

    // Hardcoded credentials for demo — replace with real auth (e.g. Firebase) later
    private static final String DEMO_EMAIL    = "user@email.com";
    private static final String DEMO_PASSWORD = "password123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // make sure your login XML file is named activity_login.xml

        etEmail         = findViewById(R.id.etEmail);
        etPassword      = findViewById(R.id.etPassword);
        btnLogin        = findViewById(R.id.btnLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        TextView tvRegisterLink = findViewById(R.id.tvRegisterLink);
        tvRegisterLink.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        // Login button → go to dashboard
        btnLogin.setOnClickListener(v -> {
            String email    = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                etEmail.setError("Email is required");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                etPassword.setError("Password is required");
                return;
            }

            // Check credentials
            if (email.equals(DEMO_EMAIL) && password.equals(DEMO_PASSWORD)) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // clears back stack
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });

        // Forgot Password → go to ChangePasswordActivity
        tvForgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ChangePasswordActivity.class);
            startActivity(intent);
        });
    }
}