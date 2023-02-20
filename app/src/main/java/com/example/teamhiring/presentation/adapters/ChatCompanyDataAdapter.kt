package com.example.teamhiring.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.data.models.ChatCompanyData
import com.example.teamhiring.databinding.ItemChatCompanyListBinding

class ChatCompanyDataAdapter(val chatCompList: List<ChatCompanyData>):
    RecyclerView.Adapter<ChatCompanyDataAdapter.ViewHolder>(){


    class ViewHolder(val binding: ItemChatCompanyListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item:ChatCompanyData){
            binding.itemChatCompHrName.text = item.hrName
            binding.itemChatCompName.text = item.companyName
            binding.itemChatCompTime.text = item.lastChatTime
            binding.chatCompanyImage.setImageResource(item.companyImage)
        }
        fun navigateToRecPage() {
            binding.root.findNavController().navigate(R.id.chatFragment)
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemChatCompanyListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = chatCompList[position]
        holder.bind(item)

        holder.binding.itemChatCompRootLayout.setOnClickListener {
            holder.navigateToRecPage()
        }
    }

    override fun getItemCount(): Int  = chatCompList.size


}