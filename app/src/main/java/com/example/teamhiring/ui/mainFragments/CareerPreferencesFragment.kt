package com.example.teamhiring.ui.mainFragments

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
import com.example.teamhiring.HelperFunction
import com.example.teamhiring.R
import com.example.teamhiring.databinding.FragmentCareerPreferencesBinding
import com.example.teamhiring.presentation.viewmodels.EmpProffessionalViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CareerPreferencesFragment : Fragment() {

    private lateinit var mActivity: FragmentActivity
    private lateinit var mContext: Context

    private lateinit var binding: FragmentCareerPreferencesBinding
    private val empProffViewModel: EmpProffessionalViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireContext()
        mActivity = requireActivity()
        HelperFunction.bottomNavBarVisibility(mActivity, View.GONE)
        // Inflate the layout for this fragment
        binding =  FragmentCareerPreferencesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch{
            Log.d("Devashish","Hello Devashish")
            val response = empProffViewModel.getEmpProffData()
            val empProffData = response.body()
            val proffDetail = empProffData?.newPDetails?.get(0)
            if (response.isSuccessful){
                binding.carPrefJob.text = proffDetail?.currComDesig
                binding.carPreExpLabel.text = proffDetail?.currComDesig
                binding.carPrefEmpType.text = proffDetail?.currComName
                binding.carPrefEngTitle.text = proffDetail?.oldDTo
                binding.carPrefCity.text = proffDetail?.currComName
            }else{
                Log.d("Devashish","No data found")

            }
        }
    }
}