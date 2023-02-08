package com.example.teamhiring.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.databinding.ItemHomeJobSeekersBinding

class InteractedAdapter(val context: Context): RecyclerView.Adapter<InteractedAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHomeJobSeekersBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.jobExpSubTxt.text = context.getString(R.string.exp_years, 1.02f)
            binding.jobAnnExpSalTxt.text = context.getString(R.string.ann_income, 1, 3)
        }
//
//        fun itemCardVisibility(reqVis: Int, accDecVisi: Int, canReq: Int = View.GONE) {
//            binding.sendReqTxtBtn.visibility = reqVis
//            binding.accReqTxtBtn.visibility = accDecVisi
//            binding.decReqTxtBtn.visibility = accDecVisi
//            binding.canReqTxtBtn.visibility = canReq
//        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeJobSeekersBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
//        val item = itemList[position]
//        when(type) {
//            Interacted -> {
//                holder.binding.favImg.setImageResource(R.drawable.icon_start_filled)
//                holder.itemCardVisibility(View.VISIBLE, View.GONE)
//            }
//            Received -> holder.itemCardVisibility(View.GONE, View.VISIBLE)
//            ViewedYou -> holder.itemCardVisibility(View.VISIBLE, View.GONE)
//            Request -> holder.itemCardVisibility(View.GONE, View.GONE, View.VISIBLE)
//        }
//        holder.bind(item)
    }

    override fun getItemCount(): Int = 4
}