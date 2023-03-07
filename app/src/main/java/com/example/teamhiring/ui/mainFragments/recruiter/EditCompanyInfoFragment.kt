package com.example.teamhiring.ui.mainFragments.recruiter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.R
import com.example.teamhiring.databinding.FragmentEditCompanyInfoBinding
import com.example.teamhiring.databinding.FragmentRecruiterSavedBinding
import com.example.teamhiring.databinding.SideSheetRecSavedBinding
import com.example.teamhiring.presentation.adapters.EmpListAdapter
import com.example.teamhiring.presentation.adapters.RecSavedPostJobListAdapter
import com.example.teamhiring.presentation.viewmodels.recruiter.RecruiterManageViewModel
import com.google.android.material.sidesheet.SideSheetDialog


class EditCompanyInfoFragment : Fragment() {


    private lateinit var binding: FragmentEditCompanyInfoBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentEditCompanyInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CommonUiFunctions.apply {
            changeStatusBarColor(mActivity, R.color.edit_profile)
            bottomNavBarVisibility(mActivity, View.GONE)
        }

    }


}