package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.data.constants.Constant
import com.example.teamhiring.databinding.FragmentSignInBinding
import com.example.teamhiring.presentation.viewmodels.CommonViewModel

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private val viewModel: CommonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = requireContext()
        mActivity = requireActivity()
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.GONE)
        // Inflate the layout for this fragment


        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInRegisterTxt.setOnClickListener {
            navigateToSignUp()
        }

        binding.signInLogBtn.setOnClickListener {
            viewModel.saveLogin(true)
            if (Constant.userType) navigateToHomePage()
            else navigateToRecHomePage()
        }

        binding.signInMobileTxt.setOnClickListener { navigateToMobileLogin() }
    }

    private fun navigateToMobileLogin() {
        val direction = SignInFragmentDirections.actionSignInFragmentToLoginFragment()
        findNavController().navigate(direction)
    }

    private fun navigateToRecHomePage() {
        val direction = SignInFragmentDirections.actionSignInFragmentToRecruiterHomeFragment()
        findNavController().navigate(direction)
    }
    private fun navigateToHomePage() {
        val direction = SignInFragmentDirections.actionSignInFragmentToHomeFragmentSeeker()
        findNavController().navigate(direction)
    }

    private fun navigateToSignUp() {
        val direction = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
        findNavController().navigate(direction)
    }


}