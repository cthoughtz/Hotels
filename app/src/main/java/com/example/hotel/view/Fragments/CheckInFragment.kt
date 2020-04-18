package com.example.hotel.view.Fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.applandeo.materialcalendarview.CalendarView
import com.example.hotel.R
import kotlinx.android.synthetic.main.fragment_check_in.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class CheckInFragment : Fragment() {

    val TAG = javaClass.simpleName
    val selectedYear = "SELECTED_YEAR"
    val selectedMonth = "SELECTED_MONTH"
    val selectedDay = "SELECTED_DAY"

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


        val sharedPrefs = activity?.getSharedPreferences("Dates", Context.MODE_PRIVATE)
        val selectedDate = calendarView.selectedDates




        calendarView.setOnDayClickListener {

            // get the updated day of the month after click takes place
            val currentDayOfMonth = it.calendar
            var calendarDay= currentDayOfMonth.get(Calendar.DAY_OF_MONTH)
            var year = currentDayOfMonth.get(Calendar.YEAR)
            var month = currentDayOfMonth.get(Calendar.MONTH)

            sharedPrefs?.edit()?.putString(selectedYear,year.toString())?.commit()
            sharedPrefs?.edit()?.putString(selectedMonth,month.toString())?.commit()
            sharedPrefs?.edit()?.putString(selectedDay,calendarDay.toString())?.commit()


            //Todo add to shared preference and set date selected in checkout and UI.
        }

    }
}

