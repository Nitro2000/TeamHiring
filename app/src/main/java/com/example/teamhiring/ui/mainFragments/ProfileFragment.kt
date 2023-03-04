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
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.CommonUiFunctions
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamhiring.R
import com.example.teamhiring.databinding.FragmentCareerPreferencesBinding
import com.example.teamhiring.databinding.FragmentOtpBinding
import com.example.teamhiring.databinding.FragmentProfileBinding
import com.example.teamhiring.presentation.adapters.AllJobAdapter
import com.example.teamhiring.presentation.viewmodels.EmpProffessionalViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private val empProffViewModel: EmpProffessionalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireContext()
        mActivity = requireActivity()
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.VISIBLE)
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileCareerPref.setOnClickListener {
            val directions = ProfileFragmentDirections.actionProfileFragmentToCareerPreferencesFragment()
            findNavController().navigate(directions)
        }


        viewLifecycleOwner.lifecycleScope.launch{
            Log.d("Devashish","Hello Devashish")
            val response = empProffViewModel.getEmpProffData()
            val empProffData = response.body()
            val proffDetail = empProffData?.newPDetails?.get(0)
            if (response.isSuccessful){
                binding.profileCurrComp.text = proffDetail?.currComName
                binding.profileDesignation.text = proffDetail?.currComDesig
                binding.profileFromDate.text = proffDetail?.currDFrom
                binding.profileToDate.text = proffDetail?.currDTo
                binding.profileNotice.text = proffDetail?.currNotice
            }else{
                Log.d("Devashish","No data found")

            }
        }
    }


    private fun setData() {

    }
}