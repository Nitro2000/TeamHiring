package com.example.teamhiring.ui.subFragment.jobInfo

import android.content.ContentValues
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
import com.example.teamhiring.data.models.EmpAppViewedData
import com.example.teamhiring.databinding.FragmentJobSavedBinding
import com.example.teamhiring.databinding.FragmentJobViewedByBinding
import com.example.teamhiring.presentation.adapters.EmpAppViewedAdapter
import com.example.teamhiring.presentation.adapters.EmployeeAppliedJobAdapter
import com.example.teamhiring.presentation.adapters.RecJobListAdapter
import com.example.teamhiring.presentation.viewmodels.EmpViewedByViewModel
import com.example.teamhiring.ui.mainFragments.InteractedJobFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class JobViewedByFragment : Fragment() {

    private lateinit var binding: FragmentJobViewedByBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    private val viewedByViewModel: EmpViewedByViewModel by viewModels()
    private lateinit var empViewedList: List<EmpAppViewedData>
    private lateinit var adapter: EmpAppViewedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentJobViewedByBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.jobViewedRecyView.apply {
//            adapter = RecJobListAdapter(JobFragInfoEnum.JobViewed)
//            layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
//        }

        viewLifecycleOwner.lifecycleScope.launch{
            Log.d("Devashish","Hello Devashish")
            val response = viewedByViewModel.getViewedByList()
            if (response.isSuccessful){
                Log.d(ContentValues.TAG, "onViewCreated: Data Found")

                binding.jobViewedRecyView.layoutManager = LinearLayoutManager(mContext)
                empViewedList = response.body()?: listOf()
                adapter = EmpAppViewedAdapter(empViewedList)
                binding.jobViewedRecyView.adapter = adapter
            }else{
                Log.d(ContentValues.TAG, "onViewCreated: No data found")
            }
        }
    }

}