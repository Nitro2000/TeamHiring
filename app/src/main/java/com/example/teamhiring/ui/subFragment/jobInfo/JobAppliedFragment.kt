package com.example.teamhiring.ui.subFragment.jobInfo

import android.content.ContentValues.TAG
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum
import com.example.teamhiring.data.models.AppliedJobData
import com.example.teamhiring.databinding.FragmentJobAppliedBinding
import com.example.teamhiring.presentation.adapters.EmployeeAppliedJobAdapter
import com.example.teamhiring.presentation.adapters.RecJobListAdapter
import com.example.teamhiring.presentation.viewmodels.EmployeeAppliedJobViewModel
import com.example.teamhiring.ui.mainFragments.InteractedJobFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class JobAppliedFragment : Fragment() {


    private lateinit var binding: FragmentJobAppliedBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    private val appliedJobViewModel: EmployeeAppliedJobViewModel by viewModels()
    private lateinit var appliedJobList: List<AppliedJobData>
    private lateinit var adapter: EmployeeAppliedJobAdapter

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

//        binding.jobAppRecyView.apply {
//            adapter = RecJobListAdapter(JobFragInfoEnum.JobApplied)
//            layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
//        }


        viewLifecycleOwner.lifecycleScope.launch{
            Log.d("Devashish","Hello Devashish")
            val response = appliedJobViewModel.getAppliedJob()
            if (response.isSuccessful){
                Log.d(TAG, "onViewCreated: Data Found")

                binding.jobAppRecyView.layoutManager = LinearLayoutManager(mContext)
                appliedJobList = response.body()?: listOf()
                adapter = EmployeeAppliedJobAdapter(appliedJobList)
                binding.jobAppRecyView.adapter = adapter
            }else{
                Log.d(TAG, "onViewCreated: No data found")
            }
        }
    }

}