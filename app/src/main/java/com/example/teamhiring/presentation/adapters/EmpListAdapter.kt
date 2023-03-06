package com.example.teamhiring.presentation.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.CommonDataFunctions
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.enums.RecFragInfoEnum
import com.example.teamhiring.data.models.recruiter.RecruiterEmpData
import com.example.teamhiring.databinding.ItemHomeJobSeekersBinding

class EmpListAdapter(
    val empList: List<RecruiterEmpData>,
    val type: RecFragInfoEnum,
    val context: Context,
    val callback: (empId: Int) -> Any
) : RecyclerView.Adapter<EmpListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHomeJobSeekersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RecruiterEmpData) {
            binding.jobNameTxt.text = item.cName
            binding.jobHighQualTxt.text = item.highestQual
            binding.jobExpSubTxt.text =
                CommonDataFunctions.getFormattedExpYr(item.tExpYr, item.tExpMonth)
            binding.jobAnnExpSalTxt.text = CommonDataFunctions.getFormattedSalary(item.pSalLow, item.pSalTop)
            binding.jobRolesTxt.text = item.pJobRoles
            binding.jobTypeTxt.text = item.eTYpe
            binding.jobExpDesignTxt.text = item.pJobRoles
            binding.jobEmpDescTxt.text = item.empDescription
        }

        fun layoutClickEvents(item: RecruiterEmpData) {
            binding.jobDownArrowImg.setOnClickListener {
                val visible = binding.jobSecLayout.visibility
                binding.jobSecLayout.visibility = if (visible == View.GONE) {
                    binding.jobDownArrowImg.setImageResource(R.drawable.icon_up_arrow)
                    binding.jobSecLayout.animation =
                        AnimationUtils.loadAnimation(context, R.anim.layout_motion_down)
                    View.VISIBLE
                } else {
                    binding.jobDownArrowImg.setImageResource(R.drawable.icon_down_arrow)
                    View.GONE
                }
            }

            // Layout click to open emp page
            binding.jobRootLayout.setOnClickListener {
                item.empId?.let { it1 -> navigateToRecPage(it1.toInt()) }
            }

            // Shortlisting
            binding.jobStarImg.setOnClickListener {
                val getTag = binding.jobStarImg.tag
                if (getTag == null) {
                    binding.jobStarImg.apply {
                        setImageResource(R.drawable.icon_start_filled)
                        tag = 1
                    }
                } else {
                    binding.jobStarImg.apply {
                        setImageResource(R.drawable.icon_star)
                        tag = null
                    }
                }
                item.empId?.let { it1 -> callback(it1.toInt()) }
            }
        }

        fun navigateToRecPage(empId: Int) {
            val bundle = Bundle()
            bundle.putInt("empId", empId)
            binding.root.findNavController().navigate(R.id.employeePageFragment, bundle)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHomeJobSeekersBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (type) {
            RecFragInfoEnum.RecHome -> {

            }
            RecFragInfoEnum.RecSaved -> {
                holder.binding.jobStarImg.apply {
                    setImageResource(R.drawable.icon_start_filled)
                    tag = 1
                }
            }
        }
        val item = empList[position]
        holder.bind(item)
        holder.layoutClickEvents(item)


    }

    override fun getItemCount(): Int = empList.size
}