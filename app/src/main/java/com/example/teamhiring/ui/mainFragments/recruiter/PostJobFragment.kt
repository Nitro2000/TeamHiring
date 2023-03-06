package com.example.teamhiring.ui.mainFragments.recruiter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.R
import com.example.teamhiring.data.constants.enums.PostJobProgressEnum
import com.example.teamhiring.databinding.FragmentPostJobBinding
import com.example.teamhiring.ui.subFragment.postJob.PostJobFirstFragmentDirections
import com.example.teamhiring.ui.subFragment.postJob.PostJobSecFragmentDirections

class PostJobFragment : Fragment() {

    private lateinit var binding: FragmentPostJobBinding
    private lateinit var mContext: Context
    private lateinit var navController: NavController
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentPostJobBinding.inflate(inflater, container, false)
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.postJobNavFragment) as NavHostFragment
        navController = navHostFragment.navController
        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.GONE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.postNextTxt.setOnClickListener {
            val currFragment = navController.currentDestination?.id
            val direction = when(currFragment) {
                R.id.postJobFirstFragment -> PostJobFirstFragmentDirections.actionPostJobFirstFragmentToPostJobSecFragment()
                else -> {
                    binding.postJobBtn.animation = AnimationUtils.loadAnimation(mContext, R.anim.button_animation)
                    PostJobSecFragmentDirections.actionPostJobSecFragmentToPostJobThirdFragment()

                }
            }
            navController.navigate(direction)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.postJobFirstFragment -> {
                    setBtnVisibility()
                    setProgBar(PostJobProgressEnum.START.value)
                }
                R.id.postJobSecFragment -> {
                    setBtnVisibility()
                    setProgBar(PostJobProgressEnum.HALF_COMPLETED.value, R.drawable.icon_post_checkpoint)
                }
                else -> {
                    setBtnVisibility(View.INVISIBLE, View.VISIBLE)
                    setProgBar(PostJobProgressEnum.COMPLETED.value, R.drawable.icon_post_checkpoint, R.drawable.icon_post_checkpoint)
                }
            }
        }
    }

    private fun setBtnVisibility(nextVisible: Int = View.VISIBLE, postVisible: Int = View.INVISIBLE) {
        binding.postNextTxt.visibility = nextVisible
        binding.postJobBtn.visibility = postVisible
    }

    private fun setProgBar(lenCovered: Int, secImg: Int = R.drawable.ic_post_uncheck, thirdImg: Int = R.drawable.ic_post_uncheck) {
        binding.apply {
            postJobProgress.progress = lenCovered
            postProgSecImg.setImageResource(secImg)
            postProgThirdImg.setImageResource(thirdImg)
        }
    }


}