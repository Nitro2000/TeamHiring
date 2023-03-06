package com.example.teamhiring.presentation.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.enums.RecFragInfoEnum
import com.example.teamhiring.data.models.recruiter.RecruiterEmpData
import com.example.teamhiring.databinding.ItemHomeJobSeekersBinding

class EmpListAdapter(val empList: List<RecruiterEmpData>, val type: RecFragInfoEnum, val context: Context): RecyclerView.Adapter<EmpListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHomeJobSeekersBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RecruiterEmpData) {
            binding.jobNameTxt.text = item.cName
            binding.jobHighQualTxt.text = item.highestQual
            binding.jobExpSubTxt.text = context.getString(R.string.exp_years,
                item.tExpYr?.toFloat() ?: 0.0f
            )
            binding.jobAnnExpSalTxt.text = context.getString(R.string.ann_income, 1, 3)
            binding.jobRolesTxt.text = item.pJobRoles
            binding.jobTypeTxt.text = item.eTYpe
            binding.jobExpDesignTxt.text = item.pJobRoles
        }

        fun arrowClick() {
            binding.jobDownArrowImg.setOnClickListener {
                val visibility = binding.jobSecLayout.visibility
                binding.jobSecLayout.visibility = if (visibility == View.GONE) View.VISIBLE else View.GONE
            }
        }

        fun navigateToRecPage(empId: Int) {
            val bundle = Bundle()
            bundle.putInt("empId", empId)
            binding.root.findNavController().navigate(R.id.employeePageFragment, bundle)
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeJobSeekersBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (type) {
            RecFragInfoEnum.RecHome -> {

            }
            RecFragInfoEnum.RecSaved -> {
                holder.binding.jobStarImg.setImageResource(R.drawable.icon_start_filled)
            }
        }
        val item = empList[position]
        holder.bind(item)
        holder.arrowClick()

        holder.binding.jobRootLayout.setOnClickListener {
            item.id?.let { it1 -> holder.navigateToRecPage(it1.toInt()) }
        }

    }

    override fun getItemCount(): Int = empList.size
}