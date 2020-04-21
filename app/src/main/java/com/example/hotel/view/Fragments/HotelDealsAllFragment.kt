package com.example.hotel.view.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dinuscxj.progressbar.CircleProgressBar
import com.example.hotel.R
import com.example.hotel.view.Activities.HotelDeals
import kotlinx.android.synthetic.main.fragment_hotel_deals_all.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class HotelDealsAllFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel_deals_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sq = (activity as HotelDeals)
        setUpBookedPercentagCardView(sq.searchQuery)
    }

    private fun setUpBookedPercentagCardView(searchQuery: String) {

        var DEFAUL_PATTERN = "%d%%"
        var random = (1..100).random()

        val progress = object: CircleProgressBar.ProgressFormatter{
            override fun format(progress: Int, max: Int): CharSequence {

                return String.format(DEFAUL_PATTERN, random)
            }
        }

        circleProgressBar2.progress = random
        circleProgressBar2.setProgressFormatter(progress)

        bookedPercentText.text = "We are $random% booked! $searchQuery is popular for your travel dates."

        closeBookedPercentTextView.setOnClickListener{

            bookedPercentContraint.visibility = View.GONE
        }
    }

}
