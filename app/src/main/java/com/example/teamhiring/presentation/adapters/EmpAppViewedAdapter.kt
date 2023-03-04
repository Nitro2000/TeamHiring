package com.example.teamhiring.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.data.models.EmpAppViewedData
import com.example.teamhiring.databinding.ItemJobAppliedBinding
import com.example.teamhiring.ui.mainFragments.ProfileFragmentDirections

class EmpAppViewedAdapter(val viewedByList: List<EmpAppViewedData>): RecyclerView.Adapter<EmpAppViewedAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: ItemJobAppliedBinding): RecyclerView.ViewHolder(binding.root) {
        val jobViewedTitle: TextView = itemView.findViewById(R.id.jobTitleTxt)
        val jobViewedQualification: TextView = itemView.findViewById(R.id.jobHighQualTxt)
        val jobViewedExpSubTxt: TextView = itemView.findViewById(R.id.jobExpSubTxt)
        val jobViewedAppAnnSalTxt: TextView = itemView.findViewById(R.id.jobAppAnnSalTxt)
        val jobViewedTypeTxt: TextView = itemView.findViewById(R.id.jobTypeTxt)
        val jobViewedTimeTypeTxt: TextView = itemView.findViewById(R.id.jobTimeTypeTxt)
        val jobViewedCompanyTxt: TextView = itemView.findViewById(R.id.jobExpCompTxt)
        val jobViewedRecNameTxt: TextView = itemView.findViewById(R.id.jobExpDesignTxt)
        val jobViewedAppNameTxt: TextView = itemView.findViewById(R.id.jobAppNameTxt)
        val jobViewedEmpDescTxt: TextView = itemView.findViewById(R.id.jobEmpDescTxt)

        fun navigateToRecPage() {
            binding.root.findNavController().navigate(R.id.recruiterPageFragment)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemJobAppliedBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = viewedByList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemViewedByModel = viewedByList[position]

        holder.jobViewedTitle.text = ItemViewedByModel.jobViewedTitle
        holder.jobViewedCompanyTxt.text = ItemViewedByModel.jobViewedTitle
        holder.jobViewedAppAnnSalTxt.text = "Rs. "+ItemViewedByModel.jobViewedExMinSalary +"-"+ItemViewedByModel.jobViewedExMaxSalary +" LPA"
        holder.jobViewedEmpDescTxt.text = ItemViewedByModel.jobViewedDescription
        holder.jobViewedQualification.text =ItemViewedByModel.jobViewedQualification
        holder.jobViewedTypeTxt.text = ItemViewedByModel.jobViewedEmpType
        holder.jobViewedExpSubTxt.text = ItemViewedByModel.jobViewedExperience
        holder.jobViewedTimeTypeTxt.text = ItemViewedByModel.jobViewedJobType
        holder.jobViewedExpSubTxt.text = ItemViewedByModel.jobViewedExperience

        holder.binding.rootLayout.setOnClickListener {
            holder.navigateToRecPage()
        }
    }
}