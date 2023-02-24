package com.example.teamhiring

import android.text.TextUtils
import android.util.Patterns
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

object HelperFunction {

    fun bottomNavBarVisibility(activity: FragmentActivity, visibility: Int) {
        try {
            (activity as MainActivity).bottomNavBarVisibility(visibility)
        } catch (e: Exception) {}
    }
    fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

//    fun changeStatusBarColor(activity: FragmentActivity, color: Int) {
//        try {
//            activity.window.let {
////                it.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
////                it.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//                it.statusBarColor = ContextCompat.getColor(activity, color)
//            }
////            activity.window.decorView.systemUiVisibility = View.VISIBLE
//        } catch (e: Exception){}
//    }


//    fun selectBottomNavMenus(activity: FragmentActivity, tabIndex: Int) {
//        try {
//            (activity as MainActivity).selectInteractionMenu(tabIndex)
//        } catch (e: Exception) {}
//    }


}