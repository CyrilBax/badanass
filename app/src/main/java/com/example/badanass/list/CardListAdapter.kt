package com.example.badanass.list

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
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
import com.squareup.picasso.Target
import java.lang.Exception

class CardListAdapter(
    private val viewModel: CardListViewModel
): RecyclerView.Adapter<CardListAdapter.ViewHolder>() {

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

            Picasso.get()
                .load(item.img)
                .placeholder(R.drawable.loading_animation)
                .into(object : Target {
                    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                        binding.cardImg.setImageResource(R.drawable.ic_broken_image)
                    }

                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                        binding.cardImg.setImageBitmap(bitmap)
                    }

                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                        if (item.img === null) {
                            binding.cardImg.setImageResource(R.drawable.ic_broken_image)
                        } else {
                            binding.cardImg.setImageResource(R.drawable.loading_animation)
                        }
                    }
                })
            binding.executePendingBindings()
        }
    }
}