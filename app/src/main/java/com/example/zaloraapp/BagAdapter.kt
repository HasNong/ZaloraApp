package com.example.zaloraapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class BagAdapter(
    context: Context,
    private val items: MutableList<BagItem>
) : ArrayAdapter<BagItem>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_bag, parent, false)

        val item = items[position]

        view.findViewById<ImageView>(R.id.ivBagItemImage).setImageResource(item.imageResId)
        view.findViewById<TextView>(R.id.tvBagBrand).text = item.brand
        view.findViewById<TextView>(R.id.tvBagItemName).text = item.name
        view.findViewById<TextView>(R.id.tvBagItemSize).text = "Size: ${item.size}"
        view.findViewById<TextView>(R.id.tvBagItemColor).text = "Color: ${item.color}"
        view.findViewById<TextView>(R.id.tvBagItemPrice).text = item.price
        view.findViewById<TextView>(R.id.tvBagItemQty).text = item.quantity.toString()

        val tvOriginal = view.findViewById<TextView>(R.id.tvBagItemOriginalPrice)
        if (item.originalPrice.isNotEmpty()) {
            tvOriginal.visibility = View.VISIBLE
            tvOriginal.text = item.originalPrice
        } else {
            tvOriginal.visibility = View.GONE
        }

        view.findViewById<TextView>(R.id.btnBagMinus).setOnClickListener {
            if (item.quantity > 1) {
                items[position] = item.copy(quantity = item.quantity - 1)
                notifyDataSetChanged()
            }
        }

        view.findViewById<TextView>(R.id.btnBagPlus).setOnClickListener {
            items[position] = item.copy(quantity = item.quantity + 1)
            notifyDataSetChanged()
        }

        view.findViewById<ImageView>(R.id.btnBagRemove).setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
        }

        return view
    }
}