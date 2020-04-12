package com.example.hotel.view.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.hotel.AppUtilities
import com.example.hotel.R
import kotlinx.android.synthetic.main.activity_check_in.*
import kotlinx.android.synthetic.main.activity_check_in.view.*

class Reservation : AppCompatActivity() {

    lateinit var childSpinner:Array<String>
    var adultPersonCounter = 1
    var childPersonCounter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        AppUtilities.setupToolbar(this,check_in_toolbar,"Reservation")

        childSpinner = resources.getStringArray(R.array.age_of_child_spinner)


       setUpSpinners()


        cardView_checkin.setOnClickListener {

            val intent = Intent(this, ReservationCalender::class.java)
            startActivity(intent)
        }

        btn_add_adult.setOnClickListener{

            if (adultPersonCounter < 8){
                adultPersonCounter++
            }

            numberOfAdultsPerRoom(adultPersonCounter)
        }

        btn_remove_adult.setOnClickListener {

             if(adultPersonCounter > 1){
                adultPersonCounter--
            }

            numberOfAdultsPerRoom(adultPersonCounter)
        }


        btn_add_children.setOnClickListener {

            if (childPersonCounter < 3){
                childPersonCounter++
            }

            numberOfChildrenPerRoom(childPersonCounter)
        }

        btn_remove_children.setOnClickListener {

            if(childPersonCounter > 0){
                childPersonCounter--
            }
            numberOfChildrenPerRoom(childPersonCounter)
        }

        textView20.setOnClickListener {

            Toast.makeText(this,"No functionality for Demo",Toast.LENGTH_LONG).show()
        }

        btn_show_deals.setOnClickListener {

            val intent = Intent(this,HotelDeals::class.java)
            startActivity(intent)
        }


    }

    private fun setUpSpinners() {
        ArrayAdapter(this,android.R.layout.simple_spinner_item,
            childSpinner).apply {

            spinner_child_1.adapter = this

            spinner_child_1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }

            }
        }


        ArrayAdapter(this,android.R.layout.simple_spinner_item,
            childSpinner).apply {

            spinner_child_2.adapter = this

            spinner_child_2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }

            }
        }

        ArrayAdapter(this,android.R.layout.simple_spinner_item,
            childSpinner).apply {

            spinner_child_3.adapter = this

            spinner_child_3.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }

            }
        }

    }

    private fun numberOfChildrenPerRoom(childPersonCounter: Int){

        child_text_count.text = childPersonCounter.toString()

        btn_remove_children.isActivated = childPersonCounter>0

        when(childPersonCounter){

            0->{
                view_three.visibility = View.GONE
                text_child_1.visibility = View.GONE
                spinner_child_1.visibility = View.GONE
                child_text_count_1.visibility = View.GONE
            }
            1 -> {
                view_three.visibility = View.VISIBLE
                text_child_1.visibility = View.VISIBLE
                spinner_child_1.visibility = View.VISIBLE
                child_text_count_1.visibility = View.VISIBLE

                view_four.visibility = View.GONE
                text_child_2.visibility = View.GONE
                spinner_child_2.visibility = View.GONE
                child_text_count_2.visibility = View.GONE
            }
            2 ->{

                view_four.visibility = View.VISIBLE
                text_child_2.visibility = View.VISIBLE
                spinner_child_2.visibility = View.VISIBLE
                child_text_count_2.visibility = View.VISIBLE

                view_five.visibility = View.GONE
                text_child_3.visibility = View.GONE
                spinner_child_3.visibility = View.GONE
                child_text_count_3.visibility = View.GONE
            }
            3 ->{
                view_five.visibility = View.VISIBLE
                text_child_3.visibility = View.VISIBLE
                spinner_child_3.visibility = View.VISIBLE
                child_text_count_3.visibility = View.VISIBLE
            }
        }

    }

    private fun numberOfAdultsPerRoom(adultPersonCounter: Int) {

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
