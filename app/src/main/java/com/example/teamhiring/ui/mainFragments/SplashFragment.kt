package com.example.teamhiring.ui.mainFragments

import android.animation.Animator
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.lifecycle.lifecycleScope
import com.example.teamhiring.R
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.HelperFunction
import com.example.teamhiring.data.constants.Constant
import com.example.teamhiring.data.constants.Constant.userLogin
import com.example.teamhiring.data.constants.Constant.userType
import com.example.teamhiring.databinding.FragmentSplashBinding
import com.example.teamhiring.presentation.viewmodels.CommonViewModel
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private val viewModel: CommonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        HelperFunction.bottomNavBarVisibility(mActivity, View.GONE)
        viewModel.getUserType().observe(viewLifecycleOwner) {
            userType = it
        }
        viewModel.getLogin().observe(viewLifecycleOwner) {
            userLogin = it
        }


        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dashLottie.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator) {
            }
            override fun onAnimationEnd(p0: Animator) {
//                    val direction = if (userLogin) {
//                        if (userType) SplashFragmentDirections.actionSplashFragmentToHomeFragmentSeeker()
//                        else SplashFragmentDirections.actionSplashFragmentToRecruiterHomeFragment()
//                    }
                    val direction = SplashFragmentDirections.actionSplashFragmentToOnBoardingFragment()
                    findNavController().navigate(direction)
            }

            override fun onAnimationCancel(p0: Animator) {
            }
            override fun onAnimationRepeat(p0: Animator) {
            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
//        viewModel.getUserType().removeObservers(viewLifecycleOwner)
//        viewModel.getLogin().removeObservers(viewLifecycleOwner)
    }


}
