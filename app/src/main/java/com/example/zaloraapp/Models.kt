package com.example.zaloraapp

data class Product(
    val name: String,
    val brand: String,
    val price: String,
    val originalPrice: String = "",
    val imageResId: Int,
    val badge: String = ""
)

data class BagItem(
    val brand: String,
    val name: String,
    val size: String,
    val color: String,
    val price: String,
    val originalPrice: String = "",
    val quantity: Int = 1,
    val imageResId: Int
)

data class Order(
    val orderId: String,
    val status: String,
    val imageResId: Int
)

data class Category(
    val name: String,
    val imageResId: Int
)