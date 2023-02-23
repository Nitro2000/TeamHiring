package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.data.dataList.ChatDataList
import com.example.teamhiring.data.models.ChatData
import com.example.teamhiring.databinding.FragmentChatBinding
import com.example.teamhiring.presentation.adapters.ChatAdapter


class ChatFragment : Fragment() {

    private lateinit var mActivity: FragmentActivity
    private lateinit var mContext: Context

    private lateinit var binding: FragmentChatBinding

    private lateinit var chatAdapter: ChatAdapter
    private lateinit var chatList: List<ChatData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mActivity = requireActivity()
        mContext = requireContext()

        CommonUiFunctions.bottomNavBarVisibility(mActivity, View.GONE)
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // this creates a vertical layout Manager
        binding.chatRecView.layoutManager = LinearLayoutManager(mContext)

        chatList = ChatDataList.chatList

        // This will pass the ArrayList to our Adapter
        chatAdapter = ChatAdapter(chatList)

        // Setting the Adapter with the recyclerview
        binding.chatRecView.adapter = chatAdapter

    }
}