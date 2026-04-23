package com.example.zaloraapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvFullName: TextView
    private lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvFullName = findViewById(R.id.tvFullName)
        tvEmail    = findViewById(R.id.tvEmail)

        findViewById<LinearLayout>(R.id.rowEditProfile).setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.rowMyOrders).setOnClickListener {
            Toast.makeText(this, "My Orders", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.rowWishlist).setOnClickListener {
            Toast.makeText(this, "My Wishlist", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.rowAddresses).setOnClickListener {
            Toast.makeText(this, "Saved Addresses", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.rowChangePassword).setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            AlertDialog.Builder(this)
                    .setTitle("Log Out")
                    .setMessage("Are you sure you want to log out?")
                    .setPositiveButton("Log Out") { _, _ ->
                    val intent = Intent(this, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
                startActivity(intent)
            }
                .setNegativeButton("Cancel", null)
                    .show()
        }
    }

    override fun onResume() {
        super.onResume()
        loadProfile()
    }

    private fun loadProfile() {
        val prefs: SharedPreferences = getSharedPreferences(EditProfileActivity.PREFS_NAME, MODE_PRIVATE)
        val firstName = prefs.getString("firstName", "") ?: ""
        val lastName  = prefs.getString("lastName",  "") ?: ""
        val email     = prefs.getString("email",     "") ?: ""

        val fullName = "$firstName $lastName".trim()
        tvFullName.text = if (fullName.isEmpty()) "My Profile" else fullName
        tvEmail.text    = email
    }
}