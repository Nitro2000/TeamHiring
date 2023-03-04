package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.HelperFunction
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.NetworkResult
import com.example.teamhiring.data.models.EmpLoginBody
import com.example.teamhiring.data.models.EmpRegisterBody
import com.example.teamhiring.databinding.FragmentSignInBinding
import com.example.teamhiring.databinding.FragmentSignUpBinding
import com.example.teamhiring.presentation.viewmodels.EmpLoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private val empLoginViewModel: EmpLoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mContext = requireContext()
        mActivity = requireActivity()
        HelperFunction.bottomNavBarVisibility(mActivity, View.GONE)
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpLogBtn.setOnClickListener {
            navigateToOtp()

            val validationResult = validateUserInput()
            if (validationResult.first) {
                val userRequest = getUserRequest()
                empLoginViewModel.registerUser(userRequest)
            } else {
                showValidationErrors(validationResult.second)
            }

            bindObservers()
        }

    }
    private fun getUserRequest(): EmpRegisterBody {
        return binding.run {
            EmpRegisterBody(
                signUpComNameEdTxt.editText?.text.toString(),
                signUpEmailEdTxt.editText?.text.toString(),
                signUpMobileEdTxt.editText?.text.toString(),
                signUpPassEdTxt.editText?.text.toString()
            )
        }
    }

    private fun showValidationErrors(error: String) {
    }


    private fun bindObservers(){
        empLoginViewModel.userResponseLiveData.observe(viewLifecycleOwner, Observer {
            when (it){
                is NetworkResult.Success -> {
                    navigateToOtp()
                }

                is NetworkResult.Error -> {
                    showValidationErrors(it.message.toString())
                }

                is NetworkResult.Loading -> {

                }
            }
        })
    }

    private fun validateUserInput(): Pair<Boolean, String> {
        val emailAddress: String = binding.signUpEmailEdTxt.editText?.text.toString()
        val password = binding.signUpPassEdTxt.editText?.text.toString()
        val name: String = binding.signUpComNameEdTxt.editText?.text.toString()
        val mobile = binding.signUpMobileEdTxt.editText?.text.toString()
        return empLoginViewModel.validateRegisterCredentials(name, emailAddress, mobile, password, true)
    }


    private fun navigateToOtp() {
        val direction = SignUpFragmentDirections.actionSignUpFragmentToOtpFragment()
        findNavController().navigate(direction)
    }

}