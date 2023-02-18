package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.HelperFunction
import com.example.teamhiring.R
import com.example.teamhiring.data.dataList.PreDefinedList
import com.example.teamhiring.data.dataList.PreDefinedList.jobPostTempList
import com.example.teamhiring.databinding.FragmentHomeBinding
import com.example.teamhiring.databinding.FragmentHomeRecruiterBinding
import com.example.teamhiring.presentation.adapters.EmpListAdapter
import com.example.teamhiring.presentation.adapters.ManageJobListAdapter
import com.example.teamhiring.presentation.adapters.PostedJobListAdapter
import com.example.teamhiring.presentation.viewmodels.RecruiterViewModel
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecruiterHomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private lateinit var empListAdapter: EmpListAdapter
    private val recruiterViewModel: RecruiterViewModel by viewModels()
    private var dataFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataFlag = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HelperFunction.bottomNavBarVisibility(mActivity, View.VISIBLE)
        HelperFunction.changeStatusBarColor(mActivity, R.color.text_heading)
        if (dataFlag) {
            getEmpData()
        }

        binding.rHomeJobPostedRecView.apply {
            adapter = PostedJobListAdapter()
        }

        for (head in jobPostTempList) {
            val chip = Chip(mContext)
            chip.apply {
                text = head
                chipBackgroundColor = getColorStateList(R.color.white)
                chipStrokeWidth = HelperFunction.dpToFloat(mContext, 1)
                setChipStrokeColorResource(R.color.sub_views)
            }

            binding.rHomeChipGroup.addView(chip)
        }
    }

    private val stateList = arrayOf(
        intArrayOf(-android.R.attr.state_checked)
    )

    private fun getColorStateList(color: Int): ColorStateList {
        val colorList = intArrayOf(
            ContextCompat.getColor(mContext, color),
        )
        return ColorStateList(stateList, colorList)
    }

    private fun getEmpData() {
        viewLifecycleOwner.lifecycleScope.launch {
            recruiterViewModel.getEmpList().let {
                if (it.isSuccessful) {
                    val list = it.body() ?: listOf()
                    empListAdapter = EmpListAdapter(list, mContext)
                    setEmpListAdapter()
                    Log.d("rishabh", "${it.body()}")
                } else {
                    Log.d("hiring", "${it.errorBody()}")
                }
            }
        }
    }

    private fun setEmpListAdapter() {
        binding.rHomeCandidatesRecView.apply {
            adapter = empListAdapter
        }
    }


}