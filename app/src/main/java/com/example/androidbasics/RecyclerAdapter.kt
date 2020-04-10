package com.example.androidbasics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerAdapter(private val items: ArrayList<Model>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private lateinit var itemsModel: Model
        fun onBind(){
            itemsModel = items[adapterPosition]

            itemView.mainItemImage.setImageResource(itemsModel.image)
            itemView.itemTitle.text = itemsModel.title
            itemView.itemDescription.text = itemsModel.description
            itemView.itemCreateDate.text = itemsModel.createDate

            itemView.setOnLongClickListener {
                notifyItemRemoved(adapterPosition)
                true
            }
        }

    }
}