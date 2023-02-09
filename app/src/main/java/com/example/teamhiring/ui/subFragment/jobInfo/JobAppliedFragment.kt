package com.example.teamhiring.ui.subFragment.jobInfo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.R
import com.example.teamhiring.databinding.FragmentInteractedJobBinding
import com.example.teamhiring.databinding.FragmentJobAppliedBinding
import com.example.teamhiring.presentation.adapters.JobListAdapter


class JobAppliedFragment : Fragment() {


    private lateinit var binding: FragmentJobAppliedBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentJobAppliedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.jobAppRecyView.apply {
            adapter = JobListAdapter()
            layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        }


    }

}