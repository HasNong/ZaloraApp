package com.example.zaloraapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BagActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bag)

        // Load navbar fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.navbarContainer, NavbarFragment())
            .commit()

        // NOTE: activity_bag.xml uses hardcoded item rows (not a ListView).
        // listViewBag, tvOrderTotal, and etPromoCode do NOT exist in the current XML.
        // These will be wired up once Firebase integration adds dynamic bag data.
        // TODO: Replace hardcoded XML bag items with a ListView (id: listViewBag)
        //       and add tvOrderTotal + etPromoCode to the layout.

        // Checkout
        findViewById<TextView>(R.id.btnCheckout).setOnClickListener {
            Toast.makeText(this, "Proceeding to checkout...", Toast.LENGTH_SHORT).show()
        }

        // Apply promo
        findViewById<TextView>(R.id.btnApply).setOnClickListener {
            Toast.makeText(this, "Promo code applied!", Toast.LENGTH_SHORT).show()
        }
    }
}