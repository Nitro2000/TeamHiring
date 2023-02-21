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
import com.example.teamhiring.HelperFunction
import com.example.teamhiring.data.constants.enums.RecFragInfoEnum
import com.example.teamhiring.data.dataList.PreDefinedList
import com.example.teamhiring.databinding.FragmentRecruiterSavedBinding
import com.example.teamhiring.databinding.SideSheetRecSavedBinding
import com.example.teamhiring.presentation.adapters.EmpListAdapter
import com.example.teamhiring.presentation.adapters.RecSavedPostJobListAdapter
import com.example.teamhiring.presentation.viewmodels.recruiter.RecruiterViewModel
import com.google.android.material.sidesheet.SideSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecruiterSavedFragment : Fragment() {

    private lateinit var binding: FragmentRecruiterSavedBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private lateinit var empListAdapter: EmpListAdapter
    private val recruiterViewModel: RecruiterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentRecruiterSavedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getEmpData()
        setChipData()
        val sideSheet = SideSheetDialog(mContext)
//        sideSheet.setContentView(R.layout.side_sheet_rec_saved)
        val sideSheetBinding = SideSheetRecSavedBinding.inflate(LayoutInflater.from(mContext))
        sideSheet.setContentView(sideSheetBinding.root)
        binding.rSavedFilterCandTxt.setOnClickListener {
            sideSheet.show()
        }
        sideSheetBinding.postSheetRecview.apply {
            adapter = RecSavedPostJobListAdapter() {

            }
            layoutManager = LinearLayoutManager(mContext)
        }
    }

    private fun setChipData() {
        for (text in PreDefinedList.jobPostTempList) {
            binding.rSavedChipGroup.addView(HelperFunction.createChip(text, mContext))
        }
    }

    private fun getEmpData() {
        viewLifecycleOwner.lifecycleScope.launch {
            recruiterViewModel.getEmpList().let {
                if (it.isSuccessful) {
                    val list = it.body() ?: listOf()
                    empListAdapter = EmpListAdapter(list, RecFragInfoEnum.RecSaved,  mContext)
                    setEmpListAdapter()
                    Log.d("rishabh", "${it.body()}")
                } else {
                    Log.d("rishabh", "${it.errorBody()}")
                }
            }
        }
    }

    private fun setEmpListAdapter() {
        binding.jobSavedRecyView.apply {
            adapter = empListAdapter
            layoutManager = LinearLayoutManager(mContext)
        }
    }

}