package com.example.hotel.view.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotel.R
import com.example.hotel.interfaces.TabSelected
import com.example.hotel.view.Activities.ReservationCalender
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_reservation_calender.*
import kotlinx.android.synthetic.main.activity_reservation_calender.view.*

class CheckOutFragment : Fragment(), TabSelected {

    val TAG = javaClass.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_out, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as ReservationCalender).setCallback(this)


    }


    override fun selectedTAb() {


        val selectedTab = activity?.tabLayout?.selectedTabPosition
        Log.d(TAG,"Tab Seleted: $selectedTab")

    }

}
