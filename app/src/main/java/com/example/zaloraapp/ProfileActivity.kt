package com.example.zaloraapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnEditProfile).setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
        }

        findViewById<Button>(R.id.btnChangePassword).setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }

        setupDetails()
    }

    private fun setupDetails() {
        // Set labels and values for the included layouts
        findViewById<LinearLayout>(R.id.detailName).apply {
            findViewById<TextView>(R.id.tvLabel).text = "FULL NAME"
            findViewById<TextView>(R.id.tvValue).text = "Alex Vane"
        }
        findViewById<LinearLayout>(R.id.detailEmail).apply {
            findViewById<TextView>(R.id.tvLabel).text = "EMAIL"
            findViewById<TextView>(R.id.tvValue).text = "alex.vane@example.com"
        }
        findViewById<LinearLayout>(R.id.detailGender).apply {
            findViewById<TextView>(R.id.tvLabel).text = "GENDER"
            findViewById<TextView>(R.id.tvValue).text = "MALE"
        }
        findViewById<LinearLayout>(R.id.detailBirthday).apply {
            findViewById<TextView>(R.id.tvLabel).text = "BIRTHDAY"
            findViewById<TextView>(R.id.tvValue).text = "01 / 01 / 1995"
        }
    }
}
