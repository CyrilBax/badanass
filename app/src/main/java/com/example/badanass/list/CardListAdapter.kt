package com.example.badanass.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.badanass.R
import com.example.badanass.data.models.Card
import com.example.badanass.databinding.ItemCardListBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class CardListAdapter(private val viewModel: CardListViewModel): RecyclerView.Adapter<CardListAdapter.ViewHolder>() {

    var data = listOf<Card>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Dont forget parent and false !!!!!!!!!!
        val bind = ItemCardListBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
            cardListViewModel = viewModel
        }
        return ViewHolder(bind)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class ViewHolder (private val binding: ItemCardListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Card) {

            binding.card = item

            Picasso.get().load(item.img)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.cardImg, object : Callback {
                    override fun onSuccess() {
                        Log.i("success", "youpi")
                    }

                    override fun onError(e: Exception?) {
                        Log.i("error", e.toString())
                    }
                })
            binding.executePendingBindings()
        }
    }
}