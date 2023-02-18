package com.example.teamhiring.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.data.models.AppliedJobData
import com.example.teamhiring.databinding.ItemJobAppliedBinding

class EmployeeAppliedJobAdapter(val appliedJobList: List<AppliedJobData>): RecyclerView.Adapter<EmployeeAppliedJobAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: ItemJobAppliedBinding): RecyclerView.ViewHolder(binding.root) {
        val jobAppliedTitle: TextView = itemView.findViewById(R.id.jobTitleTxt)
        val jobAppliedQualification: TextView = itemView.findViewById(R.id.jobHighQualTxt)
        val jobAppliedExpSubTxt: TextView = itemView.findViewById(R.id.jobExpSubTxt)
        val jobAppliedAppAnnSalTxt: TextView = itemView.findViewById(R.id.jobAppAnnSalTxt)
        val jobAppliedTypeTxt: TextView = itemView.findViewById(R.id.jobTypeTxt)
        val jobAppliedTimeTypeTxt: TextView = itemView.findViewById(R.id.jobTimeTypeTxt)
        val jobAppliedCompanyTxt: TextView = itemView.findViewById(R.id.jobExpCompTxt)
        val jobAppliedRecNameTxt: TextView = itemView.findViewById(R.id.jobExpDesignTxt)
        val jobAppliedAppNameTxt: TextView = itemView.findViewById(R.id.jobAppNameTxt)
        val jobAppliedEmpDescTxt: TextView = itemView.findViewById(R.id.jobEmpDescTxt)

        fun navigateToRecPage() {
            binding.root.findNavController().navigate(R.id.recruiterPageFragment)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemJobAppliedBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = appliedJobList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var ItemAppliedJob = appliedJobList[position]
        holder.jobAppliedTitle.text = ItemAppliedJob.jobAppliedTitle
        holder.jobAppliedCompanyTxt.text = ItemAppliedJob.jobAppliedTitle
        holder.jobAppliedAppAnnSalTxt.text = "Rs. "+ItemAppliedJob.jobAppliedExMinSalary +"-"+ItemAppliedJob.jobAppliedExMaxSalary
        holder.jobAppliedEmpDescTxt.text = ItemAppliedJob.jobAppliedDescription
        holder.jobAppliedQualification.text =ItemAppliedJob.jobAppliedQualification
        holder.jobAppliedTypeTxt.text = ItemAppliedJob.jobAppliedEmpType
        holder.jobAppliedExpSubTxt.text = ItemAppliedJob.jobAppliedExperience
        holder.jobAppliedTimeTypeTxt.text = ItemAppliedJob.jobAppliedJobType
        holder.jobAppliedExpSubTxt.text = ItemAppliedJob.jobAppliedExperience

        holder.binding.rootLayout.setOnClickListener {
            holder.navigateToRecPage()
        }
    }

}