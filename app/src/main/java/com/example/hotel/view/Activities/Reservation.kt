package com.example.hotel.view.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.hotel.AppUtilities
import com.example.hotel.R
import kotlinx.android.synthetic.main.activity_check_in.*

class Reservation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        AppUtilities.setupToolbar(this,check_in_toolbar,"Reservation")
        cardView_checkin.setOnClickListener {

            val intent = Intent(this, ReservationCalender::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {

            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
