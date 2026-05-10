package com.example.zaloraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Replace with LoginActivity once it is created
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }
}