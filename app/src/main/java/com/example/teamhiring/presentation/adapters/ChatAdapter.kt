package com.example.teamhiring.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.data.models.ChatData
import com.example.teamhiring.data.models.OnBoardData
import com.example.teamhiring.databinding.ItemChatSenderBinding

class ChatAdapter(val chatList: List<ChatData>) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {



    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val message: TextView = itemView.findViewById(R.id.itemChatMessage)
        val time: TextView = itemView.findViewById(R.id.itemChatTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create new views
            // inflates the card_view_design view
            // that is used to hold list item

        return if (viewType==0){
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chat_sender, parent, false)

            ViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chat_reciever, parent, false)

            ViewHolder(view)
        }

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = chatList[position]

        // sets the image to the imageview from our itemHolder class
        holder.message.text = ItemsViewModel.message

        // sets the text to the textview from our itemHolder class
        holder.time.text = ItemsViewModel.time

    }

    override fun getItemCount(): Int = chatList.size


    override fun getItemViewType(position: Int): Int {
        return if (position%2 == 0){
            0
        } else
            1
    }
}