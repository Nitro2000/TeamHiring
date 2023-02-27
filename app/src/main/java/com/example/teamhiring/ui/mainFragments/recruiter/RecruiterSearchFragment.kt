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
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.R
import com.example.teamhiring.data.dataList.PreDefinedList
import com.example.teamhiring.data.dataList.PreDefinedList.ageList
import com.example.teamhiring.data.dataList.PreDefinedList.engList
import com.example.teamhiring.data.dataList.PreDefinedList.formattedExpList
import com.example.teamhiring.data.dataList.PreDefinedList.qualList
import com.example.teamhiring.databinding.FragmentRecruiterSearchBinding
import com.example.teamhiring.databinding.SideSheetRecSavedBinding
import com.example.teamhiring.databinding.SideSheetRecSearchBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.sidesheet.SideSheetDialog

class RecruiterSearchFragment : Fragment() {


    private lateinit var binding: FragmentRecruiterSearchBinding
    private lateinit var sideSheetBinding: SideSheetRecSearchBinding
    private lateinit var sideSheet: SideSheetDialog
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        sideSheet = SideSheetDialog(mContext)
        binding = FragmentRecruiterSearchBinding.inflate(inflater, container, false)
        sideSheetBinding = SideSheetRecSearchBinding.inflate(LayoutInflater.from(mContext))
        sideSheet.setContentView(sideSheetBinding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.GONE)

        // Setting chip group
        setChipData(PreDefinedList.formattedExpList, binding.searchExpChipG)
        setChipData(PreDefinedList.jobTypeList, binding.searchJobTypeChipG)
        setChipData(PreDefinedList.empTimeType, binding.searchJobCatChipG)

        // Setting radio group
        setRadioData(qualList, sideSheetBinding.filterQualRadioG)
        setRadioData(ageList, sideSheetBinding.filterAgeRadioG)
        setRadioData(engList, sideSheetBinding.filterEngRadioG)

        binding.filterSearchImg.setOnClickListener {
            sideSheet.show()
        }

        binding.arrowBack.setOnClickListener {
            findNavController().popBackStack()
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

    private fun setChipData(chipList: List<String>, chipGroup: ChipGroup) {
        for (text in chipList) {
            val chip = layoutInflater.inflate(R.layout.item_chip_rec_search, chipGroup, false) as Chip
            chip.text = text
            chipGroup.addView(chip)
        }
        val chip = chipGroup.getChildAt(0) as Chip
        chip.isChecked = true

    }

    private fun setRadioData(radioList: List<String>, radioGroup: RadioGroup) {
        for (text in radioList) {
            val rad = layoutInflater.inflate(R.layout.item_radio_button_rec_search, radioGroup, false) as RadioButton
            rad.text = text
            radioGroup.addView(rad)
        }
        val first: RadioButton = radioGroup.getChildAt(0) as RadioButton
        first.isChecked = true
    }

}