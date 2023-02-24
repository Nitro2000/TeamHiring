package com.example.teamhiring.ui.mainFragments.recruiter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.FragmentActivity
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.R
import com.example.teamhiring.data.dataList.PreDefinedList
import com.example.teamhiring.databinding.FragmentRecruiterSearchBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class RecruiterSearchFragment : Fragment() {


    private lateinit var binding: FragmentRecruiterSearchBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentRecruiterSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.GONE)

        for (text in PreDefinedList.jobPostTempList) {
            val chip = layoutInflater.inflate(R.layout.item_chip_rec_search, binding.searchJobCatChipG, false) as Chip
            chip.text = text
            binding.searchExpChipG.addView(chip)
        }
        binding.searchExpChipG.setOnCheckedStateChangeListener {group, checkedIdList: MutableList<Int> ->
//            val viewd = group.get(checkedIdList[0] - 1) as Chip
//            viewd.chipBackgroundColor = CommonUiFunctions.getColorStateList(mContext, R.color.white)
//            viewd.chipStrokeWidth = CommonUiFunctions.dpToFloat(mContext, 1)
//            viewd.setBackgroundResource(R.drawable.button_round_corner)
//            Toast.makeText(mContext, "${checkedIdList}", Toast.LENGTH_SHORT).show()
        }

//        val arrayAdapter = ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, PreDefinedList.jobPostTempList)
//        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_multichoice)
//        binding.spinner.adapter = arrayAdapter
//
//        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//            }
//        }
    }

}