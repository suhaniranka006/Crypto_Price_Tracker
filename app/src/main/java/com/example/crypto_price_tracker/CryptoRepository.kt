package com.example.crypto_price_tracker

class CryptoRepository {

    suspend fun getTopCoins() : List<Crypto> {
        return RetrofitInstance.api.getTopCoins()
    }
}