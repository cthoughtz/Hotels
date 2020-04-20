package com.example.hotel.view.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hotel.AppUtilities
import com.example.hotel.R
import com.example.hotel.viewmodel.AppViewModel

class HotelDeals : AppCompatActivity() {

    val TAG = javaClass.simpleName
    lateinit var searchQuery: String
    lateinit var viewModel: AppViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_deals)

        searchQuery = intent.getStringExtra(AppUtilities.SEARCH_DATA)
        Log.d(TAG,"Search Query: $searchQuery")

        // Initiate ViewModel
        viewModel = ViewModelProviders.of(this).get(AppViewModel::class.java)
        observeSearchQuery()

        searchResult()
    }

    private fun searchResult() {
        viewModel.fetchSearchResult(searchQuery)
    }

    fun observeSearchQuery(){

        viewModel.hotelSearches.observe(this, Observer{

            val testResponse = it.trackingID
            val testResponseTwo = it.suggestions
            Log.d(TAG,testResponse)
            Log.d(TAG,"Suggested Terms: $testResponseTwo")
        })
    }
}
