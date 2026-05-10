package com.example.zaloraapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<ImageView>(R.id.btnClose).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnCreateAccount).setOnClickListener {
            // For now, just navigate to Dashboard
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        findViewById<TextView>(R.id.tvLogin).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Gender selection logic placeholder
        findViewById<Button>(R.id.btnWomen).setOnClickListener {
            // Update UI state
        }
        findViewById<Button>(R.id.btnMen).setOnClickListener {
            // Update UI state
        }
    }
}
