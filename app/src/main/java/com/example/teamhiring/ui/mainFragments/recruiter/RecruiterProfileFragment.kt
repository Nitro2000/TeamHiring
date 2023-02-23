package com.example.teamhiring.ui.mainFragments.recruiter

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
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.Constant
import com.example.teamhiring.data.models.recruiter.RecProfileData
import com.example.teamhiring.databinding.FragmentHomeRecruiterBinding
import com.example.teamhiring.databinding.FragmentRecruiterProfileBinding
import com.example.teamhiring.presentation.viewmodels.recruiter.RecruiterViewModel
import kotlinx.coroutines.launch


class RecruiterProfileFragment : Fragment() {


    private lateinit var binding: FragmentRecruiterProfileBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private lateinit var recProfileData: RecProfileData
    private val recViewModel: RecruiterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentRecruiterProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun getProfData() {
        viewLifecycleOwner.lifecycleScope.launch {
            recViewModel.getRecProfileData().let {
                if (it.isSuccessful) {
                    recProfileData = it.body()?.get(0) ?: RecProfileData()
                    setProfileData()
                } else {
                    Log.d(Constant.LOG_TAG, "${it.errorBody()}")
                }
            }
        }
    }

    private fun setProfileData() {
        binding.apply {
            rProfNameTxt.text = recProfileData.rName
            rProfComName.text = recProfileData.name
            rProfExpDesignTxt.text = recProfileData.rDesig
            rProfIndTypeTxt.text = recProfileData.comType
            rProfEmailTxt.text = recProfileData.email
            rProfConNumTxt.text = recProfileData.number
            rProfComGSTNumTxt.text = recProfileData.cGst
            rProfNumEmpTxt.text = recProfileData.nEmp

            rProfAddTxt.text = recProfileData.adress
            rProfCityTxt.text = recProfileData.city
            rProfStateTxt.text = recProfileData.state
            rProfZipTxt.text = recProfileData.zip
        }
    }

    private fun changeTextColor() {

    }


}