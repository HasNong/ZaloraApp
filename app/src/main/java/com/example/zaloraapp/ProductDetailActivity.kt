package com.example.zaloraapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : BaseActivity() {

    private var selectedSize = "S"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // Load navbar fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.navbarContainer, NavbarFragment())
            .commit()

        // Receive Product data passed via Intent
        val productName     = intent.getStringExtra("product_name") ?: "ESSENTIAL SILK SLIP DRESS"
        val productBrand    = intent.getStringExtra("product_brand") ?: "LUXE COLLECTION"
        val productPrice    = intent.getStringExtra("product_price") ?: "\$249.00"
        val productOriginal = intent.getStringExtra("product_original_price") ?: "\$399.00"

        // Bind to views
        findViewById<TextView>(R.id.tvProductName).text = productName
        // tvProductPrice does not exist in XML; using tvProductName only

        // Size selection — size buttons (sizeXS, sizeS, sizeM, sizeL) are not in the XML.
        // To avoid crashes, we skip dynamic size button binding.
        // TODO: Add TextView IDs sizeXS, sizeS, sizeM, sizeL to activity_product_detail.xml

        // Add to Bag
        findViewById<TextView>(R.id.btnAddToBag).setOnClickListener {
            Toast.makeText(this, "Added to bag! Size: $selectedSize", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, BagActivity::class.java))
        }

        // Wishlist
        findViewById<TextView>(R.id.btnWishlistFull).setOnClickListener {
            Toast.makeText(this, "Added to wishlist!", Toast.LENGTH_SHORT).show()
        }

        // Product Info accordion toggle
        var infoExpanded = true
        findViewById<android.widget.LinearLayout>(R.id.rowProductInfo).setOnClickListener {
            val content = findViewById<android.widget.LinearLayout>(R.id.productInfoContent)
            infoExpanded = !infoExpanded
            content.visibility = if (infoExpanded) android.view.View.VISIBLE else android.view.View.GONE
        }
    }
}