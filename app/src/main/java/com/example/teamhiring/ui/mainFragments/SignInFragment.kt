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
import com.example.teamhiring.databinding.FragmentSignInBinding
import com.example.teamhiring.helpers.ProgressDialog
import com.example.teamhiring.presentation.viewmodels.EmpLoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private val empLoginViewModel: EmpLoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = requireContext()
        mActivity = requireActivity()
        HelperFunction.bottomNavBarVisibility(mActivity, View.GONE)
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
//            navigateToHomePage()

            val validationResult = validateUserInput()
            if (validationResult.first) {
                val userRequest = getUserRequest()
                empLoginViewModel.loginUser(userRequest)
            } else {
                showValidationErrors(validationResult.second)
            }

            bindObservers()


        }

        binding.signInMobileTxt.setOnClickListener { navigateToMobileLogin() }
    }

    private fun getUserRequest(): EmpLoginBody {
        return binding.run {
            EmpLoginBody(
                signInEmailEdTxt.editText?.text.toString(),
                signInPassEdTxt.editText?.text.toString()
            )
        }
    }

    private fun navigateToMobileLogin() {
        val direction = SignInFragmentDirections.actionSignInFragmentToLoginFragment()
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

    private fun validateUserInput(): Pair<Boolean, String> {
        val emailAddress: String = binding.signInEmailEdTxt.editText?.text.toString()
        val password = binding.signInPassEdTxt.editText?.text.toString()
        return empLoginViewModel.validateLoginCredentials(emailAddress, password, true)
    }

    private fun bindObservers() {
        empLoginViewModel.userResponseLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is NetworkResult.Success -> {
                    navigateToHomePage()
                }
                is NetworkResult.Error -> {
                    showValidationErrors(it.message.toString())
                }
                is NetworkResult.Loading -> {

                }
            }
        })
    }

    private fun showValidationErrors(error: String) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        empLoginViewModel.userResponseLiveData.removeObservers(viewLifecycleOwner)
    }
}