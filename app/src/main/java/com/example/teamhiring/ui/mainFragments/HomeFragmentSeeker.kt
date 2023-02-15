package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.teamhiring.databinding.FragmentHomeSeekerBinding
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.HelperFunction
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum
import com.example.teamhiring.presentation.adapters.RecJobListAdapter


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
        // Inflate the layout for this fragment
        binding = FragmentHomeSeekerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HelperFunction.changeStatusBarColor(mActivity, R.color.text_heading)

        binding.recyclerViewJobs.apply {
            adapter = RecJobListAdapter(JobFragInfoEnum.JobApplied)
            layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        }

        // TODO Delete after merge
        binding.secondaryText.setOnClickListener {
            val direction = HomeFragmentSeekerDirections.actionHomeFragmentSeekerToRecruiterHomeFragment()
            findNavController().navigate(direction)
        }

        binding.profileImage.setOnClickListener {
            val direction = HomeFragmentSeekerDirections.actionHomeFragmentSeekerToRecruiterManageJobFragment()
            findNavController().navigate(direction)
        }
    }

}