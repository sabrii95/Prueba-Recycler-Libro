package com.example.recyclerlibro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


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
        holder.elemento.setText(items.get(position).nombre)

        holder.boton.setOnClickListener { holder.elemento.setText("hola") }
        holder.boton.setOnClickListener { clickListener.onItemClick(items.get(position)) }
        val item = items[position]
      //  holder.bind(item)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val elemento = view.findViewById<TextView>(R.id.txt_View)
        val boton = view.findViewById<TextView>(R.id.btn_info)




    }
    interface ItemClickListener {
        fun onItemClick(elelement:Any)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            v.findViewById<TextView>(R.id.txt_View).setText("Hola")

        }
    }


}