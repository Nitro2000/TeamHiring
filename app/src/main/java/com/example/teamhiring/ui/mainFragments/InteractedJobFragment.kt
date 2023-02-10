package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.teamhiring.data.dataList.PreDefinedList
import com.example.teamhiring.databinding.FragmentInteractedJobBinding
import com.example.teamhiring.presentation.adapters.JobFragInfoAdapter
import com.google.android.material.tabs.TabLayoutMediator


class InteractedJobFragment : Fragment() {


    private lateinit var binding: FragmentInteractedJobBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: FragmentActivity
    private lateinit var adapter: JobFragInfoAdapter
//    private var tabIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mContext = requireContext()
        mActivity = requireActivity()
        binding = FragmentInteractedJobBinding.inflate(inflater, container, false)
        adapter = JobFragInfoAdapter(PreDefinedList.jobFragmentList, this.childFragmentManager, this.lifecycle)

        binding.jobViewPager.adapter = adapter
        TabLayoutMediator(binding.tablayout, binding.jobViewPager) {tab, pos ->
            tab.text = PreDefinedList.jobFragmentNamesList[pos]
        }.attach()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setting tab and viewpager move to fun if view created code lengthens

//
////        binding.tablayout.getTabAt(tabIndex)?.select()
//        binding.interViewPager.
//        binding.tablayout.setBackgroundResource(R.drawable.bg_user_text_border);
//        Handler(Looper.getMainLooper()).postDelayed({
//            binding.jobViewPager.setCurrentItem(tabIndex, true)
//        }, 80)
    }


}