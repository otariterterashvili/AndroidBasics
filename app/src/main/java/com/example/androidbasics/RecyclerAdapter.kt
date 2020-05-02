package com.example.androidbasics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerAdapter(private val items: ArrayList<UserModel.Data>, activity: MainActivity): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

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

        private lateinit var itemsModel: UserModel.Data
        fun onBind(){
            itemsModel = items[adapterPosition]

            Glide.with(itemView.userImage).load(itemsModel.avatar)

//            itemView.mainItemImage.setImageResource(itemsModel.image)/**/
            itemView.userFirstName.text = itemsModel.firstName
            itemView.userLastName.text = itemsModel.lastName
            itemView.userEmail.text = itemsModel.email

            itemView.setOnLongClickListener {
                notifyItemRemoved(adapterPosition)
                true
            }
        }

    }
}