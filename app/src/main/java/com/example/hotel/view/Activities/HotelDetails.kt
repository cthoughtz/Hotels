package com.example.hotel.view.Activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hotel.AppUtilities
import com.example.hotel.R
import com.example.hotel.viewmodel.AppViewModel

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

        //Fetch Infor FromBackend
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
            // DATA
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
}
