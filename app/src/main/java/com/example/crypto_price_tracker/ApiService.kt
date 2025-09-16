package com.example.crypto_price_tracker

import android.icu.util.Currency
import com.android.identity.crypto.Crypto
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("coins/markets")
    suspend fun getTopCoins(
        @Query("vs_currency") currency:String = "usd",
        @Query("order") order:String = "market_cap_desc",
        @Query("per_page") perPage:Int = 10,
        @Query("page") page:Int = 1,
        @Query("sparkline") sparkline: Boolean = false
    ): List<com.example.crypto_price_tracker.Crypto>


}