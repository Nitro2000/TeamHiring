package com.example.teamhiring.ui.mainFragments.recruiter

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.navArgs
import com.example.teamhiring.R
import com.example.teamhiring.data.dataList.PreDefinedList.recChipGroupList
import com.example.teamhiring.databinding.FragmentJobSavedBinding
import com.example.teamhiring.databinding.FragmentRecruiterPageBinding
import com.google.android.material.chip.Chip

class RecruiterPageFragment : Fragment() {


    private lateinit var binding: FragmentRecruiterPageBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private val recPageArgs: RecruiterPageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentRecruiterPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jobId = recPageArgs.recId
        Log.d("rishabh    ", jobId)
        for (head in recChipGroupList) {
            val chip = Chip(mContext)
            chip.text = head
            binding.recChipGroup.addView(chip)
        }
    }
}