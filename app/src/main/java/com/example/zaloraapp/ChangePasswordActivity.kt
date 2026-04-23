package com.example.zaloraapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var etCurrentPassword: EditText
    private lateinit var etNewPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnUpdatePassword: Button
    private lateinit var tvBackToLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        etCurrentPassword = findViewById(R.id.etCurrentPassword)
        etNewPassword     = findViewById(R.id.etNewPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnUpdatePassword = findViewById(R.id.btnUpdatePassword)
        tvBackToLogin     = findViewById(R.id.tvBackToLogin)

        btnUpdatePassword.setOnClickListener {
            val current = etCurrentPassword.text.toString().trim()
            val newPass  = etNewPassword.text.toString().trim()
            val confirm  = etConfirmPassword.text.toString().trim()

            if (TextUtils.isEmpty(current)) {
                etCurrentPassword.error = "Enter your current password"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(newPass)) {
                etNewPassword.error = "Enter a new password"
                return@setOnClickListener
            }
            if (newPass.length < 6) {
                etNewPassword.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }
            if (newPass != confirm) {
                etConfirmPassword.error = "Passwords do not match"
                return@setOnClickListener
            }

            // TODO: Replace with real password update logic (e.g. Firebase)
            Toast.makeText(this, "Password updated successfully!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
        }

        tvBackToLogin.setOnClickListener { finish() }
    }
}