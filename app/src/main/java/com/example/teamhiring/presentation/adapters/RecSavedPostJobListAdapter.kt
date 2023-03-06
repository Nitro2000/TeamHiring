package com.example.teamhiring.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.CommonDataFunctions
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum.*
import com.example.teamhiring.data.models.ChipFieldsData
import com.example.teamhiring.data.models.recruiter.PostedJobData
import com.example.teamhiring.databinding.ItemJobAppliedBinding
import com.example.teamhiring.databinding.ItemManageJobBinding
import com.example.teamhiring.databinding.ItemRecHomePostedJobBinding
import com.example.teamhiring.databinding.ItemRecSavedPostListBinding

class RecSavedPostJobListAdapter(
    val postedJobList: List<PostedJobData>,
    val callback: (jobId: Int, chipList: List<String>) -> Any
) : RecyclerView.Adapter<RecSavedPostJobListAdapter.ViewHolder>() {

    private var lastCheckedRB: RadioButton? = null

    class ViewHolder(val binding: ItemRecSavedPostListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(jobItem: PostedJobData) {
            binding.apply {
                rPostNameTxt.text = jobItem.jTitle
                rPostSalaryTxt.text = CommonDataFunctions.getFormattedSalary(jobItem.sMin, jobItem.sMax)
                rPostJobType.text = CommonDataFunctions.checkJobType(jobItem.empType)
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecSavedPostListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobItem = postedJobList[position]
        holder.bind(jobItem)

        holder.binding.rPostListItemLayout.setOnClickListener {
            if (lastCheckedRB != null) {
                lastCheckedRB?.isChecked = false
            }
            holder.binding.rPostRadioBtn.isChecked = true
            lastCheckedRB = holder.binding.rPostRadioBtn

            callback(jobItem.jobId.toInt(), listOf(
                jobItem.jTitle,
                CommonDataFunctions.getFormattedSalary(jobItem.sMin, jobItem.sMax),
                CommonDataFunctions.checkJobType(jobItem.empType),
                CommonDataFunctions.checkJobTimeType(jobItem.jobtype)
            ))
        }

    }

    override fun getItemCount(): Int = postedJobList.size

}