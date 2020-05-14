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
import java.lang.NumberFormatException

object AppUtilities {

    val SEARCH_DATA ="SEARCH_QUERY"
    val ADULT_COUNT ="ADULT_COUNT"
    val selectedYear = "SELECTED_YEAR"
    val selectedMonth = "SELECTED_MONTH"
    val selectedDay = "SELECTED_DAY"
    val selectedCheckoutYear = "SELECTED_CHECKOUT_YEAR"
    val selectedCheckoutMonth = "SELECTED_CHECKOUT_MONTH"
    val selectedCheckoutDay = "SELECTED_CHECKOUT_DAY"

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

    fun monthAbbrevations(month:String):String{

         val updatedMonth =when(month){

             "00" -> "Jan"
             "01" -> "Feb"
             "02" -> "Mar"
             "03" -> "Apr"
             "04" -> "May"
             "05" -> "Jun"
             "06" -> "Jul"
             "07" -> "Aug"
             "08" -> "Sep"
             "09" -> "Oct"
             "10" -> "Nov"
             "11" -> "Dec"
             else -> "N/A"
        }

        return updatedMonth
    }


    fun monthFormat(month: String): String {

        val updatedMonth = if (month.length == 1) {
            "0$month"
        } else{
            "$month"
        }

       return updatedMonth
    }

    fun dateFormat(calendarDay: String): String {

        val updatedDay = if (calendarDay.length == 1) {
            "0$calendarDay"
        } else {
            "$calendarDay"
        }

        return updatedDay
    }

    fun percentCalculator(price: String):Int {
        if(price == "null"){
            return 0
        } else {
            return (10 * price.toInt()) / 100
        }
    }

    fun savedMoney(oldPrice: Int, price:Int):Int{

       return ((oldPrice - price)/((price + oldPrice)/2))*100
    }

    fun ratingLevel(number: Double): String {

     return when (number) {
            in 9.4..9.9 -> {
                "Exceptional"
            }
            in 9.0..9.3 -> {
                "Superb"
            }
            in 8.6..8.9 ->{
                "Very Good"
            }
            in 8.0..8.5 ->{
                "Good"
            }
            in 6.0..7.9 ->{
            "Nice"
            }
            in 0.0..5.9 ->{
                "Awesome"
            }
            else ->{
                "No Rating"
            }

        }
    }
}