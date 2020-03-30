package com.example.hotel.view.Fragments


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotel.R
import com.example.hotel.view.Activities.HomeScreen
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.homescreen_main.*

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        callHotel.setOnClickListener{

            callHotel()
        }
    }


    fun callHotel(){

        val callLocalNumber = Intent(Intent.ACTION_DIAL)
        callLocalNumber.setData(Uri.parse("tel:${getString(R.string.toll_free_number)}"))
        startActivity(callLocalNumber)
    }

}
