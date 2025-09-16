package com.example.crypto_price_tracker

// CryptoAdapter.kt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crypto_price_tracker.databinding.ItemCryptoBinding


class CryptoAdapter(private var coins: List<Crypto>) :
    RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    inner class CryptoViewHolder(val binding: ItemCryptoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding = ItemCryptoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val coin = coins[position]

        holder.binding.tvName.text = coin.name
        holder.binding.tvPrice.text = "$${coin.current_price}"
        holder.binding.tvSymbol.text = coin.symbol.uppercase()

        // Load coin image
        Glide.with(holder.itemView.context)
            .load(coin.image)
            .into(holder.binding.ivLogo)
    }

    override fun getItemCount(): Int = coins.size

    // update list when new data comes
    fun updateList(newCoins: List<Crypto>) {
        coins = newCoins
        notifyDataSetChanged()
    }
}
