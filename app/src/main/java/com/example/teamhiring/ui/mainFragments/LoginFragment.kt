package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireActivity()
        mActivity = requireActivity()
        CommonUiFunctions.bottomNavBarVisibility(mActivity,View.GONE)
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //signUp button click---------------------
        binding.loginLogBtn.setOnClickListener {
            navigateToOtp()
        }
    }

    private fun navigateToOtp() {
        val direction = LoginFragmentDirections.actionLoginFragmentToOtpFragment()
        findNavController().navigate(direction)
    }
}