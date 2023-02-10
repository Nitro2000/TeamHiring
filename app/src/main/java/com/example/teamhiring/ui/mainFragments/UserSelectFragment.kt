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
import com.example.teamhiring.databinding.FragmentUserSelectBinding

class UserSelectFragment : Fragment() {

    private lateinit var binding: FragmentUserSelectBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContext = requireContext()
        mActivity = requireActivity()
        HelperFunction.bottomNavBarVisibility(mActivity, View.GONE)
        // Inflate the layout for this fragment
        binding =  FragmentUserSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.userSelectSeekerBtn.setOnClickListener(View.OnClickListener {
            val direction = UserSelectFragmentDirections.actionUserSelectFragmentToSignInFragment()
            findNavController().navigate(direction)
        })
    }
}