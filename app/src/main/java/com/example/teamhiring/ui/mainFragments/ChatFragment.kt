package com.example.teamhiring.ui.mainFragments

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.R
import com.example.teamhiring.data.dataList.ChatDataList
import com.example.teamhiring.data.models.ChatData
import com.example.teamhiring.databinding.FragmentChatBinding
import com.example.teamhiring.presentation.adapters.ChatAdapter


@Suppress("DEPRECATION")
class ChatFragment : Fragment() {

    private lateinit var mActivity: FragmentActivity
    private lateinit var mContext: Context

    private lateinit var binding: FragmentChatBinding
    var isAttachShow: Boolean = false
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

        setHasOptionsMenu(true)

        // this creates a vertical layout Manager
        binding.chatRecView.layoutManager = LinearLayoutManager(mContext)

        chatList = ChatDataList.chatList

        binding.chatAttachImg.setOnClickListener {
            if (isAttachShow){
                isAttachShow = false
                binding.attachLinearLay.visibility = View.GONE

            }
            else{
                isAttachShow = true
                binding.attachLinearLay.visibility = View.VISIBLE
            }

        }
        // This will pass the ArrayList to our Adapter
        chatAdapter = ChatAdapter(chatList)

        // Setting the Adapter with the recyclerview
        binding.chatRecView.adapter = chatAdapter

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.chat_menu, menu)


    }


}