package com.example.teamhiring.ui.mainFragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.HelperFunction
import com.example.teamhiring.R
import com.example.teamhiring.databinding.FragmentCareerPreferencesBinding
import com.example.teamhiring.databinding.FragmentOtpBinding
import com.example.teamhiring.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireContext()
        mActivity = requireActivity()
        HelperFunction.bottomNavBarVisibility(mActivity, View.VISIBLE)
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileCareerPref.setOnClickListener {
            val directions = ProfileFragmentDirections.actionProfileFragmentToCareerPreferencesFragment()
            findNavController().navigate(directions)
        }
    }
}