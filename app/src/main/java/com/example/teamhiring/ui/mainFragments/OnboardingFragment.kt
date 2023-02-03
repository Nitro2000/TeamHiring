package com.example.teamhiring.ui.mainFragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.teamhiring.R
import com.example.teamhiring.databinding.FragmentOnboardingBinding
import com.example.teamhiring.presentation.adapters.OnboardingAdpater
import com.google.android.material.tabs.TabLayout
import java.util.*


class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    private lateinit var btnAnimation: Animation

    lateinit var viewPagerAdapter: OnboardingAdpater
    lateinit var imageList: List<Int>



    var timer: Timer? = null
    var position = 0

    private val BANNER_DELAY_TIME: Long = 2000
    private val BANNER_PERIOD_TIME: Long = 2000


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Adding image in list-----------------
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.image_onboard_first
        imageList = imageList + R.drawable.image_onboard_second
        imageList = imageList + R.drawable.image_onboard_third

        viewPagerAdapter = OnboardingAdpater(mContext, imageList)
        binding.onboardViewPager.adapter = viewPagerAdapter
        binding.onboardTabLayout.setupWithViewPager(binding.onboardViewPager)

        btnAnimation = AnimationUtils.loadAnimation(mContext,R.anim.button_animation);

        //view pager listener--------------------
        var viewPagerPageChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }
            override fun onPageScrolled(position: Int,positionOffset: Float,positionOffsetPixels: Int) {

            }
            override fun onPageSelected(i: Int) {
                position = i

            }
        }
        binding.onboardViewPager.addOnPageChangeListener(viewPagerPageChangeListener)


        //Tab Indicator-------------------------
        binding.onboardTabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (position == imageList.size) {
                }
                else {
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })


        //signUp button click---------------------
        binding.onboardGetStartedBtn.setOnClickListener(View.OnClickListener {
            val direction = OnboardingFragmentDirections.actionOnBoardingFragmentToLoginFragment()
            findNavController().navigate(direction)
        })


        // skip textView click
        binding.onboardSkip.setOnClickListener(View.OnClickListener {
            val direction = OnboardingFragmentDirections.actionOnBoardingFragmentToLoginFragment()
            findNavController().navigate(direction)
        })


        //next button click
        binding.onboardNextBtn.setOnClickListener(View.OnClickListener {
            position = binding.onboardViewPager.getCurrentItem()
            if (position < imageList.size) {
                position++
                binding.onboardViewPager.setCurrentItem(position)
            }
            if (position === imageList.size - 1) {
                loadLastScreen()
            }
        })

        startBannerSlideShow()
    }



    //start onBoarding screen automatic
    private fun startBannerSlideShow() {
        val handler = Handler()
        val update = Runnable {
            if (position >= imageList.size) {
                position = 0
            }
            binding.onboardViewPager.setCurrentItem(position++, true)
        }
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, BANNER_DELAY_TIME, BANNER_PERIOD_TIME)

    }


    //stop onBoarding screen
    private fun stopBannerSlidShow() {
        timer!!.cancel()
    }

    private fun loadLastScreen() {
        binding.onboardNextBtn.setVisibility(View.INVISIBLE)
        binding.onboardGetStartedBtn.setVisibility(View.VISIBLE)
        binding.onboardGetStartedBtn.setAnimation(btnAnimation);
        binding.onboardSkip.setVisibility(View.GONE)
        binding.onboardTabLayout.setVisibility(View.INVISIBLE)
    }

}