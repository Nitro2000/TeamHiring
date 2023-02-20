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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.databinding.FragmentJobAppliedBinding
import com.example.teamhiring.presentation.adapters.AllJobAdapter
import com.example.teamhiring.presentation.viewmodels.EmployeeAppliedJobViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class JobAppliedFragment : Fragment() {


    private lateinit var binding: FragmentJobAppliedBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    private val appliedJobViewModel: EmployeeAppliedJobViewModel by viewModels()
    private lateinit var appliedJobList: List<AllJobData>
    private lateinit var adapter: AllJobAdapter

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


        viewLifecycleOwner.lifecycleScope.launch{
            Log.d("Devashish","Hello Devashish")
            val response = appliedJobViewModel.getAppliedJob()
            if (response.isSuccessful){
                Log.d(TAG, "onViewCreated: Data Found")

                binding.jobAppRecyView.layoutManager = LinearLayoutManager(mContext)
                appliedJobList = response.body()?: listOf()
                adapter = AllJobAdapter(appliedJobList)
                binding.jobAppRecyView.adapter = adapter
            }else{
                Log.d(TAG, "onViewCreated: No data found")
            }
        }
    }

}