package com.example.hotel.view.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TableLayout
import androidx.viewpager.widget.ViewPager
import com.example.hotel.AppUtilities
import com.example.hotel.R
import com.example.hotel.view.Adapters.Pager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_reservation_calender.*
import kotlinx.android.synthetic.main.fragment_check_in.*
import java.util.*

class ReservationCalender : AppCompatActivity(), TabLayout.OnTabSelectedListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation_calender)

        AppUtilities.setupToolbar(this,calendar_toolbar,"Calendar")

        tabLayout.apply {
            addTab(this.newTab().setText("CHECK-IN"))
            addTab(this.newTab().setText("CHECK-OUT"))

            setOnTabSelectedListener(this@ReservationCalender)
        }

        val adapter = Pager(supportFragmentManager,tabLayout.tabCount)
        pager.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {

            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onTabReselected(p0: TabLayout.Tab?) {

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        pager.setCurrentItem(tab!!.position)
    }
}
