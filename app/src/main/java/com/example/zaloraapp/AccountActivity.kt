package com.example.zaloraapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class AccountActivity : BaseActivity() {

    companion object {
        const val PREFS_NAME = "user_prefs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Load navbar fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.navbarContainer, NavbarFragment())
            .commit()

        // NOTE: activity_account.xml uses hardcoded order cards (not a ListView).
        // listViewOrders will be wired up once Firebase integration adds dynamic order data.
        // TODO: Add ListView with id="listViewOrders" to activity_account.xml for Firebase orders.

        // View all orders
        findViewById<TextView>(R.id.tvViewAll).setOnClickListener {
            Toast.makeText(this, "All Orders", Toast.LENGTH_SHORT).show()
        }

        // Menu rows
        findViewById<LinearLayout>(R.id.rowWishlist).setOnClickListener {
            Toast.makeText(this, "My Wishlist", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.rowPayment).setOnClickListener {
            Toast.makeText(this, "Payment Methods", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.rowAddresses).setOnClickListener {
            Toast.makeText(this, "Shipping Addresses", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.rowVouchers).setOnClickListener {
            Toast.makeText(this, "My Vouchers", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.rowHelp).setOnClickListener {
            Toast.makeText(this, "Help Center", Toast.LENGTH_SHORT).show()
        }

        // Profile Header click
        findViewById<LinearLayout>(R.id.profileHeader).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // Logout
        findViewById<TextView>(R.id.btnLogout).setOnClickListener {
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
        // Using PREFS_NAME from this class until EditProfileActivity is created
        val prefs: SharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        val firstName = prefs.getString("firstName", "") ?: ""
        val lastName  = prefs.getString("lastName", "")  ?: ""
        val fullName  = "$firstName $lastName".trim()

        val tvName = findViewById<TextView>(R.id.tvFullName)
        tvName.text = if (fullName.isEmpty()) "ALEX VANE" else fullName.uppercase()
    }
}