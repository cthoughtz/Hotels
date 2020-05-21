package com.example.hotel.view.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hotel.AppUtilities
import com.example.hotel.R
import com.example.hotel.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.activity_hotel_details.*

class HotelDetails : AppCompatActivity() {

    lateinit var viewModel: AppViewModel
    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_details)

        // Get intent for destination Id
        val itemId = intent.getStringExtra("itemId")

        // Get parameters for api call 
        val checkoutPrefs = getSharedPreferences("CheckoutDates", Context.MODE_PRIVATE)
        val checkoutAll = checkoutPrefs.all
        val checkout = "${checkoutAll.get("SELECTED_CHECKOUT_YEAR")}-${checkoutAll.get("SELECTED_CHECKOUT_MONTH")}-${checkoutAll.get("SELECTED_CHECKOUT_DAY")}"

        val checkinPrefs = getSharedPreferences("Dates", Context.MODE_PRIVATE)
        val checkinAll = checkinPrefs.all
        val checkin = "${checkinAll.get("SELECTED_YEAR")}-${checkinAll.get("SELECTED_MONTH")}-${checkinAll.get("SELECTED_DAY")}"
        
        val adultsPrefs = getSharedPreferences("NumberOfAdults",Context.MODE_PRIVATE)
            .getString("number",null) 

        // Set up View Model
        viewModel = ViewModelProviders.of(this).get(AppViewModel::class.java)

        // Observe Live data from backend
        observeHotelPhotosInfo()
        observeHotelDetailsinfo()

        //Fetch Info FromBackend
        fetchHotelPhotos(itemId)
        fetchHotelDetails(itemId,checkout,checkin,adultsPrefs)
    }

    private fun fetchHotelDetails(
        itemId: String?,
        checkout: String,
        checkin: String,
        adultsPrefs: String?
    ) {

        viewModel.fetchHotelDetails(AppUtilities.locale,AppUtilities.currency,checkout,adultsPrefs!!,
        checkin,itemId!!)
    }

    private fun observeHotelDetailsinfo() {

        viewModel.hotelDetails.observe(this, Observer {

            val locationName = it.data?.body?.pdpHeader?.hotelLocation?.locationName

            //Set up Toolbar Title
            AppUtilities.setupToolbar(this,toolbarHotelDetails,locationName.toString())
        })
    }

    private fun fetchHotelPhotos(itemId: String?) {

        viewModel.fetchHotelPhotos(itemId!!.toInt())
    }

    private fun observeHotelPhotosInfo() {

        viewModel.hotelPhoto.observe(this, Observer {

            Log.d(TAG,"Details Data = ${it.hotelImages?.get(0)?.baseUrl}")
        })
    }

    // Setup Items in toolbar selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // When home button is selected
        when (item.itemId) {
            android.R.id.home ->{
                finish()
            }
            R.id.editButtonToolbar ->{
                val intent = Intent(this, Reservation::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    // Create Items on toolbar (top right)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_edit_button,menu)

        return super.onCreateOptionsMenu(menu)
    }
}
