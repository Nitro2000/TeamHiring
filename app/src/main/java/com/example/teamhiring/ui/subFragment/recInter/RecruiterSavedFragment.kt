package com.example.teamhiring.ui.subFragment.recInter

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.data.constants.enums.RecFragInfoEnum
import com.example.teamhiring.data.dataList.PreDefinedList
import com.example.teamhiring.databinding.FragmentRecruiterSavedBinding
import com.example.teamhiring.databinding.SideSheetRecSavedBinding
import com.example.teamhiring.presentation.adapters.EmpListAdapter
import com.example.teamhiring.presentation.adapters.RecSavedPostJobListAdapter
import com.example.teamhiring.presentation.viewmodels.recruiter.RecruiterManageViewModel
import com.google.android.material.sidesheet.SideSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecruiterSavedFragment : Fragment() {

    private lateinit var binding: FragmentRecruiterSavedBinding
    private lateinit var sideSheetBinding: SideSheetRecSavedBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private lateinit var empListAdapter: EmpListAdapter
    private lateinit var postJobListAdapter: RecSavedPostJobListAdapter
    private lateinit var sideSheet: SideSheetDialog
    private val recManageViewModel: RecruiterManageViewModel by viewModels()
    private var stackFlag: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stackFlag = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mContext = requireContext()
        mActivity = requireActivity()
        sideSheet = SideSheetDialog(mContext)
        binding = FragmentRecruiterSavedBinding.inflate(inflater, container, false)
        sideSheetBinding = SideSheetRecSavedBinding.inflate(LayoutInflater.from(mContext))
        sideSheet.setContentView(sideSheetBinding.root)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (stackFlag) {
            getAllSavedCan()
            getPostedJobs()
        }

        binding.rSavedFilterCandTxt.setOnClickListener {
            sideSheet.show()
        }

    }

    private fun getPostedJobs() {
        viewLifecycleOwner.lifecycleScope.launch {
            recManageViewModel.getPostedJobList().let {
                if (it.isSuccessful) {
                    val list = it.body() ?: listOf()
                    postJobListAdapter = RecSavedPostJobListAdapter(list) {jobId, chipList ->
                        getAllSavedCan(jobId)
                        setChipData(chipList)
                        sideSheet.hide()
                    }
                    setSideSheetAdapter()
                } else {
                    Log.d("Hiring", "${it.errorBody()}")
                }
            }
        }
    }

    private fun setChipData(chipList: List<String>) {
        binding.rSavedChipGroup.visibility = View.VISIBLE
        binding.rSavedChipGroup.removeAllViews()
        for (text in chipList) {
            binding.rSavedChipGroup.addView(CommonUiFunctions.createChip(text, mContext))
        }
    }

    private fun getAllSavedCan(jobId: Int? = null) {
        viewLifecycleOwner.lifecycleScope.launch {
            recManageViewModel.getSavedCandidates(12, jobId).let {
//                Log.d("Rishabh", "${it.code()}" + " header ${it.headers()}")
                val responseBody = it.body()
                if (it.isSuccessful) {
                    val status = responseBody?.status
                    if (status == 200) {
                        val list = responseBody.data
                        empListAdapter = EmpListAdapter(list, RecFragInfoEnum.RecSaved,  mContext)
                        setEmpListAdapter()
                    } else {
                        Toast.makeText(mContext, "No data present", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.d("Hiring", "${it.errorBody()}")
                }
            }
        }
    }

    private fun setEmpListAdapter() {
        binding.jobSavedRecyView.apply {
            adapter = empListAdapter
        }
    }

    private fun setSideSheetAdapter() {
        sideSheetBinding.postSheetRecview.apply {
            adapter = postJobListAdapter
        }
    }

}