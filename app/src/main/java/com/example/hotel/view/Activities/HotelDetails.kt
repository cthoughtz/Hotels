package com.example.hotel.view.Activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.text.bold
import androidx.core.text.color
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotel.AppUtilities
import com.example.hotel.R
import com.example.hotel.model.HotelPhotosResponse
import com.example.hotel.model.RecyclerViewDataClass.HotelDetailsPhotos
import com.example.hotel.view.Adapters.HotelDetailsAdditionalImageAdapter
import com.example.hotel.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.activity_hotel_details.*

class HotelDetails : AppCompatActivity() {

    lateinit var viewModel: AppViewModel
    lateinit var mainTitle: String
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
            mainTitle = it.data?.body?.propertyDescription?.name.toString()

            val freeWifiChecker = it?.data?.body?.overview?.overviewSections?.get(0)?.content
            setUpWifiMessage(freeWifiChecker)

            val subTitle = it?.data?.body?.overview?.overviewSections?.get(2)?.content
            setUpSubTitle(subTitle)

            val stars = it.data?.body?.propertyDescription?.starRatingTitle
            setupRating(stars)

            val currentPrice = it.data?.body?.propertyDescription?.featuredPrice?.currentPrice?.formatted
            setUpPrice(currentPrice)

            //Set up Toolbar Title
            AppUtilities.setupToolbar(this,toolbarHotelDetails,locationName.toString())
        })
    }

    private fun setUpPrice(cPrice: String?) {

        cPrice?.let {
            currentPrice.text = it

            // Get Weekly rate
            val week = AppUtilities.weeklyRate(it)
            //Make weekly rate bold to display on screen
            val typeStyledTextOutput = SpannableStringBuilder().append("($").bold{append(week)}.append(" for 6 nights)")

            nightyStatement.visibility = View.VISIBLE
            weeklyRate.text = typeStyledTextOutput

        }
    }

    private fun setUpSubTitle(subTitle: List<String?>?) {

        subTitle?.let {

            val sub = Html.fromHtml(subTitle.get(0).toString())
            subTitleText.text = sub
        }
    }

    private fun setUpWifiMessage(freeWifiChecker: List<String?>?) {

        // Only if the list is not null
        freeWifiChecker?.let {

            // Check to see if the list contains Free Wifi
            if (it.contains("Free WiFi "))
                // Make TextView Visible
                frWifi.visibility = View.VISIBLE
        }
    }

    private fun setupRating(stars: String?) {

        // Set up stars rating
        when (stars) {
            "1 star" ->{
                one_star.visibility = View.VISIBLE
                two_star.visibility = View.GONE
                three_star.visibility = View.GONE
                four_star.visibility = View.GONE
                five_star.visibility = View.GONE
                half_star.visibility = View.GONE

            }
            "1.5 stars" ->{
                one_star.visibility = View.VISIBLE
                two_star.visibility = View.GONE
                three_star.visibility = View.GONE
                four_star.visibility = View.GONE
                five_star.visibility = View.GONE
                half_star.visibility = View.VISIBLE

            }
            "2 stars"->{
                one_star.visibility = View.VISIBLE
                two_star.visibility = View.VISIBLE
                three_star.visibility = View.GONE
                four_star.visibility = View.GONE
                five_star.visibility = View.GONE
                half_star.visibility = View.GONE
            }
            "2.5 stars"->{
                one_star.visibility = View.VISIBLE
                two_star.visibility = View.VISIBLE
                three_star.visibility = View.GONE
                four_star.visibility = View.GONE
                five_star.visibility = View.GONE
                half_star.visibility = View.VISIBLE
            }
            "3 stars"->{
                one_star.visibility = View.VISIBLE
                two_star.visibility = View.VISIBLE
                three_star.visibility = View.VISIBLE
                four_star.visibility = View.GONE
                five_star.visibility = View.GONE
                half_star.visibility = View.GONE
            }
            "3.5 stars"->{
                one_star.visibility = View.VISIBLE
                two_star.visibility = View.VISIBLE
                three_star.visibility = View.VISIBLE
                four_star.visibility = View.GONE
                five_star.visibility = View.GONE
                half_star.visibility = View.VISIBLE
            }
            "4 stars"->{
                one_star.visibility = View.VISIBLE
                two_star.visibility = View.VISIBLE
                three_star.visibility = View.VISIBLE
                four_star.visibility = View.VISIBLE
                five_star.visibility = View.GONE
                half_star.visibility = View.GONE
            }
            "4.5 stars"->{
                one_star.visibility = View.VISIBLE
                two_star.visibility = View.VISIBLE
                three_star.visibility = View.VISIBLE
                four_star.visibility = View.VISIBLE
                five_star.visibility = View.GONE
                half_star.visibility = View.VISIBLE
            }
            "5 stars"->{
                one_star.visibility = View.VISIBLE
                two_star.visibility = View.VISIBLE
                three_star.visibility = View.VISIBLE
                four_star.visibility = View.VISIBLE
                five_star.visibility = View.VISIBLE
                half_star.visibility = View.GONE
            }
        }
    }

    // Set up horizontal recyclerView for list of images associated with specific hotel
    private fun setupRecyclerView(it: HotelPhotosResponse?) {

        val imageSize = "_z.jpg"

        // Set up Adapter for RecyclerView
        var roomImageList = ArrayList<HotelDetailsPhotos>()
        var additionaImageAdapter = HotelDetailsAdditionalImageAdapter(this@HotelDetails,roomImageList)

        val size = it?.hotelImages?.size

        // setS total number of images
        size?.let {
            totalNumberOfImages.visibility = View.VISIBLE
            totalNumberOfImages.text = it.toString()

            //Set Text for Main Title
            hotelDetailsMainTitle.text = mainTitle
        }

        for (i in 0 until size!!){

            //todo - check after monthly quota for request is renewed 
          var  rawThumbnail = it?.hotelImages?.get(i)?.baseUrl.toString()
          var  splitThumbnailString = rawThumbnail.split("_")
          var  firstHalfThumbnailString = splitThumbnailString[0]
          var  usableThumbnailString = "$firstHalfThumbnailString$imageSize"

            roomImageList.add(HotelDetailsPhotos(usableThumbnailString))
        }
        additionaImageAdapter!!.notifyDataSetChanged()

        hotelDetailsImageGallery.apply {

            layoutManager = LinearLayoutManager(this@HotelDetails, LinearLayoutManager.HORIZONTAL,false)
            adapter = additionaImageAdapter
        }
    }

    private fun fetchHotelPhotos(itemId: String?) {

        viewModel.fetchHotelPhotos(itemId!!.toInt())
    }

    private fun observeHotelPhotosInfo() {

        viewModel.hotelPhoto.observe(this, Observer {

            // Set up Recyclerview
            setupRecyclerView(it)
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