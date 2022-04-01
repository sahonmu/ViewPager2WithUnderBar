package com.burger.palchil.viewpage01

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val pageCount = 10

    override fun getItemCount(): Int {
        return pageCount
    }

    override fun createFragment(position: Int): Fragment {
        return PageFragment(position)
    }

}