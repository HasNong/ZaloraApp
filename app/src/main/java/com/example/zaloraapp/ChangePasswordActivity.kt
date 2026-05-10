package com.example.zaloraapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChangePasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            Toast.makeText(this, "Password Updated", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
