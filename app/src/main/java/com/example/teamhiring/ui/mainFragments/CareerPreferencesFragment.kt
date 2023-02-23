package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.databinding.FragmentCareerPreferencesBinding


class CareerPreferencesFragment : Fragment() {

    private lateinit var mActivity: FragmentActivity
    private lateinit var mContext: Context

    private lateinit var binding: FragmentCareerPreferencesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireContext()
        mActivity = requireActivity()
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.GONE)
        // Inflate the layout for this fragment
        binding =  FragmentCareerPreferencesBinding.inflate(inflater, container, false)
        return binding.root
    }

}