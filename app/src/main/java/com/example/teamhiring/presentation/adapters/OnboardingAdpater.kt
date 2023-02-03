package com.example.teamhiring.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.teamhiring.R
import java.util.*

class OnboardingAdpater (val context: Context, val imageList: List<Int>) : PagerAdapter(){


    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


        val itemView: View = mLayoutInflater.inflate(R.layout.item_onboarding_screen, container, false)


        val imageView: ImageView = itemView.findViewById<View>(R.id.imageView) as ImageView


        imageView.setImageResource(imageList.get(position))

        Objects.requireNonNull(container).addView(itemView)


        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)

    }
}

