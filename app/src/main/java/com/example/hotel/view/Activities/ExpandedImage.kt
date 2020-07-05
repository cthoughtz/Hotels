package com.example.hotel.view.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.hotel.R
import kotlinx.android.synthetic.main.activity_expanded_image.*

class ExpandedImage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expanded_image)

        setSupportActionBar(expanded_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        val imageUrl = intent.getStringExtra("Url")
        val listSize = intent.getStringExtra("ListSize")
        val currentPosition = intent.getStringExtra("CurrentPosition")

        Glide.with(this)
            .load(imageUrl)
            .into(hotelImage)

        numberOfItems.text = "$currentPosition/$listSize"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}