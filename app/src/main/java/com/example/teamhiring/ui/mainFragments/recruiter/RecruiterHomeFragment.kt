package com.example.teamhiring.ui.mainFragments.recruiter

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.CommonUiFunctions.createChip
import com.example.teamhiring.CommonUiFunctions.startShimmer
import com.example.teamhiring.CommonUiFunctions.stopShimmer
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.Constant.LOG_TAG
import com.example.teamhiring.data.constants.enums.RecFragInfoEnum
import com.example.teamhiring.data.dataList.PreDefinedList.jobPostTempList
import com.example.teamhiring.data.models.recruiter.PostedJobData
import com.example.teamhiring.databinding.FragmentHomeRecruiterBinding
import com.example.teamhiring.presentation.adapters.EmpListAdapter
import com.example.teamhiring.presentation.adapters.PostedJobListAdapter
import com.example.teamhiring.presentation.adapters.RecSavedPostJobListAdapter
import com.example.teamhiring.presentation.viewmodels.recruiter.RecruiterManageViewModel
import com.example.teamhiring.presentation.viewmodels.recruiter.RecruiterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecruiterHomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeRecruiterBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private lateinit var empListAdapter: EmpListAdapter
    private lateinit var postJobAdapter: PostedJobListAdapter
    private val recruiterViewModel: RecruiterViewModel by viewModels()
    private val recPostViewModel: RecruiterManageViewModel by viewModels()
    private var shimmerAndDataFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shimmerAndDataFlag = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentHomeRecruiterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.VISIBLE)
        CommonUiFunctions.changeStatusBarColor(mActivity, R.color.text_heading)
        if (shimmerAndDataFlag) {
            getEmpData(null)
            getPostedJobs()
            startShimmer(binding.rHomePostShimmer, binding.rHomeJobPostedRecView)
            startShimmer(binding.rHomeEmpListShimmer, binding.rHomeCandidatesRecView)
        } else {

            binding.apply {
                rHomeJobPostedRecView.apply {
                    adapter = postJobAdapter
                    visibility = View.VISIBLE
                }
                rHomeCandidatesRecView.apply {
                    adapter = empListAdapter
                    visibility = View.VISIBLE
                }
            }
        }

        binding.rHomeSearch.setOnClickListener {
            val directions = RecruiterHomeFragmentDirections.actionRecruiterHomeFragmentToRecruiterSearchFragment()
            findNavController().navigate(directions)
        }

        binding.swipeRefresh.setOnRefreshListener {
            Log.d(LOG_TAG, "refreshed")
            binding.swipeRefresh.isRefreshing = false
        }

    }


    private fun setChipData(chipList: List<String>) {
        binding.rHomeChipGroup.removeAllViews()
        for (text in chipList) {
            binding.rHomeChipGroup.addView(createChip(text, R.color.white, mContext))
        }
    }


    private fun getPostedJobs() {
        viewLifecycleOwner.lifecycleScope.launch {
            recPostViewModel.getPostedJobList().let {
                if (it.isSuccessful) {
                    val list = it.body() ?: listOf()
                    postJobAdapter = PostedJobListAdapter(list) { jobId, chipList ->
                        setChipData(chipList)
                        getEmpData(jobId)
                    }
                    setPostJobAdapter()
                } else {
                    Log.d(LOG_TAG, "${it.errorBody()}")
                }
            }
        }
    }


    private fun getEmpData(jobId: Int?) {
        if (jobId != null) startShimmer(binding.rHomeEmpListShimmer, binding.rHomeCandidatesRecView)
        viewLifecycleOwner.lifecycleScope.launch {
            recruiterViewModel.getEmpList(jobId).let {
                if (it.isSuccessful) {
                    val list = it.body() ?: listOf()
                    empListAdapter = EmpListAdapter(list, RecFragInfoEnum.RecHome, mContext)
                    setEmpListAdapter()
                } else {
                    Log.d(LOG_TAG, "${it.errorBody()}")
                }
            }
        }
    }

    private fun setEmpListAdapter() {
        binding.rHomeCandidatesRecView.apply {
            adapter = empListAdapter
            stopShimmer(binding.rHomeEmpListShimmer, this)
            shimmerAndDataFlag = false
        }
    }

    private fun setPostJobAdapter() {
        binding.rHomeJobPostedRecView.apply {
            adapter = postJobAdapter
            stopShimmer(binding.rHomePostShimmer, this)
        }
    }


}