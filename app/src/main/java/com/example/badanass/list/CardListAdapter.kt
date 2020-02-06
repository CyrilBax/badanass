package com.example.badanass.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.badanass.R
import com.example.badanass.data.models.Card
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class CardListAdapter: RecyclerView.Adapter<CardListAdapter.ViewHolder>() {

    var data = listOf<Card>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class ViewHolder private constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardName: TextView = itemView.findViewById(R.id.card_name)
        val cardType: TextView = itemView.findViewById(R.id.card_type)
        val cardImg: ImageView = itemView.findViewById(R.id.card_img)

        fun bind(item: Card) {
            val res = itemView.context.resources
            cardName.text = item.name
            cardType.text = item.type
            Picasso.get().load(item.img)
                .placeholder(R.drawable.ic_launcher_background)
                .into(cardImg, object:Callback{
                override fun onSuccess() {
                    Log.i("success", "youpi")
                }

                override fun onError(e: Exception?) {
                    Log.i("error", e.toString())
                }
            })
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater =
                    LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.item_card_list, parent, false)
                return ViewHolder(view)
            }
        }

    }

}