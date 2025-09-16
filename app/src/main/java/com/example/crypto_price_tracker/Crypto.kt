package com.example.crypto_price_tracker


// Response example from API:
// {
//   "id": "bitcoin",
//   "symbol": "btc",
//   "name": "Bitcoin",
//   "current_price": 67000,
//   "image": "https://..."
// }

data class Crypto(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val current_price: Double
)
