package com.example.hotel.view.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.hotel.AppUtilities
import com.example.hotel.R
import kotlinx.android.synthetic.main.activity_check_in.*

class Reservation : AppCompatActivity() {

    lateinit var childSpinner:Array<String>
    var adultPersonCounter = 1
    var childPersonCounter = 0
    lateinit var searchQuery: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        // Set up Toolbar
        AppUtilities.setupToolbar(this,check_in_toolbar,"Reservation")

        // Set up Spinner
        childSpinner = resources.getStringArray(R.array.age_of_child_spinner)
       setUpSpinners()

        // Get intent for Search Query
        searchQuery = intent.getStringExtra("SEARCH_QUERY") ?: "null"

        // Set up Cardview listener to Go to ReservationCalander when clicked
        cardView_checkin.setOnClickListener {

            val intent = Intent(this, ReservationCalender::class.java)
            startActivity(intent)
        }

        // Click listener to increment number of adults
        btn_add_adult.setOnClickListener{

            if (adultPersonCounter < 8){
                adultPersonCounter++
            }

            numberOfAdultsPerRoom(adultPersonCounter)
        }

        // Click listener to decrement number of adults
        btn_remove_adult.setOnClickListener {

             if(adultPersonCounter > 1){
                adultPersonCounter--
            }

            numberOfAdultsPerRoom(adultPersonCounter)
        }


        // Increment children
        btn_add_children.setOnClickListener {

            if (childPersonCounter < 3){
                childPersonCounter++
            }

            numberOfChildrenPerRoom(childPersonCounter)
        }

        // Decrement children
        btn_remove_children.setOnClickListener {

            if(childPersonCounter > 0){
                childPersonCounter--
            }
            numberOfChildrenPerRoom(childPersonCounter)
        }

        // Informs customer that certain functions are not available during demo due to api restrictions
        textView20.setOnClickListener {

            Toast.makeText(this,"No functionality for Demo",Toast.LENGTH_LONG).show()
        }

        // Launches Hotels Deals Activity and pass it search query and adultPersonCounter
        btn_show_deals.setOnClickListener {

            val intent = Intent(this,HotelDeals::class.java)
            intent.putExtra(AppUtilities.SEARCH_DATA,searchQuery)
            intent.putExtra(AppUtilities.ADULT_COUNT,adultPersonCounter.toString())
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        // Sets date for check in
        reservationCheckInDate()
        reservationCheckOutDate()
    }

    private fun reservationCheckOutDate() {

        val setCheckOutDate = getSharedPreferences("CheckoutDates",Context.MODE_PRIVATE)

        // Gets values for Checkout Dates
        val y = setCheckOutDate.getString("SELECTED_CHECKOUT_YEAR","null")
        val m = setCheckOutDate.getString("SELECTED_CHECKOUT_MONTH", "null")
        val d = setCheckOutDate.getString("SELECTED_CHECKOUT_DAY", "null")

        if (y != null && m != null && d != null) {

            // Changes month to Abbreviations
            val abbreviatedMonth = AppUtilities.monthAbbrevations(m)

            // Sets Date for UI
            checkout_day.text = "$abbreviatedMonth $d"
            checkout_year.text = y.toString()
        }

    }

    private fun reservationCheckInDate() {

        val setCheckInDate = getSharedPreferences("Dates", Context.MODE_PRIVATE)

        //Get String from Shared prefs
        val y = setCheckInDate.getString("SELECTED_YEAR","null")
        val m = setCheckInDate.getString("SELECTED_MONTH","null")
        val d = setCheckInDate.getString("SELECTED_DAY", "null")

        if (y != null && m != null && d != null){

            // Changes Month to abbrevitaions
            val abbreviatedMonth = AppUtilities.monthAbbrevations(m)

            // sets date on UI
            checkin_day.text = "$abbreviatedMonth $d"
            checkin_year.text = y.toString()
        }

    }

    // Sets up spinner data
    private fun setUpSpinners() {
        ArrayAdapter(this,android.R.layout.simple_spinner_item,
            childSpinner).apply {

            spinner_child_1.adapter = this

            spinner_child_1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }

            }
        }


        // Sets up spinner object on UI
        ArrayAdapter(this,android.R.layout.simple_spinner_item,
            childSpinner).apply {

            spinner_child_2.adapter = this

            spinner_child_2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }

            }
        }

        // Sets up spinner object on UI
        ArrayAdapter(this,android.R.layout.simple_spinner_item,
            childSpinner).apply {

            spinner_child_3.adapter = this

            spinner_child_3.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }

            }
        }

    }

    // Set Items Visible or Gone
    private fun numberOfChildrenPerRoom(childPersonCounter: Int){

        child_text_count.text = childPersonCounter.toString()

        btn_remove_children.isActivated = childPersonCounter>0

        when(childPersonCounter){

            0->{
                view_three.visibility = View.GONE
                text_child_1.visibility = View.GONE
                spinner_child_1.visibility = View.GONE
                child_text_count_1.visibility = View.GONE
            }
            1 -> {
                view_three.visibility = View.VISIBLE
                text_child_1.visibility = View.VISIBLE
                spinner_child_1.visibility = View.VISIBLE
                child_text_count_1.visibility = View.VISIBLE

                view_four.visibility = View.GONE
                text_child_2.visibility = View.GONE
                spinner_child_2.visibility = View.GONE
                child_text_count_2.visibility = View.GONE
            }
            2 ->{

                view_four.visibility = View.VISIBLE
                text_child_2.visibility = View.VISIBLE
                spinner_child_2.visibility = View.VISIBLE
                child_text_count_2.visibility = View.VISIBLE

                view_five.visibility = View.GONE
                text_child_3.visibility = View.GONE
                spinner_child_3.visibility = View.GONE
                child_text_count_3.visibility = View.GONE
            }
            3 ->{
                view_five.visibility = View.VISIBLE
                text_child_3.visibility = View.VISIBLE
                spinner_child_3.visibility = View.VISIBLE
                child_text_count_3.visibility = View.VISIBLE
            }
        }

    }

    // Set data for number of adults per room
    private fun numberOfAdultsPerRoom(adultPersonCounter: Int) {

        adult_text_count.text = adultPersonCounter.toString()

        btn_remove_adult.isActivated = adultPersonCounter> 1
    }


    // When Edit button is selected user will be send to the HomeScreen
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {

            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
