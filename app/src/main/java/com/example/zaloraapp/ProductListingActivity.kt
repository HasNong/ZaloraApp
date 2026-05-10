package com.example.zaloraapp

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ProductListingActivity : BaseActivity() {

    private lateinit var listViewProducts: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_listing)

        // Load navbar fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.navbarContainer, NavbarFragment())
            .commit()

        listViewProducts = findViewById(R.id.listViewProducts)

        // Product data using Product data class
        val products = mutableListOf(
            Product(
                name = "Structured Oversized Coat",
                brand = "MONKI",
                price = "S\$ 129.00",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            Product(
                name = "Floral Embroidery Cotton Dress",
                brand = "MANGO",
                price = "S\$ 89.90",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            Product(
                name = "Premium Silk Blend Blouse",
                brand = "ZALORA BASICS",
                price = "S\$ 45.00",
                imageResId = R.drawable.ic_launcher_foreground,
                badge = "NEW"
            ),
            Product(
                name = "Original Trucker Denim Jacket",
                brand = "LEVI'S",
                price = "S\$ 95.00",
                originalPrice = "S\$ 150.00",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            Product(
                name = "High Waisted Tailored Trousers",
                brand = "TOPSHOP",
                price = "S\$ 79.90",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            Product(
                name = "Top Handle Crossbody Bag",
                brand = "ALDO",
                price = "S\$ 65.00",
                imageResId = R.drawable.ic_launcher_foreground,
                badge = "OUTLET"
            )
        )

        // ProductAdapter (ArrayAdapter) bound to ListView
        val adapter = ProductAdapter(this, products)
        listViewProducts.adapter = adapter

        listViewProducts.setOnItemClickListener { _, _, position, _ ->
            val selected = products[position]
            val intent = Intent(this, ProductDetailActivity::class.java).apply {
                putExtra("product_name", selected.name)
                putExtra("product_brand", selected.brand)
                putExtra("product_price", selected.price)
                putExtra("product_original_price", selected.originalPrice)
            }
            startActivity(intent)
        }
    }
}