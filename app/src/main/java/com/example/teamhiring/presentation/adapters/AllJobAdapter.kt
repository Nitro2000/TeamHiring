package com.example.teamhiring.presentation.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.databinding.ItemJobAppliedBinding

class AllJobAdapter(val jobList: List<AllJobData>) :
    RecyclerView.Adapter<AllJobAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemJobAppliedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AllJobData){
            binding.jobTitleTxt.text = item.jobTitle
            binding.jobHighQualTxt.text = item.jobQualification
            binding.jobExpSubTxt.text = item.jobExperience
            binding.jobAppAnnSalTxt.text = "Rs. "+item.jobExMinSalary +"-"+item.jobExMaxSalary +" LPA"
            binding.jobTypeTxt.text = item.jobEmpType
            binding.jobTimeTypeTxt.text  = item.jobJobType
            binding.jobExpCompTxt.text = item.jobTitle
            binding.jobEmpDescTxt.text = item.jobDescription
        }

        fun navigateToRecPage(recId: String) {
            val bundle = Bundle()
            bundle.putString("recId", recId)
            binding.root.findNavController().navigate(R.id.recruiterPageFragment, bundle)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemJobAppliedBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = jobList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemJobModel = jobList[position]
        holder.bind(itemJobModel)


        holder.binding.rootLayout.setOnClickListener {
            holder.navigateToRecPage(itemJobModel.jobId ?: "")
        }
    }


}