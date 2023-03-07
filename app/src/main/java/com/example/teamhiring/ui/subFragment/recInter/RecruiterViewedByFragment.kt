package com.example.teamhiring.ui.subFragment.recInter

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
import com.example.teamhiring.CommonUiFunctions.startShimmer
import com.example.teamhiring.CommonUiFunctions.stopShimmer
import com.example.teamhiring.data.constants.Constant.LOG_TAG
import com.example.teamhiring.data.models.recruiter.RecNotification
import com.example.teamhiring.databinding.FragmentRecruiterViewedByBinding
import com.example.teamhiring.presentation.adapters.RecViewedByAdapter
import com.example.teamhiring.presentation.viewmodels.recruiter.RecruiterManageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecruiterViewedByFragment : Fragment() {

    private lateinit var binding: FragmentRecruiterViewedByBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private val recManageViewModel: RecruiterManageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentRecruiterViewedByBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startShimmer(binding.rEmpApplyShimmer, binding.rApplyRecyView)
        getAppliedData()
        getViewedData()
    }

    private fun getViewedData() {
        viewLifecycleOwner.lifecycleScope.launch {
            recManageViewModel.getViewedData().let {
                if (it.isSuccessful) {
                    val viewedList = it.body()?.jobViewed ?: listOf()
                    setViewedAdapter(viewedList)
                } else {
                    Log.d(LOG_TAG, "${it.errorBody()}")
                }
            }
        }
    }

    private fun getAppliedData() {
        viewLifecycleOwner.lifecycleScope.launch {
            recManageViewModel.getViewedData().let {
                if (it.isSuccessful) {
                    val appliedList = it.body()?.jobApplied ?: listOf()
                    setAppliedAdapter(appliedList)
                } else {
                    Log.d(LOG_TAG, "${it.errorBody()}")
                }
            }
        }
    }

    private fun setAppliedAdapter(appliedList: List<RecNotification>) {
        binding.rApplyRecyView.adapter = RecViewedByAdapter(appliedList, 0) {}
        stopShimmer(binding.rEmpApplyShimmer, binding.rApplyRecyView)

    }

    private fun setViewedAdapter(viewedList: List<RecNotification>) {
        binding.rViewedRecyView.adapter = RecViewedByAdapter(viewedList, 1) {}
        stopShimmer(binding.rEmpApplyShimmer, binding.rViewedRecyView)
        binding.rViewedEmpTxt.visibility = View.VISIBLE
    }

}