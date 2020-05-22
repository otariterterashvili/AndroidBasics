package com.example.androidbasics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view.view.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime

class RecyclerAdapter(private val items: ArrayList<DataModel.Articles>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

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

        private lateinit var itemsModel: DataModel.Articles
        fun onBind(){
            itemsModel = items[adapterPosition]

            Glide.with(itemView.userImage).load(itemsModel.urlToImage).into(itemView.userImage)

            itemView.postAutor.text = itemsModel.author

            itemView.postTitle.text = itemsModel.title

            val format = SimpleDateFormat("yyyy-MM-dd")
            val date = format.parse(itemsModel.publishedAt)
            itemView.postDate.text = date.toString()

        }
    }
}