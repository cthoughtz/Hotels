package com.example.hotel.view.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotel.R
import kotlinx.android.synthetic.main.amenities_list.view.*

class MainAmenitiesAdapter(val context: Context, val amenList:ArrayList<String>): RecyclerView.Adapter<MainAmenitiesAdapter.ViewHolder>(){


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainAmenitiesAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.amenities_list,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount()= amenList.size

    override fun onBindViewHolder(holder: MainAmenitiesAdapter.ViewHolder, position: Int) {

        holder.bindItem(amenList[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val amenItem = itemView.amentities_items

        fun bindItem(amenListResponse: String){

            amenItem.text = amenListResponse
        }

    }
}