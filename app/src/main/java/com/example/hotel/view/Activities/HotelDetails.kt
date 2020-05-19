package com.example.hotel.view.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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

        // Set up View Model
        viewModel = ViewModelProviders.of(this).get(AppViewModel::class.java)

        // Observe Live data from backend
        obserserveHotelDetailsInfo()

        //Fetch Infor FromBackend
        fetchHotelDetails(itemId)
    }

    private fun fetchHotelDetails(itemId: String?) {

        viewModel.fetchHotelPhotos(itemId!!.toInt())
    }

    private fun obserserveHotelDetailsInfo() {

        viewModel.hotelPhoto.observe(this, Observer {

            Log.d(TAG,"Details Data = ${it.hotelImages?.get(0)?.baseUrl}")
        })
    }
}
