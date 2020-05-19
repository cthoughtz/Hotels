package com.example.hotel.view.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dinuscxj.progressbar.CircleProgressBar
import com.example.hotel.R
import com.example.hotel.RoomDataBase.AppDatabase
import com.example.hotel.interfaces.FavsUpdate
import com.example.hotel.model.HotelListResponse
import com.example.hotel.model.RecyclerView.PropertyList
import com.example.hotel.view.Activities.BaseApplication
import com.example.hotel.view.Activities.HotelDeals
import com.example.hotel.view.Adapters.PropertyListRecyclerAdapter
import com.example.hotel.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.custom_favorites_tab.*
import kotlinx.android.synthetic.main.fragment_hotel_deals_all.*
import kotlinx.android.synthetic.main.hotel_detail_item_list.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class HotelDealsAllFragment : Fragment() {

    lateinit var viewModel: AppViewModel
    val TAG = javaClass.simpleName
    var searchQuery = " "
    var numberOfAdults = " "
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

        // Intent for items to be displayed on Screen
        searchQuery = (activity as HotelDeals).searchQuery
        numberOfAdults = (activity as HotelDeals).adultCount
        pageNumber = (activity as HotelDeals).pageNumber
        pageSize = (activity as HotelDeals).pageSize
        checkIn = (activity as HotelDeals).checkIn
        checkOut = (activity as HotelDeals).checkOut

        Log.d(TAG, "Search Query: $searchQuery")
        Log.d(TAG, "Number of Adults: $numberOfAdults")
        Log.d(TAG, "PageNumber: $pageNumber")
        Log.d(TAG, "Page Size: $pageSize")
        Log.d(TAG, "Check In: $checkIn")
        Log.d(TAG, " Check Out: $checkOut")

        // So random percent value (Only for show because there is not data from the server to so
        // Actual data
        setUpBookedPercentagCardView(searchQuery)

        // Initilize viewmodel
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

    fun observeSearchQuery() {

        viewModel.hotelSearches.observe(viewLifecycleOwner, Observer {

            val hotelGeoId = it.suggestions?.get(0)?.entities?.get(0)?.destinationId.toString()
            Log.d(TAG, "GeoId: $hotelGeoId")

            // Passes search data to backend which will retrieve information form endpoint
            propretySearchRequest(hotelGeoId)

        })
    }

    fun observeProperties() {

        viewModel.hotelList.observe(viewLifecycleOwner, Observer {
            setupRecyclerView(it)
        })
    }

    private fun setupRecyclerView(it: HotelListResponse?) {

        // Set up Adapter for RecyclerView
        var propList = ArrayList<PropertyList>()
        var propListAdapter = PropertyListRecyclerAdapter(activity!!, propList)

        addDatatoArrayList(propList, it, propListAdapter)


        hotelDetailsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = propListAdapter
        }
    }

    private fun addDatatoArrayList(
        propList: java.util.ArrayList<PropertyList>,
        it: HotelListResponse?,
        propListAdapter: PropertyListRecyclerAdapter
    ) {
        // Adds Data to adapter
        var counter = 0
        var mainTitle = " "
        var subTitle = " "
        var mileageLabel = " "
        var mileageDistance = " "
        var price = " "
        var oldPrice = " "
        var rating = " "
        var numberOfPeopleRating = " "
        var thumbnail = " "
        var destinationId = " "

        val size = it?.data?.body?.searchResults?.results?.size
        for (i in 0 until size!!) {

            mainTitle = it?.data?.body?.searchResults?.results?.get(counter)?.name.toString()
            subTitle =
                it?.data?.body?.searchResults?.results?.get(counter)?.address?.locality.toString()
            mileageLabel =
                it?.data?.body?.searchResults?.results?.get(counter)?.landmarks?.get(0)?.label.toString()
            mileageDistance =
                it?.data?.body?.searchResults?.results?.get(counter)?.landmarks?.get(0)?.distance.toString()
            price =
                it?.data.body?.searchResults?.results?.get(counter)?.ratePlan?.price?.current.toString()
            oldPrice = it?.data.body?.searchResults?.results?.get(counter)?.ratePlan?.price?.old.toString()
            rating = it?.data?.body?.searchResults?.results?.get(counter)?.guestReviews?.rating.toString()
            numberOfPeopleRating = it?.data?.body?.searchResults?.results?.get(counter)?.guestReviews?.total.toString()
            thumbnail = it?.data?.body?.searchResults?.results?.get(counter)?.thumbnailUrl.toString()
            destinationId = it?.data?.body?.searchResults?.results?.get(counter)?.id.toString()

            propList.add(
                PropertyList(
                    mainTitle,
                    subTitle,
                    "$mileageDistance miles from $mileageLabel",
                    price,
                    "null"
                    ,
                    oldPrice,
                    "testing",
                    rating,
                    numberOfPeopleRating,
                    "testing",
                    thumbnail,
                    destinationId
                )
            )

            counter++
        }

        propListAdapter!!.notifyDataSetChanged()
    }


    fun propretySearchRequest(destinationId: String) {

        // Fetch Data from searver
        viewModel.fetchHotelList(
            currency,
            locale,
            sortOrder,
            destinationId,
            pageNumber,
            checkIn,
            checkOut,
            pageSize,
            numberOfAdults
        )
    }


    private fun setUpBookedPercentagCardView(searchQuery: String) {

        // set up fake booked percentage
        var DEFAUL_PATTERN = "%d%%"
        var random = (1..100).random()

        val progress = object : CircleProgressBar.ProgressFormatter {
            override fun format(progress: Int, max: Int): CharSequence {

                return String.format(DEFAUL_PATTERN, random)
            }
        }

        circleProgressBar2.progress = random
        circleProgressBar2.setProgressFormatter(progress)

        bookedPercentText.text =
            "We are $random% booked! $searchQuery is popular for your travel dates."

        closeBookedPercentTextView.setOnClickListener {

            bookedPercentContraint.visibility = View.GONE
        }
    }
}
