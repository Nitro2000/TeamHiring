package com.example.teamhiring.ui.mainFragments.recruiter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.teamhiring.R
import com.example.teamhiring.data.dataList.PreDefinedList
import com.example.teamhiring.databinding.FragmentInteractedJobBinding
import com.example.teamhiring.databinding.FragmentRecruiterInteractedBinding
import com.example.teamhiring.presentation.adapters.ViewPagerFragAdapter
import com.google.android.material.tabs.TabLayoutMediator

class RecruiterInteractedFragment : Fragment() {


    private lateinit var binding: FragmentRecruiterInteractedBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private lateinit var adapter: ViewPagerFragAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentRecruiterInteractedBinding.inflate(inflater, container, false)
        adapter = ViewPagerFragAdapter(PreDefinedList.recInteractedFragmentList, this.childFragmentManager, this.lifecycle)

        binding.jobViewPager.adapter = adapter
        TabLayoutMediator(binding.tablayout, binding.jobViewPager) {tab, pos ->
            tab.text = PreDefinedList.recInteractFragmentNamesList[pos]
        }.attach()
        return binding.root
    }

}