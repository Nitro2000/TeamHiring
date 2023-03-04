package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.teamhiring.CommonUiFunctions
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.R
import com.example.teamhiring.databinding.FragmentCareerPreferencesBinding
import com.example.teamhiring.presentation.viewmodels.EmpCarPrefViewModel
import com.example.teamhiring.presentation.viewmodels.EmpProffessionalViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CareerPreferencesFragment : Fragment() {

    private lateinit var mActivity: FragmentActivity
    private lateinit var mContext: Context

    private lateinit var binding: FragmentCareerPreferencesBinding
    private val empProffViewModel: EmpCarPrefViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireContext()
        mActivity = requireActivity()
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.GONE)
        // Inflate the layout for this fragment
        binding =  FragmentCareerPreferencesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCareerData()
        binding.profileBackBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.editCarPref.setOnClickListener{
            binding.carPrefJob.isEnabled
            binding.carPreExpLabel.isEnabled
            binding.carPrefEmpType.isEnabled
            binding.carPrefEngTitle.isEnabled
            binding.carPrefCity.isEnabled
            binding.carPrefExpSalary.isEnabled
            binding.carPrefSkills.isEnabled
            binding.carPrefState.isEnabled
            binding.carPrefShift.isEnabled
            binding.carPrefJobType.isEnabled
            binding.carPreExpLabel.isEnabled
            binding.carTotalExp.isEnabled

        }

    }



    private fun getCareerData() {
        viewLifecycleOwner.lifecycleScope.launch{
            Log.d("Devashish","Hello Devashish")
            val response = empProffViewModel.getEmpCarPrefData()
            val empProffData = response.body()
            val carPrefDetail = empProffData?.get(0)
            if (response.isSuccessful){
                binding.carPrefJob.text = carPrefDetail?.empJobRoles
                binding.carPreExpLabel.text = carPrefDetail?.empTypeExp
                binding.carPrefEmpType.text = carPrefDetail?.empTypeOH
                binding.carPrefEngTitle.text = carPrefDetail?.empEnglishLabel
                binding.carPrefCity.text = carPrefDetail?.empPrefCities
                binding.carPrefExpSalary.text = carPrefDetail?.empSalaryLakh+","+carPrefDetail?.empSalaryThousand
                binding.carPrefSkills.text = carPrefDetail?.empSkills
                binding.carPrefState.text = carPrefDetail?.empPrefState
                binding.carPrefShift.text = carPrefDetail?.empPrefShift
                binding.carPrefJobType.text = carPrefDetail?.empPrefEmpType
                binding.carTotalExp.text = carPrefDetail?.empExpYear+" years"+ carPrefDetail?.empExpMonth+" months"


            }else{
                Log.d("Devashish","No data found")

            }
        }

    }
}