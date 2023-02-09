package com.example.teamhiring.ui.mainFragments

import android.R
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.teamhiring.HelperFunction
import com.example.teamhiring.databinding.FragmentHomeSeekerBinding


class HomeFragmentSeeker : Fragment() {

    private lateinit var binding: FragmentHomeSeekerBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireContext()
        mActivity = requireActivity()
        HelperFunction.bottomNavBarVisibility(mActivity, View.VISIBLE)

        // Inflate the layout for this fragment
        binding =  FragmentHomeSeekerBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}