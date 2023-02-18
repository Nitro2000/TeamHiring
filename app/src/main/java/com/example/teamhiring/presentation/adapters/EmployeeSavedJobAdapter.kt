package com.example.teamhiring.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.data.models.SavedJobData
import com.example.teamhiring.data.repositories.EmplyeeSavedJobRepository
import com.example.teamhiring.databinding.ItemJobAppliedBinding

class EmployeeSavedJobAdapter(val savedJobList: List<SavedJobData>): RecyclerView.Adapter<EmployeeSavedJobAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemJobAppliedBinding):RecyclerView.ViewHolder(binding.root) {
        val jobSavedTitle: TextView = itemView.findViewById(R.id.jobTitleTxt)
        val jobSavedQualification: TextView = itemView.findViewById(R.id.jobHighQualTxt)
        val jobSavedExpSubTxt: TextView = itemView.findViewById(R.id.jobExpSubTxt)
        val jobSavedAppAnnSalTxt: TextView = itemView.findViewById(R.id.jobAppAnnSalTxt)
        val jobSavedTypeTxt: TextView = itemView.findViewById(R.id.jobTypeTxt)
        val jobSavedTimeTypeTxt: TextView = itemView.findViewById(R.id.jobTimeTypeTxt)
        val jobSavedCompanyTxt: TextView = itemView.findViewById(R.id.jobExpCompTxt)
        val jobSavedRecNameTxt: TextView = itemView.findViewById(R.id.jobExpDesignTxt)
        val jobSavedAppNameTxt: TextView = itemView.findViewById(R.id.jobAppNameTxt)
        val jobSavedEmpDescTxt: TextView = itemView.findViewById(R.id.jobEmpDescTxt)

        fun navigateToRecPage() {
            binding.root.findNavController().navigate(R.id.recruiterPageFragment)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemJobAppliedBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = savedJobList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var ItemSavedJob = savedJobList[position]
        holder.jobSavedTitle.text = ItemSavedJob.jobSavedTitle
        holder.jobSavedCompanyTxt.text = ItemSavedJob.jobSavedTitle
        holder.jobSavedAppAnnSalTxt.text = "Rs. "+(ItemSavedJob.jobSavedExMinSalary)+"-"+ItemSavedJob.jobSavedExMaxSalary
        holder.jobSavedEmpDescTxt.text = ItemSavedJob.jobSavedDescription
        holder.jobSavedQualification.text =ItemSavedJob.jobSavedQualification
        holder.jobSavedTypeTxt.text = ItemSavedJob.jobSavedEmpType
        holder.jobSavedExpSubTxt.text = ItemSavedJob.jobSavedExperience
        holder.jobSavedTimeTypeTxt.text = ItemSavedJob.jobSavedJobType
        holder.jobSavedExpSubTxt.text = ItemSavedJob.jobSavedExperience

        holder.binding.rootLayout.setOnClickListener {
            holder.navigateToRecPage()
        }
    }


}