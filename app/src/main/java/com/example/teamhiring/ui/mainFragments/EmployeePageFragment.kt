package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.R
import com.example.teamhiring.data.dataList.PreDefinedList
import com.example.teamhiring.databinding.FragmentEmployeePageBinding
import com.example.teamhiring.databinding.FragmentRecruiterPageBinding


class EmployeePageFragment : Fragment() {


    private lateinit var binding: FragmentEmployeePageBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentEmployeePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.GONE)
        setChipData(PreDefinedList.recChipGroupList)
    }

    private fun setChipData(chipList: List<String>) {
        binding.empChipGroup.removeAllViews()
        for (text in chipList) {
            binding.empChipGroup.addView(CommonUiFunctions.createChip(text, mContext))
        }
    }
}