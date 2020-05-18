package com.example.hotel.view.Fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.applandeo.materialcalendarview.EventDay
import com.example.hotel.AppUtilities
import com.example.hotel.R
import kotlinx.android.synthetic.main.fragment_check_in.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class CheckInFragment : Fragment() {

    val TAG = javaClass.simpleName
    lateinit var sharedPrefs: SharedPreferences

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       Log.d(TAG,"onViewCreated Method Called")
    }

    override fun onStart() {
        super.onStart()

        //Get Shared preferneces for Dates
        sharedPrefs = activity!!.getSharedPreferences("Dates", Context.MODE_PRIVATE)

        // Listens to Date clicked on calendar
        calendarView.setOnDayClickListener {

            selectedDate(it,sharedPrefs)
        }

    }

    private fun selectedDate(it: EventDay?, sharedPrefs: SharedPreferences?) {

        // Get Calender dates that were selected
        val calendarInfo = it?.calendar
        var calendarDay= calendarInfo?.get(Calendar.DAY_OF_MONTH)
        var year = calendarInfo?.get(Calendar.YEAR)
        var month = calendarInfo?.get(Calendar.MONTH)

        // Changes format of dates
        var updatedMonth = AppUtilities.monthFormat(month.toString())
        var updatedDay = AppUtilities.dateFormat(calendarDay.toString())

        // Saves values in shared preferences
        sharedPrefs?.edit()?.putString(AppUtilities.selectedYear,year.toString())?.commit()
        sharedPrefs?.edit()?.putString(AppUtilities.selectedMonth,updatedMonth)?.commit()
        sharedPrefs?.edit()?.putString(AppUtilities.selectedDay,updatedDay)?.commit()
    }
}

