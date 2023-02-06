package com.example.teamhiring.ui.mainFragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.Constant
import com.example.teamhiring.data.dataList.Drawables
import com.example.teamhiring.data.models.OnBoardData
import com.example.teamhiring.databinding.FragmentOnboardingBinding
import com.example.teamhiring.databinding.FragmentOnboardingBinding.inflate
import com.example.teamhiring.presentation.adapters.OnBoardAdapter
import java.util.*


class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    private lateinit var btnAnimation: Animation

    lateinit var viewPagerAdapter: OnBoardAdapter
    lateinit var imageList: List<OnBoardData>


    private val timer = Timer()
    var position = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Adding image in list-----------------
        imageList = Drawables.imageList

        viewPagerAdapter = OnBoardAdapter(imageList)
        binding.onboardViewPager.adapter = viewPagerAdapter

        btnAnimation = AnimationUtils.loadAnimation(mContext,R.anim.button_animation)

        binding.indicator.attachToPager(binding.onboardViewPager)

        //signUp button click---------------------
        binding.onboardGetStartedBtn.setOnClickListener {
            val direction = OnBoardingFragmentDirections.actionOnBoardingFragmentToUserSelectFragment()
            findNavController().navigate(direction)
        }


        // skip textView click
        binding.onboardSkip.setOnClickListener{
            val direction = OnBoardingFragmentDirections.actionOnBoardingFragmentToUserSelectFragment()
            findNavController().navigate(direction)
        }


        //next button click
        binding.onboardNextBtn.setOnClickListener{
            position = binding.onboardViewPager.currentItem
            if (position < imageList.size) {
                position++
                binding.onboardViewPager.currentItem = position
            }
            if (position == imageList.size - 1) {
                stopBannerSlidShow()
                loadLastScreen()
            }
        }

        startBannerSlideShow()
    }

    //start onBoarding screen automatic
    private fun startBannerSlideShow() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                if (position >= imageList.size) {
                    position = 0
//                    stopBannerSlidShow()
                }
                binding.onboardViewPager.setCurrentItem(position++, true)
            }
        }, Constant.ONBOARD_DELAY_TIME, Constant.ONBOARD_PERIOD_TIME)

    }


    //stop onBoarding screen
    private fun stopBannerSlidShow() {
        timer.cancel()
    }

    private fun loadLastScreen() {
        binding.onboardNextBtn.visibility = View.INVISIBLE
        binding.onboardGetStartedBtn.visibility = View.VISIBLE
        binding.onboardGetStartedBtn.animation = btnAnimation
        binding.onboardSkip.visibility = View.GONE

    }

}