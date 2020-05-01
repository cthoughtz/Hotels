package com.example.hotel.view.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dinuscxj.progressbar.CircleProgressBar
import com.example.hotel.R
import com.example.hotel.view.Activities.HotelDeals
import com.example.hotel.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.fragment_hotel_deals_all.*

/**
 * A simple [Fragment] subclass.
 */
class HotelDealsAllFragment : Fragment() {

    lateinit var viewModel: AppViewModel
    val TAG = javaClass.simpleName
    var searchQuery = " "
    var numberOfAdults =" "
    var pageNumber = " "
    var pageSize = " "
    var checkIn = " "
    var checkOut = " "
    val currency = "USD"
    val locale = "en_US"
    val sortOrder = "PRICE"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel_deals_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchQuery = (activity as HotelDeals).searchQuery
        numberOfAdults = (activity as HotelDeals).adultCount
        pageNumber = (activity as HotelDeals).pageNumber
        pageSize = (activity as HotelDeals).pageSize
        checkIn = (activity as HotelDeals).checkIn
        checkOut = (activity as HotelDeals).checkOut

        Log.d(TAG,"Search Query: $searchQuery")
        Log.d(TAG,"Number of Adults: $numberOfAdults")
        Log.d(TAG,"PageNumber: $pageNumber")
        Log.d(TAG,"Page Size: $pageSize")
        Log.d(TAG,"Check In: $checkIn")
        Log.d(TAG," Check Out: $checkOut")

        setUpBookedPercentagCardView(searchQuery)

        viewModel = ViewModelProviders.of(requireActivity()).get(AppViewModel::class.java)

        // Observe Data for updates
        observeSearchQuery()
        observeProperties()

        // Fetch Data from backend
        searchRequest()


    }

    private fun searchRequest() {
        // search backend with search query
        viewModel.fetchSearchResult(searchQuery)
    }

    fun observeSearchQuery(){

        viewModel.hotelSearches.observe(viewLifecycleOwner, Observer{

            val hotelGeoId = it.suggestions?.get(0)?.entities?.get(0)?.destinationId.toString()
            Log.d(TAG,"GeoId: $hotelGeoId")

            propretySearchRequest(hotelGeoId)

        })
    }

    fun observeProperties() {

        viewModel.hotelList.observe(viewLifecycleOwner, Observer {

            val testData = it.result?.get(0)
            val testDataTwo = it.data
            Log.d(TAG,"Idprop: $it")
        })
    }


    fun propretySearchRequest(destinationId: String){

        val test = destinationId
        Log.d(TAG,"destinationID: $destinationId")

        viewModel.fetchHotelList(currency,locale,sortOrder,destinationId,pageNumber,checkIn,checkOut,pageSize,numberOfAdults)
    }



    private fun setUpBookedPercentagCardView(searchQuery: String) {

        // set up fake booked percentage
        var DEFAUL_PATTERN = "%d%%"
        var random = (1..100).random()

        val progress = object: CircleProgressBar.ProgressFormatter{
            override fun format(progress: Int, max: Int): CharSequence {

                return String.format(DEFAUL_PATTERN, random)
            }
        }

        circleProgressBar2.progress = random
        circleProgressBar2.setProgressFormatter(progress)

        bookedPercentText.text = "We are $random% booked! $searchQuery is popular for your travel dates."

        closeBookedPercentTextView.setOnClickListener{

            bookedPercentContraint.visibility = View.GONE
        }
    }

}
