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
import com.example.teamhiring.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireContext()
        mActivity = requireActivity()
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.GONE)
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpLogBtn.setOnClickListener {
            navigateToOtp()
        }

    }


    private fun navigateToOtp() {
        val direction = SignUpFragmentDirections.actionSignUpFragmentToOtpFragment()
        findNavController().navigate(direction)
    }

}