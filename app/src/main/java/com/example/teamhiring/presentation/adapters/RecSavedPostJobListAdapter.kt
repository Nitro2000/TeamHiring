package com.example.teamhiring.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum.*
import com.example.teamhiring.databinding.ItemJobAppliedBinding
import com.example.teamhiring.databinding.ItemManageJobBinding
import com.example.teamhiring.databinding.ItemRecHomePostedJobBinding
import com.example.teamhiring.databinding.ItemRecSavedPostListBinding

class RecSavedPostJobListAdapter(val callback: () -> Any): RecyclerView.Adapter<RecSavedPostJobListAdapter.ViewHolder>() {

    private var lastCheckedRB: RadioButton? = null

    inner class ViewHolder(val binding: ItemRecSavedPostListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecSavedPostListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.rPostListItemLayout.setOnClickListener {
            if (lastCheckedRB != null) {
                lastCheckedRB?.isChecked = false
            }
            holder.binding.rPostRadioBtn.isChecked = true
            lastCheckedRB = holder.binding.rPostRadioBtn
        }

    }

    override fun getItemCount(): Int = 4

}