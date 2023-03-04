package com.example.teamhiring.ui.subFragment.postJob

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.R
import com.example.teamhiring.databinding.FragmentHomeSeekerBinding
import com.example.teamhiring.databinding.FragmentPostJobFirstBinding

class PostJobFirstFragment : Fragment() {


    private lateinit var binding: FragmentPostJobFirstBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        // Inflate the layout for this fragment
        binding = FragmentPostJobFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.text.setOnClickListener {
//            val directions = PostJobFirstFragmentDirections.actionPostJobFirstFragmentToPostJobSecFragment()
//            findNavController().navigate(directions)
//        }
    }


}