package com.example.teamhiring.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.databinding.ItemHomeJobSeekersBinding

class EmpListAdapter(val context: Context): RecyclerView.Adapter<EmpListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHomeJobSeekersBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {

            binding.jobExpSubTxt.text = context.getString(R.string.exp_years, 1.02f)
            binding.jobAnnExpSalTxt.text = context.getString(R.string.ann_income, 1, 3)
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeJobSeekersBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()

    }

    override fun getItemCount(): Int = 4
}