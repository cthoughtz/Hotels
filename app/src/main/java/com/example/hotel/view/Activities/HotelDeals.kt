package com.example.hotel.view.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.example.hotel.AppUtilities
import com.example.hotel.R
import com.example.hotel.interfaces.FavsUpdate
import com.example.hotel.view.Adapters.HotelDealsPager
import com.example.hotel.viewmodel.AppViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_hotel_deals.*
import kotlinx.android.synthetic.main.custom_favorites_tab.*

class HotelDeals : AppCompatActivity(), TabLayout.OnTabSelectedListener, FavsUpdate {

    val TAG = javaClass.simpleName
    lateinit var searchQuery: String
    lateinit var adultCount: String
    var checkIn = ""
    var checkOut = ""
    lateinit var viewModel: AppViewModel
    var favNumberCount = 0
    val pageNumber = "1"
    val pageSize = "25"
    var startCounter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_deals)

        // setup Toolbar
        AppUtilities.setupToolbar(this,hotelDealsToolbar,"null")

        // Get intents for search query and number of adults
        searchQuery = intent.getStringExtra(AppUtilities.SEARCH_DATA)
        adultCount = intent.getStringExtra(AppUtilities.ADULT_COUNT)

        // Add number of adults to shared preferences to be used for other api calls
        // if needed
        addAdultstoPrefs(adultCount)

        Log.d(TAG,"Search Query: $searchQuery")
        Log.d(TAG,"Adult Count: $adultCount")

        // setup Toolbar Items
        setReservationDates()
        setNumberOfAdults(adultCount)
        setUiClickListeners()

        //setUp Tablayout
        setUpTabLayout()

        // Initiate ViewModel
        viewModel = ViewModelProviders.of(this).get(AppViewModel::class.java)

        //Set Favorites
        setFavoritesCountTab()

    }

    private fun addAdultstoPrefs(adultCount: String?) {

        val prefs = getSharedPreferences("NumberOfAdults", Context.MODE_PRIVATE)
        val editor = prefs.edit().putString("number", adultCount)
        editor.commit()
    }


    private fun setUpTabLayout() {

        hotelsDealsTabLayout.apply{

            // Add Tabs to ViewPager
            addTab(this.newTab().setCustomView(R.layout.custom_all_tab))
            addTab(this.newTab().setCustomView(R.layout.custom_favorites_tab))

            setOnTabSelectedListener(this@HotelDeals)


        }
        val adapter = HotelDealsPager(supportFragmentManager,hotelsDealsTabLayout.tabCount)
        hotelDealsPager.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Set up action for when back arrow is clicked
        if (item.itemId == android.R.id.home) {

            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setUiClickListeners() {

        editButton.setOnClickListener {

            // Intent to go to the next Activity
            val intent = Intent(this,Reservation::class.java)
            startActivity(intent)
        }
    }

    private fun setNumberOfAdults(adultCount: String?) {

        // set number of adults on UI
        numberOfAdults.text = adultCount
    }

    private fun setReservationDates() {

        // Get Shared preferences
        val checkInDates = getSharedPreferences("Dates", Context.MODE_PRIVATE)
        val checkOutDates = getSharedPreferences("CheckoutDates", Context.MODE_PRIVATE)

        val checkInDay = checkInDates.getString(AppUtilities.selectedDay, "null")
        val checkInMonth = checkInDates.getString(AppUtilities.selectedMonth, "null")
        val checkInYear = checkInDates.getString(AppUtilities.selectedYear, "null")

        val checkOutDay = checkOutDates.getString(AppUtilities.selectedCheckoutDay, "null")
        val checkOutMonth = checkOutDates.getString(AppUtilities.selectedCheckoutMonth, "null")
        val checkOutYear = checkOutDates.getString(AppUtilities.selectedCheckoutYear,"null")

        //CheckIn - CheckOut for parameters in api request (HotelAllFragment)
        checkIn = "${checkInYear.toString()}-${checkInMonth.toString()}-${checkInDay.toString()}"
        checkOut ="${checkOutYear.toString()}-${checkOutMonth.toString()}-${checkOutDay.toString()}"



        // convert month number into month abbrevation
        val abbrMonCheckIn = AppUtilities.monthAbbrevations(checkInMonth!!)
        val abbrMonthCheckout = AppUtilities.monthAbbrevations(checkOutMonth!!)

        // Set Text in UI
        reservation_dates_tv.text = "$abbrMonCheckIn $checkInDay - $abbrMonthCheckout $checkOutDay"
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {

        hotelDealsPager.setCurrentItem(tab!!.position)
    }

    fun setFavoritesCountTab() {

        var counter = 0

        // Get all shared preferences values and store them in keys
        val favsPrefs = getSharedPreferences("FavoriteChecker", Context.MODE_PRIVATE)
        var keys = favsPrefs.getAll()

        // if keys is not null then cycle through the list of preferences and implement counter by
        // 1
        if (keys != null) {

            for (i in keys.values) {

                if (i == true) {
                    counter++
                }
            }

            // set favorites Tab's text to counter
            favorites_text.text = "Favorites($counter)"
            startCounter = counter
        }
    }

    override fun addToFavorites() {

        startCounter++

            // Callback method that will increment the value on the favorites tab when item
            // favorites button is activated
            Log.d("Counter", "Counter = $startCounter")
            favorites_text.text = "Favorites($startCounter)"
    }

    override fun removeFromFavorites() {

        startCounter--

        // Callback method that will decrement the value on the favorites tab when item favorites
        // button is not activated
        Log.d("Counter", "Counter = $startCounter")
        favorites_text.text = "Favorites($startCounter)"
    }
}
