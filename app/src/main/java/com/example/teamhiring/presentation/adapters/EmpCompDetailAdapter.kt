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
import com.example.teamhiring.data.models.AllPreviousCom
import com.example.teamhiring.data.models.EmpExpData
import com.example.teamhiring.databinding.ItemEmpCompanyListBinding
import com.example.teamhiring.databinding.ItemJobAppliedBinding

class EmpCompDetailAdapter(val prevCompList: List<AllPreviousCom?>, val context: Context): RecyclerView.Adapter<EmpCompDetailAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemEmpCompanyListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(listItem: AllPreviousCom) {
            binding.apply {
                empCurrCompNameTxt.text = listItem.cName
                empCurrDesignTxt.text = listItem.pDesig
                empCurrJobDateTxt.text = context.getString(R.string.date_format, listItem.dateFrom, listItem.dateTo)
                empCurrNoticePeriod.visibility = View.GONE
            }
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEmpCompanyListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = prevCompList[position] ?: AllPreviousCom()
        holder.bind(listItem)
    }

    override fun getItemCount(): Int = prevCompList.size
}