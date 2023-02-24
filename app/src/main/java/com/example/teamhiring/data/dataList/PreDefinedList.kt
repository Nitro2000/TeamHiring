package com.example.teamhiring.data.dataList

import androidx.fragment.app.Fragment
import com.example.teamhiring.R
import com.example.teamhiring.data.models.OnBoardData
import com.example.teamhiring.ui.subFragment.jobInfo.JobAppliedFragment
import com.example.teamhiring.ui.subFragment.jobInfo.JobSavedFragment
import com.example.teamhiring.ui.subFragment.jobInfo.JobViewedByFragment
import com.example.teamhiring.ui.subFragment.recInter.RecruiterManageJobFragment
import com.example.teamhiring.ui.subFragment.recInter.RecruiterSavedFragment
import com.example.teamhiring.ui.subFragment.recInter.RecruiterViewedByFragment

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

    val recInteractedFragmentList = listOf(
        RecruiterManageJobFragment(),
        RecruiterSavedFragment(),
        RecruiterViewedByFragment()
    )

    val recInteractFragmentNamesList = listOf<String>(
        "Posted Job",
        "Saved",
        "Viewed You"
    )

    val formattedExpList = listOf("Any", "Fresher", "1 - 2 yr", "2 - 5 yr", "5+ yr")
    val jobTypeList = listOf("Any", "Part time", "Full time", "Contractual")
    val empTimeType = listOf("Any", "Work from home", "Work from office", "Field work")
    val qualList = listOf("Any", "Below 10th", "10th-12th", "Graduation", "Post graduation")
    val engList = listOf("Any", "No english", "Little english", "Good english", "Fluent english")
    val ageList = listOf("Any", "18 - 25", "25 - 40", "40 - 50")

    val recChipGroupList = listOf("Java", "Kotlin", "Android sdk", "Android studio", "Retrofit", "UI/UX")

    val jobPostTempList = listOf("Android Engineer", "Rs 2 - 3LPA", "Work from home", "Full time")

}