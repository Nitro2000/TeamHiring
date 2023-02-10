package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.teamhiring.HelperFunction
import com.example.teamhiring.R
import com.example.teamhiring.databinding.FragmentAppliedJobBinding
import com.example.teamhiring.databinding.FragmentChatBinding


class AppliedJobFragment : Fragment() {
    private lateinit var mActivity: FragmentActivity
    private lateinit var mContext: Context

    private lateinit var binding: FragmentAppliedJobBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mActivity = requireActivity()
        mContext  = requireContext()

        HelperFunction.bottomNavBarVisibility(mActivity, View.VISIBLE)
        // Inflate the layout for this fragment
        binding = FragmentAppliedJobBinding.inflate(inflater, container, false)
        return binding.root
    }


}