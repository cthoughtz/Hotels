package com.example.hotel.view.Fragments


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hotel.R
import com.example.hotel.view.Activities.CheckIn
import com.example.hotel.view.Activities.HomeScreen
import com.example.hotel.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.homescreen_main.*
import kotlin.math.E

class SearchFragment : Fragment() {

    lateinit var viewModel: AppViewModel
    val SEARCH_DATA ="SEARCH_QUERY"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initiate ViewModel
        viewModel = ViewModelProviders.of(this).get(AppViewModel::class.java)


        //Observer Server
        //Todo move to details activity that shows hotel details
        observeSearchQuery()

        callHotel.setOnClickListener{

            //Make call when clicking on the phone icon
            callHotel()
        }

        // Search backend for location
        searchQuery()


    }


    fun observeSearchQuery(){

        viewModel.hotelSearches.observe(viewLifecycleOwner, Observer{

            val testResponse = it.trackingID

            Log.d("TAG",testResponse)
        })
    }


    fun searchQuery(){

        search_edit_text.setOnEditorActionListener( object: TextView.OnEditorActionListener{
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {

                var searchQuery = search_edit_text.text.toString()

                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                    actionId == EditorInfo.IME_ACTION_DONE ||
                    actionId == EditorInfo.IME_ACTION_SEND ||
                    event?.action == KeyEvent.ACTION_DOWN &&
                    event?.keyCode == KeyEvent.KEYCODE_ENTER){

                    // Todo move method to details fragment that shows hotel information
                    viewModel.fetchSearchResult(searchQuery)

                    val intent = Intent(activity, CheckIn::class.java)
                    intent.putExtra(SEARCH_DATA,searchQuery)
                    startActivity(intent)

                    return true
                }
                return false
            }

        })
    }

    fun callHotel(){

        val callLocalNumber = Intent(Intent.ACTION_DIAL)
        callLocalNumber.setData(Uri.parse("tel:${getString(R.string.toll_free_number)}"))
        startActivity(callLocalNumber)
    }

}
