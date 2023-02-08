package com.example.teamhiring.ui.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teamhiring.R
import com.example.teamhiring.databinding.FragmentHomeBinding


class HomeFragmentSeeker : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO Delete after merge
        binding.searchIcon.setOnClickListener {
            val direction = HomeFragmentSeekerDirections.actionHomeFragmentSeekerToRecruiterHomeFragment()
            findNavController().navigate(direction)
        }
    }



}