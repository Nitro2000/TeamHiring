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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.CommonUiFunctions.startShimmer
import com.example.teamhiring.CommonUiFunctions.stopShimmer
import com.example.teamhiring.data.constants.Constant.LOG_TAG
import com.example.teamhiring.databinding.FragmentRecruiterManageJobBinding
import com.example.teamhiring.presentation.adapters.ManageJobListAdapter
import com.example.teamhiring.presentation.viewmodels.recruiter.RecruiterManageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecruiterManageJobFragment : Fragment() {

    private lateinit var binding: FragmentRecruiterManageJobBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private lateinit var manageJobListAdapter: ManageJobListAdapter
    private val recruiterManageViewModel: RecruiterManageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentRecruiterManageJobBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startShimmer(binding.rPostShimmer, binding.jobManageRecyView)

        viewLifecycleOwner.lifecycleScope.launch{
            recruiterManageViewModel.getPostedJobList().let {
                if (it.isSuccessful) {
                    val postedList = it.body() ?: listOf()
                    manageJobListAdapter = ManageJobListAdapter(postedList, mContext) {jobId ->
                        callPostJobStatusApi(jobId)
                    }
                    setManageListAdapter()
                } else {
                    Log.d(LOG_TAG, "${it.errorBody()}")
                }
            }
        }
    }

    private fun setManageListAdapter() {
        binding.jobManageRecyView.apply {
            adapter = manageJobListAdapter
            layoutManager = LinearLayoutManager(mContext)
            stopShimmer(binding.rPostShimmer, binding.jobManageRecyView)
        }
    }

    private fun callPostJobStatusApi(jobId: Int) {
        viewLifecycleOwner.lifecycleScope.launch {
            recruiterManageViewModel.callPostJobStatusApi(jobId).let {
                Log.d(LOG_TAG, "Posted Job: $jobId: ${it.body()}")
            }
        }
    }

}