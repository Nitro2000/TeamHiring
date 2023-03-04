package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.data.dataList.ChatCompanyDataList
import com.example.teamhiring.data.models.ChatCompanyData
import com.example.teamhiring.databinding.FragmentChatCompanyBinding
import com.example.teamhiring.presentation.adapters.ChatCompanyDataAdapter

class ChatCompanyFragment : Fragment() {
    private lateinit var mActivity: FragmentActivity
    private lateinit var mContext: Context

    private lateinit var binding: FragmentChatCompanyBinding

    private lateinit var chatCompList: List<ChatCompanyData>
    private lateinit var chatCompAdapter: ChatCompanyDataAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mActivity = requireActivity()
        mContext = requireContext()

        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.VISIBLE)
        binding = FragmentChatCompanyBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chatCompRecView.layoutManager = LinearLayoutManager(mContext)

        chatCompList = ChatCompanyDataList.chatCompanyList

        chatCompAdapter = ChatCompanyDataAdapter(chatCompList)

        binding.chatCompRecView.adapter = chatCompAdapter


    }
}