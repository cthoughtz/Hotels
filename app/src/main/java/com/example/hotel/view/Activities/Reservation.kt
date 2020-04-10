package com.example.hotel.view.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.hotel.AppUtilities
import com.example.hotel.R
import com.jakewharton.rxbinding2.view.activated
import kotlinx.android.synthetic.main.activity_check_in.*

class Reservation : AppCompatActivity() {

    var adultPersonCounter = 1
    var childPersonCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        AppUtilities.setupToolbar(this,check_in_toolbar,"Reservation")

        cardView_checkin.setOnClickListener {

            val intent = Intent(this, ReservationCalender::class.java)
            startActivity(intent)
        }

        btn_add_adult.setOnClickListener{

            if (adultPersonCounter < 8){
                adultPersonCounter++
            }

            numberOfAddultsPerRoom(adultPersonCounter)
        }

        btn_remove_adult.setOnClickListener {

             if(adultPersonCounter > 1){
                adultPersonCounter--
            }

            numberOfAddultsPerRoom(adultPersonCounter)
        }
    }

    private fun numberOfAddultsPerRoom(adultPersonCounter: Int) {

        adult_text_count.text = adultPersonCounter.toString()

        btn_remove_adult.isActivated = adultPersonCounter> 1
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {

            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
