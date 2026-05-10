package com.example.zaloraapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class OrderAdapter(
    context: Context,
    private val orders: List<Order>
) : ArrayAdapter<Order>(context, 0, orders) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_order, parent, false)

        val order = orders[position]

        view.findViewById<ImageView>(R.id.ivOrderImage).setImageResource(order.imageResId)
        view.findViewById<TextView>(R.id.tvOrderId).text = order.orderId
        view.findViewById<TextView>(R.id.tvOrderStatus).text = order.status

        return view
    }
}