package com.example.hotel.view.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.hotel.view.Fragments.CheckInFragment
import com.example.hotel.view.Fragments.CheckOutFragment

class Pager(fm: FragmentManager, tabCount: Int): FragmentStatePagerAdapter(fm ,tabCount) {

    val tabCountTotal = tabCount
    val checkIn = CheckInFragment()
    val checkout = CheckOutFragment()


    override fun getItem(position: Int): Fragment {

        // When position is 1 then checkout fragment is displayed else checkin is displayed
        when (position) {
            0 -> {
                return checkIn
            }
            1-> {
                return checkout
            }
        }
        return checkIn
    }

    override fun getCount() = tabCountTotal
}