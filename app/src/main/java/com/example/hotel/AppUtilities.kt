package com.example.hotel

import android.app.Activity
import android.content.Context
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_check_in.*

object AppUtilities {

    val SEARCH_DATA ="SEARCH_QUERY"

    fun hideSoftKeyBoard(input: EditText, context: Context) {

        val inputManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(input.windowToken, 0)
    }

    fun setupToolbar(appCompat: AppCompatActivity, toolbar: Toolbar, title: String) {
        //setup toolbar

        appCompat.setSupportActionBar(toolbar)
        val checkInToolbar = appCompat.supportActionBar
        checkInToolbar?.title = title
        checkInToolbar?.setDisplayHomeAsUpEnabled(true)
    }

    fun getMonth(month: String): String {

        val monthNumber = month.toInt()

        return when (monthNumber) {

            0 -> "Jan"
            1 -> "Feb"
            2 -> "Mar"
            3 -> "Apr"
            4 -> "May"
            5 -> "Jun"
            6 -> "Jul"
            7 -> "Aug"
            8 -> "Sep"
            9 -> "Oct"
            10 -> "Nov"
            11 -> "Dec"
            else -> "No Value"
        }


    }
}