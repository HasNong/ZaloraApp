package com.example.zaloraapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listViewProducts: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Navigate to Profile
        findViewById<ImageView>(R.id.ivProfileIcon).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        listViewProducts = findViewById(R.id.listViewProducts)

        val products = listOf(
            Product("Classic White Sneakers", "$49.99", R.drawable.ic_launcher_foreground),
            Product("Floral Summer Dress",    "$34.99", R.drawable.ic_launcher_foreground),
            Product("Men's Slim Chinos",      "$39.99", R.drawable.ic_launcher_foreground),
            Product("Leather Crossbody Bag",  "$59.99", R.drawable.ic_launcher_foreground),
            Product("Kids' Denim Jacket",     "$29.99", R.drawable.ic_launcher_foreground),
            Product("Running Shoes",          "$74.99", R.drawable.ic_launcher_foreground)
        )

        val adapter = ProductAdapter(this, products)
        listViewProducts.adapter = adapter

        listViewProducts.setOnItemClickListener { _, _, position, _ ->
            val selected = products[position]
            Toast.makeText(this, "Selected: ${selected.name}", Toast.LENGTH_SHORT).show()
        }
    }
}