package com.uu.attendance.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.uu.attendance.ui.fragment.SuperviseCardFragment
import com.uu.attendance.ui.fragment.SuperviseListFragment

class ViewPagerSuperviseDetailAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(
    fragmentActivity
) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SuperviseListFragment()
            else -> SuperviseCardFragment()
        }
    }

}