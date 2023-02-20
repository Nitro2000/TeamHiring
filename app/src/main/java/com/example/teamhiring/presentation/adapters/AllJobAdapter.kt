package com.example.teamhiring.presentation.adapters

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.databinding.ItemJobAppliedBinding
import com.example.teamhiring.ui.mainFragments.HomeFragmentSeekerDirections

class AllJobAdapter(val jobList: List<AllJobData>) :
    RecyclerView.Adapter<AllJobAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemJobAppliedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val jobTitle: TextView = itemView.findViewById(R.id.jobTitleTxt)
        val jobQualification: TextView = itemView.findViewById(R.id.jobHighQualTxt)
        val jobExpSubTxt: TextView = itemView.findViewById(R.id.jobExpSubTxt)
        val jobAppAnnSalTxt: TextView = itemView.findViewById(R.id.jobAppAnnSalTxt)
        val jobTypeTxt: TextView = itemView.findViewById(R.id.jobTypeTxt)
        val jobTimeTypeTxt: TextView = itemView.findViewById(R.id.jobTimeTypeTxt)
        val jobCompanyTxt: TextView = itemView.findViewById(R.id.jobExpCompTxt)
        val jobRecNameTxt: TextView = itemView.findViewById(R.id.jobExpDesignTxt)
        val jobAppNameTxt: TextView = itemView.findViewById(R.id.jobAppNameTxt)
        val jobEmpDescTxt: TextView = itemView.findViewById(R.id.jobEmpDescTxt)

        fun navigateToRecPage() {
            binding.root.findNavController().navigate(R.id.recruiterPageFragment)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemJobAppliedBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = jobList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemJobModel = jobList[position]

        holder.jobTitle.text = ItemJobModel.jobTitle
        holder.jobCompanyTxt.text = ItemJobModel.jobTitle
        holder.jobAppAnnSalTxt.text = "Rs. "+ItemJobModel.jobExMinSalary +"-"+ItemJobModel.jobExMaxSalary +" LPA"
        holder.jobEmpDescTxt.text = ItemJobModel.jobDescription
        holder.jobQualification.text =ItemJobModel.jobQualification
        holder.jobTypeTxt.text = ItemJobModel.jobEmpType
        holder.jobExpSubTxt.text = ItemJobModel.jobExperience
        holder.jobTimeTypeTxt.text = ItemJobModel.jobJobType
        holder.jobExpSubTxt.text = ItemJobModel.jobExperience




        holder.binding.rootLayout.setOnClickListener {
            holder.navigateToRecPage()
        }
    }
}