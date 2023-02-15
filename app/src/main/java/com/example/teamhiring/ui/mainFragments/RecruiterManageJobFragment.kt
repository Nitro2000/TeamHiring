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
import com.example.teamhiring.databinding.FragmentRecruiterManageJobBinding
import com.example.teamhiring.presentation.adapters.ManageJobListAdapter

class RecruiterManageJobFragment : Fragment() {

    private lateinit var binding: FragmentRecruiterManageJobBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentRecruiterManageJobBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.jobManageRecyView.apply {
            adapter = ManageJobListAdapter()

            layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        }
    }

}