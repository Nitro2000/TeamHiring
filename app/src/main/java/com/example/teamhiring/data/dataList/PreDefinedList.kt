package com.example.teamhiring.data.dataList

import androidx.fragment.app.Fragment
import com.example.teamhiring.R
import com.example.teamhiring.data.models.OnBoardData
import com.example.teamhiring.ui.subFragment.jobInfo.JobAppliedFragment
import com.example.teamhiring.ui.subFragment.jobInfo.JobSavedFragment
import com.example.teamhiring.ui.subFragment.jobInfo.JobViewedByFragment

object PreDefinedList {
    val imageList: List<OnBoardData> = listOf(
        OnBoardData(
            "Apply in Dream Company",
            "Search and apply in dream company and grow",
            R.drawable.image_onboard_first
        ),
        OnBoardData(
            "Chat with Founders",
            "Search and apply in dream company and grow",
            R.drawable.image_onboard_second
        ),
        OnBoardData(
            "Get Hired",
            "Search and apply in dream company and grow",
            R.drawable.image_onboard_third
        ),
    )

    val jobFragmentList = listOf<Fragment>(
        JobAppliedFragment(),
        JobSavedFragment(),
        JobViewedByFragment()
    )

    val jobFragmentNamesList = listOf<String>(
        "Applied",
        "Saved",
        "Viewed You"
    )

    val recChipGroupList = listOf("Java", "Kotlin", "Android sdk", "Android studio", "Retrofit", "UI/UX")

    val jobPostTempList = listOf("Android Engineer", "Rs 2 - 3LPA", "Work from home", "Full time")

}