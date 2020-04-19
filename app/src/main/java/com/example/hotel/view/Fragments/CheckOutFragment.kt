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
    var calendarYearCheckIn: String? = null
    var calendarMonthCheckIn: String? = null
    var  calendarDayCheckIn: String? = null
    lateinit var alertDialogOkButton: Button

    val selectedCheckoutYear = "SELECTED_CHECKOUT_YEAR"
    val selectedCheckoutMonth = "SELECTED_CHECKOUT_MONTH"
    val selectedCheckoutDay = "SELECTED_CHECKOUT_DAY"


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

        val checkinDate = context?.getSharedPreferences("Dates", Context.MODE_PRIVATE)

        calendarYearCheckIn = checkinDate?.getString("SELECTED_YEAR","null")
        calendarMonthCheckIn = checkinDate?.getString("SELECTED_MONTH", "null")
        calendarDayCheckIn = checkinDate?.getString("SELECTED_DAY","null")

    }


    fun showDialog(){

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

    override fun selectedTAb() {


        val selectedTab = activity?.tabLayout?.selectedTabPosition
        Log.d(TAG,"Tab Seleted: $selectedTab")

        if (selectedTab == 1) {


            if (calendarDayCheckIn != null && calendarMonthCheckIn  != null && calendarYearCheckIn != null){

                showDialog()
                setCheckDate(calendarDayCheckIn!!,calendarMonthCheckIn!!,calendarYearCheckIn!!)
            }

        }

    }

    private fun setCheckDate(
        calendarDayCheckIn: String,
        calendarMonthCheckIn: String,
        calendarYearCheckIn: String
    ) {

        val setCalendarDate  = Calendar.getInstance()
        val year = calendarYearCheckIn.toInt()
        val month = calendarMonthCheckIn.toInt()
        val day = calendarDayCheckIn.toInt()
        setCalendarDate.set(year,month,day)

        val eventCheckInConfirmation = ArrayList<EventDay>()
        eventCheckInConfirmation.add(EventDay(setCalendarDate,R.drawable.transparent_circle))

        calendarViewCheckout.setEvents(eventCheckInConfirmation)

        secondClick(year,month,day)
    }

    private fun secondClick(year: Int, month: Int, day: Int) {

        calendarViewCheckout.setOnDayClickListener {

           checkoutDate(it, year, month, day)

        }
    }

    fun checkoutDate(it: EventDay, year: Int, month:Int, day:Int){
        val calendarInfo = it?.calendar

        var calendarDay= calendarInfo?.get(Calendar.DAY_OF_MONTH)
        var calendarYear = calendarInfo?.get(Calendar.YEAR)
        var calendarMonth = calendarInfo?.get(Calendar.MONTH)

        if (calendarDay!! > day && calendarYear!! >= year && calendarMonth!! >= month){

            val checkoutDateSharedPrefs = activity?.getSharedPreferences("CheckoutDates",Context.MODE_PRIVATE)

            checkoutDateSharedPrefs?.edit()?.putString(selectedCheckoutYear,calendarYear.toString())?.commit()
            checkoutDateSharedPrefs?.edit()?.putString(selectedCheckoutMonth,calendarMonth.toString())?.commit()
            checkoutDateSharedPrefs?.edit()?.putString(selectedCheckoutDay,calendarDay.toString())?.commit()

            val intent = Intent(activity, Reservation::class.java)
            startActivity(intent)

        }
    }

}
