package com.example.hotel.view.Fragments

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.DrawableUtils
import androidx.core.view.get
import com.applandeo.materialcalendarview.CalendarUtils
import com.applandeo.materialcalendarview.EventDay
import com.applandeo.materialcalendarview.utils.CalendarProperties
import com.example.hotel.AppUtilities
import com.example.hotel.R
import com.example.hotel.interfaces.TabSelected
import com.example.hotel.view.Activities.Reservation
import com.example.hotel.view.Activities.ReservationCalender
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_reservation_calender.*
import kotlinx.android.synthetic.main.activity_reservation_calender.view.*
import kotlinx.android.synthetic.main.fragment_check_in.*
import kotlinx.android.synthetic.main.fragment_check_out.*
import java.text.SimpleDateFormat
import java.time.Month
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList

class CheckOutFragment : Fragment(), TabSelected {

    val TAG = javaClass.simpleName
    lateinit var alertDialogOkButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_out, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Passes TabSelected interface so that it can be initialized
        (activity as ReservationCalender).setCallback(this)
    }

    fun showDialog(){

        // Inflate custom layout with Ok Button that is dimissed when user clicks it
        val layout = layoutInflater.inflate(R.layout.check_out_alert_dialog,null,false)
        alertDialogOkButton = layout.findViewById(R.id.checkout_btn)

        val alertDialog = AlertDialog.Builder(activity)
        val finalDialog = alertDialog.create()
        finalDialog.setView(layout)

        alertDialogOkButton.setOnClickListener {

            finalDialog.dismiss()
        }

        finalDialog.show()
    }

    // Implement method from TabSelected Interface that will be trigggered when listener is triggered
    override fun selectedTAb() {

        // Get Selected Tab
        val selectedTab = activity?.tabLayout?.selectedTabPosition
        Log.d(TAG,"Tab Seleted: $selectedTab")

        // Get Shared preferences
        var checkinDate = context?.getSharedPreferences("Dates", Context.MODE_PRIVATE)

        // Get Shared preferences values
       var calendarYearCheckIn = checkinDate?.getString("SELECTED_YEAR","null").toString()
       var calendarMonthCheckIn = checkinDate?.getString("SELECTED_MONTH", "null").toString()
       var calendarDayCheckIn = checkinDate!!.getString("SELECTED_DAY","null").toString()

        // If Tab 1 is selected (which in this case is the checkout tab)
        if (selectedTab == 1) {

            // And the preferences are not null
            if (calendarDayCheckIn != null && calendarMonthCheckIn  != null && calendarYearCheckIn != null){

                // Show dialog that will inform users that the item selected on the first tab
                // will show 3 dots below it
                showDialog()

                // place 3 dots on select date
                setCheckDate(calendarDayCheckIn!!,calendarMonthCheckIn!!,calendarYearCheckIn!!)
            }

        }

    }

    private fun setCheckDate(
        calendarDayCheckIn: String,
        calendarMonthCheckIn: String,
        calendarYearCheckIn: String
    ) {

        // Get Calendar info
        val setCalendarDate  = Calendar.getInstance()
        val year = calendarYearCheckIn.toInt()
        val month = calendarMonthCheckIn.toInt()
        val day = calendarDayCheckIn.toInt()
        setCalendarDate.set(year,month,day)

        // Set dots
        val eventCheckInConfirmation = ArrayList<EventDay>()
        eventCheckInConfirmation.add(EventDay(setCalendarDate,R.drawable.transparent_circle))

        calendarViewCheckout.setEvents(eventCheckInConfirmation)

        // Second Click for Checkout date
        secondClick(year,month,day)
    }

    private fun secondClick(year: Int, month: Int, day: Int) {

        //Sets second date
        calendarViewCheckout.setOnDayClickListener {

           checkoutDate(it, year, month, day)

        }
    }

    fun checkoutDate(it: EventDay, year: Int, month:Int, day:Int){

        // Get Calendar info for second click
        val calendarInfo = it?.calendar

        var calendarDay= calendarInfo?.get(Calendar.DAY_OF_MONTH)
        var calendarYear = calendarInfo?.get(Calendar.YEAR)
        var calendarMonth = calendarInfo?.get(Calendar.MONTH)

        // Changed formate for month and day
        var updatedMonth = AppUtilities.monthFormat(calendarMonth.toString())
        var updatedDay = AppUtilities.dateFormat(calendarDay.toString())

        // If the click for the checkout date is greater then the click for the checkin date
        if (calendarDay!! > day && calendarYear!! >= year && calendarMonth!! >= month){

            // Set the checkout date
            val checkoutDateSharedPrefs = activity?.getSharedPreferences("CheckoutDates",Context.MODE_PRIVATE)

            checkoutDateSharedPrefs?.edit()?.putString(AppUtilities.selectedCheckoutYear,calendarYear.toString())?.commit()
            checkoutDateSharedPrefs?.edit()?.putString(AppUtilities.selectedCheckoutMonth,updatedMonth)?.commit()
            checkoutDateSharedPrefs?.edit()?.putString(AppUtilities.selectedCheckoutDay,updatedDay)?.commit()

            // Then launch the activity to display current rooms
            val intent = Intent(activity, Reservation::class.java)
            startActivity(intent)
        }
    }

}
