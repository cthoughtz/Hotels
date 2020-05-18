package com.example.hotel.view.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.hotel.view.Fragments.HotelDealsAllFragment
import com.example.hotel.view.Fragments.HotelDealsFavoriteFragment

class HotelDealsPager(fm: FragmentManager, tabCount: Int): FragmentStatePagerAdapter(fm,tabCount) {

    val tabCountTotal = tabCount
    val hotelDealsAll = HotelDealsAllFragment()
    val hotelDealFavorites = HotelDealsFavoriteFragment()

    override fun getItem(position: Int) = when(position){
        // When potision 1 is selected hotelDealFavorites will be displayed otherwise hotelDealsAll
        // will be displayed
        0-> hotelDealsAll
        1 -> hotelDealFavorites
        else -> hotelDealsAll
    }

    override fun getCount() = tabCountTotal


}