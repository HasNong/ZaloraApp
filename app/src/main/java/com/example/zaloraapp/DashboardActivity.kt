package com.example.zaloraapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Load navbar fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.navbarContainer, NavbarFragment())
            .commit()

        // NOTE: activity_dashboard.xml uses hardcoded look cards (not a ListView).
        // A ListView will be added here once Firebase integration is ready.

        // Hero banner "Shop the Edit" button
        findViewById<TextView>(R.id.btnShopEdit).setOnClickListener {
            startActivity(Intent(this, ProductListingActivity::class.java))
        }

        // View All categories
        findViewById<TextView>(R.id.tvViewAll).setOnClickListener {
            startActivity(Intent(this, ProductListingActivity::class.java))
        }

        // Sign up button
        findViewById<TextView>(R.id.btnSignUp).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}