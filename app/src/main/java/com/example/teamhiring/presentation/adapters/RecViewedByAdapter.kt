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
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum.*
import com.example.teamhiring.data.models.ChipFieldsData
import com.example.teamhiring.data.models.recruiter.PostedJobData
import com.example.teamhiring.data.models.recruiter.RecNotification
import com.example.teamhiring.data.models.recruiter.RecViewedData
import com.example.teamhiring.databinding.ItemJobAppliedBinding
import com.example.teamhiring.databinding.ItemManageJobBinding
import com.example.teamhiring.databinding.ItemRecAppliedViewedBinding
import com.example.teamhiring.databinding.ItemRecHomePostedJobBinding
import com.example.teamhiring.databinding.ItemRecSavedPostListBinding
import kotlin.reflect.typeOf

class RecViewedByAdapter(
    val empJobList: List<RecNotification>,
    val type: Int,
    val callback: (jobId: Int) -> Any
) : RecyclerView.Adapter<RecViewedByAdapter.ViewHolder>() {


    class ViewHolder(val binding: ItemRecAppliedViewedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(jobItem: RecNotification, type: Int) {
            binding.apply {
                titleTxt.text = if (type == 0) "${jobItem.empName} has Applied in your job post of python developer" else "${jobItem.empName} has viewed your job post of python developer"
                expTxt.text = jobItem.tExpType
                expValueTxt.text = "${jobItem.tExpYr}.${jobItem.tExpMonth}"
                empJobNameTxt.text = jobItem.jTitle
                engLevelTxt.text = jobItem.eng
                recJobTitleTxt.text = jobItem.pJobRoles
                recJobAnnSalTxt.text = CommonDataFunctions.getFormattedSalary(jobItem.sMin, jobItem.sMax)
                recJobLocTxt.text = jobItem.pCities
                jobEmpDescTxt.text = jobItem.objective
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecAppliedViewedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobItem = empJobList[position]
        holder.bind(jobItem, type)

    }

    override fun getItemCount(): Int = empJobList.size

}