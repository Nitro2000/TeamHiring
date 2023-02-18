package com.example.teamhiring.ui.subFragment.jobInfo

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
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum
import com.example.teamhiring.data.models.SavedJobData
import com.example.teamhiring.databinding.FragmentJobAppliedBinding
import com.example.teamhiring.databinding.FragmentJobSavedBinding
import com.example.teamhiring.presentation.adapters.EmployeeSavedJobAdapter
import com.example.teamhiring.presentation.adapters.RecJobListAdapter
import com.example.teamhiring.presentation.viewmodels.EmployeeSavedJobViewModel
import com.example.teamhiring.presentation.viewmodels.ReferenceViewModel
import com.example.teamhiring.ui.mainFragments.InteractedJobFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class JobSavedFragment : Fragment() {


    private lateinit var binding: FragmentJobSavedBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private val savedJobViewModel: EmployeeSavedJobViewModel by viewModels()

    private lateinit var savedJobList: List<SavedJobData>
    private lateinit var adapter: EmployeeSavedJobAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentJobSavedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.jobSavRecyView.apply {
            adapter = RecJobListAdapter(JobFragInfoEnum.JobSaved)
            layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            Log.d("rishabh", "hello")
            val response = savedJobViewModel.getSavedJobs()
            if (response.isSuccessful) {

                binding.jobSavRecyView.layoutManager = LinearLayoutManager(mContext)
                savedJobList = response.body()?: listOf()
                adapter = EmployeeSavedJobAdapter(savedJobList)
                binding.jobSavRecyView.adapter = adapter

                Log.d("rishabh", "${response.body()}")
            } else {
                Log.d("rishabh", "Not found")
            }
        }
//
//        }

    }


}