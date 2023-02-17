package com.example.teamhiring.ui.mainFragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.HelperFunction
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.Constant
import com.example.teamhiring.databinding.FragmentUserSelectBinding
import com.example.teamhiring.presentation.viewmodels.CommonViewModel

class UserSelectFragment : Fragment() {

    private lateinit var binding: FragmentUserSelectBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private val viewModel: CommonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireContext()
        mActivity = requireActivity()
        HelperFunction.bottomNavBarVisibility(mActivity, View.GONE)
        // Inflate the layout for this fragment
        binding =  FragmentUserSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.userSelectSeekerBtn.setOnClickListener {
            saveToDataStore(true)
            navigateToSignInFragment()
        }

        binding.userSelectRecruiterBtn.setOnClickListener {
            saveToDataStore(false)
            navigateToSignInFragment()
        }
    }

    private fun saveToDataStore(isEmployee: Boolean) {
        Constant.userType = isEmployee
        viewModel.saveUserType(isEmployee)
    }

    private fun navigateToSignInFragment() {
        val direction = UserSelectFragmentDirections.actionUserSelectFragmentToSignInFragment()
        findNavController().navigate(direction)
    }
}