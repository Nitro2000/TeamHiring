package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.CommonDataFunctions
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.R
import com.example.teamhiring.data.dataList.PreDefinedList
import com.example.teamhiring.data.models.AllPreviousCom
import com.example.teamhiring.data.models.NewPDetail
import com.example.teamhiring.databinding.FragmentEmployeePageBinding
import com.example.teamhiring.databinding.FragmentRecruiterPageBinding
import com.example.teamhiring.presentation.adapters.EmpCompDetailAdapter
import com.example.teamhiring.presentation.viewmodels.recruiter.RecruiterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class EmployeePageFragment : Fragment() {

    private lateinit var binding: FragmentEmployeePageBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private val recruiterViewModel: RecruiterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentEmployeePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.GONE)
        getEmpCareerPref()
        getEmpExpData()

        binding.empBackArrImg.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setChipData(chipList: List<String>) {
        for (text in chipList) {
            binding.empChipGroup.addView(CommonUiFunctions.createChip(text, R.color.chip_bg_greyish, mContext))
        }
    }

    private fun getEmpCareerPref() {
        viewLifecycleOwner.lifecycleScope.launch {
            recruiterViewModel.getEmpCareerPref().let {
                if (it.isSuccessful) {
                    val response = it.body()?.get(0)
                    if (response != null) {
                        val skillList: List<String> = response.skills?.split(",") ?: listOf()
                        setChipData(skillList)
                        binding.apply {
                            empJobTitleTxt.text = response.pJobRoles
                            empJobExpTxt.text = response.tExpType
                            jobExpSubTxt.text = CommonDataFunctions.getFormattedExpYr(response.tExpYr, response.tExpMonth)
                            empAppAnnSalTxt.text = CommonDataFunctions.getFormattedSalary(response.pSalL, response.pSalT)
                            empJobTypeTxt.text = CommonDataFunctions.checkJobType(response.eTYpe)
                            empJobTimeTypeTxt.text = CommonDataFunctions.checkJobTimeType(response.pEType)
                            empJobCityTxt.text = response.pCities
                            empJobStateTxt.text = response.stateTitle
                            empJobDescTxt.text = response.objective
                            empJobRoleTxt.text = response.pJobRoles
                            empExpSubTxt.text = CommonDataFunctions.getFormattedExpYr(response.tExpYr, response.tExpMonth)
                        }
                    }
                }
            }
        }
    }

    private fun getEmpExpData() {
        viewLifecycleOwner.lifecycleScope.launch {
            recruiterViewModel.getEmpExpData().let {
                if (it.isSuccessful) {
                    val currComDetail = it.body()?.newPDetails?.get(0)
                    setCurrCompDetail(currComDetail)
                    val prevCompList = it.body()?.allPreviousCom ?: listOf()
                    setPrevComDetail(prevCompList)
                }
            }
        }
    }

    private fun setPrevComDetail(prevCompList: List<AllPreviousCom?>) {
        if (prevCompList.get(0) == null) {
            binding.empPrevComRecView.visibility = View.GONE
        } else {
            binding.empPrevComRecView.adapter = EmpCompDetailAdapter(prevCompList, mContext)
        }
    }

    private fun setCurrCompDetail(currCompPDetail: NewPDetail?) {
        if (currCompPDetail == null) {
            binding.empCompExpLayout.visibility = View.GONE
        } else {
            binding.currComItem.apply {
                empCurrCompNameTxt.text = currCompPDetail.currComName
                empCurrJobDateTxt.text = getString(R.string.date_format, currCompPDetail.currDFrom, currCompPDetail.currDTo)
                empCurrDesignTxt.text = currCompPDetail.currComDesig
                empCurrNoticePeriod.text = getString(R.string.notice_period, currCompPDetail.currNotice)
            }
        }

    }
}