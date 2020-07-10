package com.example.hotel.view.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotel.R
import kotlinx.android.synthetic.main.amenities_list.view.*

class FeelAtHomeAdapter(val context: Context, val homeList:ArrayList<String>):RecyclerView.Adapter<FeelAtHomeAdapter.ViewHolder>() {


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val listItem = itemView.amentities_items

        fun bindItem(homeListResponse: String){

            listItem.text = homeListResponse
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.amenities_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()= homeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItem(homeList[position])
    }
}