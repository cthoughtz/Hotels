package com.example.hotel.view.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hotel.R
import kotlinx.android.synthetic.main.activity_check_in.*

class CheckIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        //setup toolbar
       setSupportActionBar(check_in_toolbar)
        val checkInToolbar = supportActionBar
        checkInToolbar?.title = "Reservation"
        checkInToolbar?.setDisplayHomeAsUpEnabled(true)
    }
}
