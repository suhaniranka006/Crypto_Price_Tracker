package com.example.crypto_price_tracker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CryptoVIewModel(private val repository: CryptoRepository) : ViewModel() {
    val cryptoList = MutableLiveData<List<Crypto>>()
    val error = MutableLiveData<String>()


    //fetch top coins
    fun getTopCoins() {
        viewModelScope.launch {
            try {
                val coins = repository.getTopCoins()
                cryptoList.value = coins
            } catch (e: Exception) {
                error.value = e.message
            }
        }


    }
}