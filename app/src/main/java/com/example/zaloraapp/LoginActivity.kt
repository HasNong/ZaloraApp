package com.example.zaloraapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<ImageView>(R.id.btnClose).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            // For now, just navigate to Dashboard
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        findViewById<TextView>(R.id.tvCreateAccount).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Social login placeholders
        findViewById<Button>(R.id.btnApple).setOnClickListener { /* Handle Apple Login */ }
        findViewById<Button>(R.id.btnGoogle).setOnClickListener { /* Handle Google Login */ }
        findViewById<Button>(R.id.btnFacebook).setOnClickListener { /* Handle Facebook Login */ }
    }
}
