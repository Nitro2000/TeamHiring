package com.example.teamhiring.ui.mainFragments

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
import com.example.teamhiring.data.constants.enums.JobFragInfoEnum
import com.example.teamhiring.databinding.FragmentChatCompanyBinding
import com.example.teamhiring.databinding.FragmentSearchBinding
import com.example.teamhiring.presentation.adapters.RecJobListAdapter


class SearchFragment : Fragment() {
    private lateinit var mActivity: FragmentActivity
    private lateinit var mContext: Context
     var isFilterShow: Boolean = false

    private lateinit var binding: FragmentSearchBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireContext()
        mActivity = requireActivity()
        // Inflate the layout for this fragment
        binding =  FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchRecyclerView.apply {
            adapter = RecJobListAdapter(JobFragInfoEnum.JobApplied)
            layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        }

        binding.searchFilter.setOnClickListener{

            if (isFilterShow){
                isFilterShow = false
                binding.searchRecyclerView.visibility = View.VISIBLE
                binding.searchFilLayout.visibility = View.GONE
            }else{
                isFilterShow = true
                binding.searchRecyclerView.visibility = View.GONE
                binding.searchFilLayout.visibility = View.VISIBLE
            }

        }

    }
}