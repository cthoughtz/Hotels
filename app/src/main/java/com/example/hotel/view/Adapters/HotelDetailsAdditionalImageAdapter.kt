package com.example.hotel.view.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotel.R
import com.example.hotel.model.RecyclerViewDataClass.HotelDetailsPhotos
import kotlinx.android.synthetic.main.activity_check_in.*

class HotelDetailsAdditionalImageAdapter(val context: Context, val additionalImagesList:ArrayList<HotelDetailsPhotos>): RecyclerView.Adapter<HotelDetailsAdditionalImageAdapter.ViewHolder>() {

    val c = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelDetailsAdditionalImageAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.hotel_details_additional_room_images_list, parent, false)
        return ViewHolder(v,c)
    }

    override fun getItemCount()= additionalImagesList.size

    override fun onBindViewHolder(holder: HotelDetailsAdditionalImageAdapter.ViewHolder, position: Int) {

        holder.bindItems(additionalImagesList[position])
    }

    class ViewHolder(itemView: View, context: Context): RecyclerView.ViewHolder(itemView){

        val ctx = context
        val roomPhoto = itemView.findViewById<ImageView>(R.id.additionalRoomImages)

        fun bindItems(additionalImages: HotelDetailsPhotos){

            //Set Image
            setImages(additionalImages)
        }

        private fun setImages( additionalImages: HotelDetailsPhotos) {

            // Set Image on UI
            Glide.with(ctx)
                .load(additionalImages.additionalRoomImages)
                .into(roomPhoto!!)
        }
    }
}