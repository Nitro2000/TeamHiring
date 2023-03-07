package com.example.teamhiring.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.CommonDataFunctions
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum.*
import com.example.teamhiring.data.models.recruiter.PostedJobData
import com.example.teamhiring.databinding.ItemJobAppliedBinding
import com.example.teamhiring.databinding.ItemManageJobBinding

class ManageJobListAdapter(
    val postedJobList: List<PostedJobData>,
    val context: Context,
    val callback: (jobId: Int) -> Any
) : RecyclerView.Adapter<ManageJobListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemManageJobBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PostedJobData) {
            binding.apply {
                jobTitleTxt.text = item.jTitle
                jobHighQualTxt.text = item.quali
                jobTypeTxt.text = item.empType
                jobTimeTypeTxt.text = item.jobtype
                jobExpCompTxt.text = item.shift
                jobCompLocatTxt.text = item.city
                jobAppAnnSalTxt.text = CommonDataFunctions.getFormattedSalary(item.sMin, item.sMax)
                jobResponsesTxt.text =
                    context.getString(R.string.num_responses, item.numberOfResponse?.toInt())
                jobExpSubTxt.text = item.experience
            }

        }

        fun navigateToRecPage() {
            binding.root.findNavController().navigate(R.id.recruiterPageFragment)
        }

        fun setStatusText(status: Boolean) {
            binding.jobOpenClosedTxt.text = if (status) {
                binding.jobOpenClosedSwitch.isChecked = true
                context.getString(R.string.opened)
            } else {
                binding.jobOpenClosedSwitch.isChecked = false
                context.getString(R.string.closed)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemManageJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = postedJobList[position]
        holder.bind(item)
        holder.setStatusText(item.status == "0")
        holder.binding.jobOpenClosedSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            holder.setStatusText(isChecked)
            callback(item.jobId.toInt())
        }
    }

    override fun getItemCount(): Int = postedJobList.size
}