package com.example.hotel.view.Adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotel.AppUtilities
import com.example.hotel.R
import com.example.hotel.model.RecyclerView.PropertyList
import kotlinx.android.synthetic.main.hotel_detail_item_list.*
import java.util.*
import kotlin.collections.ArrayList

class PropertyListRecyclerAdapter(val context: Context, val propertyList:ArrayList<PropertyList>): RecyclerView.Adapter<PropertyListRecyclerAdapter.ViewHolder>() {


    val c = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.hotel_detail_item_list, parent,false)
        return ViewHolder(v,c)
    }


    override fun getItemCount()= propertyList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(propertyList[position])
    }

    class ViewHolder(itemView: View,context:Context) : RecyclerView.ViewHolder(itemView) {

        val ctx = context

        val mainTitle = itemView.findViewById<TextView>(R.id.mainTitle)
        val subTitle = itemView.findViewById<TextView>(R.id.subTitle)
        val mileage = itemView.findViewById<TextView>(R.id.mileage)
        val price = itemView.findViewById<TextView>(R.id.price)
        val limitedOffer = itemView.findViewById<TextView>(R.id.limitedOffer)
        val oldPrice = itemView.findViewById<TextView>(R.id.oldPrice)
        val exceptional = itemView.findViewById<TextView>(R.id.exceptional)
        val rating = itemView.findViewById<TextView>(R.id.rating)
        val numberOfPeopleRating = itemView.findViewById<TextView>(R.id.numberOfPeopleRating)
        val setPrice = itemView.findViewById<TextView>(R.id.setPrice)
        val roomPhotoImage = itemView.findViewById<ImageView>(R.id.roomPhoto)

        fun bindItems(propertyList: PropertyList) {

           mainTitle.text = propertyList.mainTile
            subTitle.text = propertyList.subTitle
            mileage.text = propertyList.mileage
            price.text = propertyList.price

            // set random color for prices and limited offer
           setRandomColors(price,ctx)

            // set up limited offer based on percent
            setLimitOffer(limitedOffer, propertyList)

        }


        private fun setRandomColors(tv: TextView, context:Context) {

            var colors = context.resources.getIntArray(R.array.randomcolorlist)
            var randomColor = colors[Random().nextInt(colors.size)]
            tv.setTextColor(randomColor)
        }

        fun setLimitOffer(lm: TextView, pl: PropertyList){

            lm?.let {

                lm.text = pl.limitedOffer
                val moneySaved = AppUtilities.percentCalculator(it.text.toString())

                if (moneySaved < lm.text.toString().toInt()){
                    lm.text = "Save $moneySaved%"
                }
            }

        }
    }

}