package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.teamhiring.databinding.FragmentHomeSeekerBinding
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum
import com.example.teamhiring.data.dataList.ChatCompanyDataList
import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.presentation.adapters.AllJobAdapter
import com.example.teamhiring.presentation.adapters.ChatCompanyDataAdapter
import com.example.teamhiring.presentation.adapters.RecJobListAdapter
import com.example.teamhiring.presentation.viewmodels.AllJobViewModel
import com.example.teamhiring.presentation.viewmodels.ReferenceViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragmentSeeker : Fragment() {


    private lateinit var binding: FragmentHomeSeekerBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity


    private val allJobViewModel: AllJobViewModel by viewModels()
    private lateinit var jobList: List<AllJobData>
    private lateinit var adpater: AllJobAdapter

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

//        binding.recyclerViewJobs.apply {
//            adapter = RecJobListAdapter(JobFragInfoEnum.JobApplied)
//            layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
//        }

        // TODO Delete after merge
        binding.secondaryText.setOnClickListener {
            val direction = HomeFragmentSeekerDirections.actionHomeFragmentSeekerToRecruiterHomeFragment()
            findNavController().navigate(direction)
        }

        binding.profileImage.setOnClickListener {
            val direction = HomeFragmentSeekerDirections.actionHomeFragmentSeekerToRecruiterProfileFragment()
            findNavController().navigate(direction)
        }

        viewLifecycleOwner.lifecycleScope.launch{
            Log.d("Devashish","Hello Devashish")
            val response = allJobViewModel.getAllJobs()
            if (response.isSuccessful){
                Log.d("Devashish","${response.body()}")
                binding.recyclerViewJobs.layoutManager = LinearLayoutManager(mContext)
                jobList = response.body() ?: listOf()

                adpater = AllJobAdapter(jobList)
                binding.recyclerViewJobs.layoutManager = LinearLayoutManager(mContext)

                binding.recyclerViewJobs.adapter = adpater


            }else{
                Log.d("Devashish","No data found")

            }
        }


    }

}