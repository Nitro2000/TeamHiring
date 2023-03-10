package com.example.teamhiring

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import android.text.TextUtils
import android.util.Patterns
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.chip.Chip

object CommonUiFunctions {


    fun changeStatusBarColor(activity: FragmentActivity, color: Int) {
        try {
            activity.window.let {
//                it.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//                it.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                it.statusBarColor = ContextCompat.getColor(activity, color)
            }
//            activity.window.decorView.systemUiVisibility = View.VISIBLE
        } catch (e: Exception){}
    }

    fun startShimmer(shimmer: ShimmerFrameLayout, recView: RecyclerView) {
        recView.visibility = View.GONE
        shimmer.startShimmer()
        shimmer.visibility = View.VISIBLE
    }

    fun stopShimmer(shimmer: ShimmerFrameLayout, recView: RecyclerView) {
        shimmer.stopShimmer()
        shimmer.visibility = View.GONE
        recView.visibility = View.VISIBLE
    }

    fun bottomNavBarVisibility(activity: FragmentActivity, visibility: Int) {
        try {
            (activity as MainActivity).bottomNavBarVisibility(visibility)
        } catch (e: Exception) {}
    }
    fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun dpToFloat(context: Context, value: Int): Float {
        return value * context.resources.displayMetrics.density
    }

    fun createChip(textValue: String, color: Int, context: Context): Chip {
        val chip = Chip(context)
        chip.apply {
            text = textValue
            chipBackgroundColor = getColorStateList(context, color)
            chipStrokeWidth = dpToFloat(context, 1)
            setChipStrokeColorResource(R.color.sub_views)
        }
        return chip;
    }

    private val stateList = arrayOf(
        intArrayOf(-android.R.attr.state_checked)
    )

    private fun getColorStateList(context: Context, color: Int): ColorStateList {
        val colorList = intArrayOf(
            ContextCompat.getColor(context, color),
        )
        return ColorStateList(stateList, colorList)
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