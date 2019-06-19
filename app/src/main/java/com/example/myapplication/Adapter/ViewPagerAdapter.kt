package com.example.myapplication.Adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.myapplication.Fragment.ExchangeFragment
import com.example.myapplication.Fragment.SnapingFragment

class ViewPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when(position) {
            0 -> { return SnapingFragment() }
            1 -> { return ExchangeFragment() }
            2 -> { return SnapingFragment() }
            else -> { return null }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> { return "Endless Tower" }
            1 -> { return "Exchange" }
            2 -> { return "Snapping" }
            else -> { return ""}
        }
    }
}