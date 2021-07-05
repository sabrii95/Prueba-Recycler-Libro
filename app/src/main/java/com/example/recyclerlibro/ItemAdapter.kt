package com.example.recyclerlibro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ItemAdapter(items: List<Item>, item: ItemClickListener): RecyclerView.Adapter<ItemAdapter.ViewHolder>(), View.OnClickListener {
    val items : List<Item> = items
    val clickListener = item




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  this.items.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.elemento.setText(items.get(position).name)
        Picasso.get()
            .load(items.get(position).url)
            .placeholder(R.drawable.content)
            .into(holder.img)

        holder.cardItem.setOnClickListener{clickListener.onItemClick(items.get(position))}
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img =view.findViewById<ImageView>(R.id.posterImageView)
        val elemento = view.findViewById<TextView>(R.id.nameTextView2)
        val cardItem = view.findViewById<CardView>(R.id.cardItem)

    }
    interface ItemClickListener {
        fun onItemClick(element:Item)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            v.findViewById<TextView>(R.id.nameTextView2).setText("not found")
        }
    }


}