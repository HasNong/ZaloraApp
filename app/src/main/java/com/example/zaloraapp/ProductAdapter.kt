package com.example.zaloraapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ProductAdapter(
    context: Context,
    private val products: List<Product>
) : ArrayAdapter<Product>(context, 0, products) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_product, parent, false)

        val product = products[position]

        view.findViewById<ImageView>(R.id.ivProductImage).setImageResource(product.imageResId)
        view.findViewById<TextView>(R.id.tvBrand).text = product.brand
        view.findViewById<TextView>(R.id.tvProductName).text = product.name
        view.findViewById<TextView>(R.id.tvProductPrice).text = product.price

        val tvOriginal = view.findViewById<TextView>(R.id.tvOriginalPrice)
        if (product.originalPrice.isNotEmpty()) {
            tvOriginal.visibility = View.VISIBLE
            tvOriginal.text = product.originalPrice
        } else {
            tvOriginal.visibility = View.GONE
        }

        val tvBadge = view.findViewById<TextView>(R.id.tvBadge)
        if (product.badge.isNotEmpty()) {
            tvBadge.visibility = View.VISIBLE
            tvBadge.text = product.badge
        } else {
            tvBadge.visibility = View.GONE
        }

        return view
    }
}
