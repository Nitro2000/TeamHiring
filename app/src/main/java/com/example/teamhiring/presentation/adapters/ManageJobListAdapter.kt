package com.example.teamhiring.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum.*
import com.example.teamhiring.data.models.recruiter.PostedJobData
import com.example.teamhiring.databinding.ItemJobAppliedBinding
import com.example.teamhiring.databinding.ItemManageJobBinding

class ManageJobListAdapter(val postedJobList: List<PostedJobData>, val context: Context): RecyclerView.Adapter<ManageJobListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemManageJobBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PostedJobData) {
            binding.apply {
                jobTitleTxt.text = item.jTitle
                jobHighQualTxt.text = item.quali
                jobTypeTxt.text = item.empType
                jobTimeTypeTxt.text = item.jobtype
                jobExpCompTxt.text = item.shift
                jobCompLocatTxt.text = item.city
                jobAppAnnSalTxt.text = context.getString(R.string.ann_income, item.sMin?.toInt(), item.sMax?.toInt())
                jobResponsesTxt.text = context.getString(R.string.num_responses, item.numberOfResponse?.toInt())
                jobExpSubTxt.text = item.experience
            }

        }

        fun navigateToRecPage() {
            binding.root.findNavController().navigate(R.id.recruiterPageFragment)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemManageJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = postedJobList[position]
        holder.bind(item)
//        when(type) {
//            JobApplied -> {
//
//            }
//            JobSaved -> {
//                holder.binding.jobStarImg.setImageResource(R.drawable.icon_start_filled)
//            }
//            JobViewed -> {
//                holder.binding.jobStarImg.setImageResource(R.drawable.icon_viewed)
//            }
//        }
//        holder.binding.rootLayout.setOnClickListener {
//            holder.navigateToRecPage()
//        }
    }

    override fun getItemCount(): Int = postedJobList.size
}