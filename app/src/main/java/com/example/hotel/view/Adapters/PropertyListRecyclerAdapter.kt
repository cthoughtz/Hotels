package com.example.hotel.view.Adapters

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Build
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotel.AppUtilities
import com.example.hotel.R
import com.example.hotel.RoomDataBase.AppDatabase
import com.example.hotel.model.RecyclerView.PropertyList
import com.example.hotel.services.DatabaseTransactions
import com.example.hotel.view.Activities.BaseApplication
import kotlinx.android.synthetic.main.hotel_detail_item_list.view.*
import java.util.*
import kotlin.collections.ArrayList

class PropertyListRecyclerAdapter(val context: Context, val propertyList:ArrayList<PropertyList>): RecyclerView.Adapter<PropertyListRecyclerAdapter.ViewHolder>() {

    val c = context
    val pl = propertyList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.hotel_detail_item_list, parent,false)
        return ViewHolder(v,c)
    }


    override fun getItemCount()= propertyList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(propertyList[position])

        // setclick listener for favorites icon
        holder.itemView.favorite.setOnClickListener{

            if (holder.itemView.favorite.isActivated == false){

                // activated favorites icon when click
                // save data that is on cardview into room database
                holder.itemView.favorite.isActivated = true
                insertItemIntoDatabase(position)

            } else{

                // deactivate favorites icon when clicked
                // remove data that is on cardview into room database
                holder.itemView.favorite.isActivated = false
                deleteItemFromDatabase(position)
            }
        }

        holder.itemView.setOnClickListener{
            Toast.makeText(c,"Clicked",Toast.LENGTH_LONG).show()
        }
    }

    private fun deleteItemFromDatabase(position: Int) {

        // start service that inserts data in database
        // data must be placed into database on seperate thread or service or it might block the UI.
        val dbIntent = Intent()
        dbIntent.setClass(c,DatabaseTransactions::class.java)
        dbIntent.putExtra("position", position.toString())
        dbIntent.putExtra("mainTitle",pl.get(position).mainTile)
        dbIntent.putExtra("subTitle",pl.get(position).subTitle)
        dbIntent.putExtra("mileage",pl.get(position).mileage)
        dbIntent.putExtra("price",pl.get(position).price)
        dbIntent.putExtra("limitedOffer",pl.get(position).limitedOffer)
        dbIntent.putExtra("oldPrice",pl.get(position).oldPrice)
        dbIntent.putExtra("exceptional",pl.get(position).exceptional)
        dbIntent.putExtra("rating",pl.get(position).rating)
        dbIntent.putExtra("numberOfPeopleRating",pl.get(position).numberOfPeopleRating)
        dbIntent.putExtra("setPrice",pl.get(position).setPrice)
        dbIntent.putExtra("roomPhotoImage",pl.get(position).roomPhotoImage)
        c.startService(dbIntent)
    }

    private fun insertItemIntoDatabase(position: Int) {

        // starts service that delete data from database
        // data must be placed into database on seperate thread or service or it might block the UI.
        val dbIntent = Intent()
        dbIntent.setClass(c,DatabaseTransactions::class.java)
        dbIntent.putExtra("insert","insert")
        dbIntent.putExtra("position", position.toString())
        dbIntent.putExtra("mainTitle",pl.get(position).mainTile)
        dbIntent.putExtra("subTitle",pl.get(position).subTitle)
        dbIntent.putExtra("mileage",pl.get(position).mileage)
        dbIntent.putExtra("price",pl.get(position).price)
        dbIntent.putExtra("limitedOffer",pl.get(position).limitedOffer)
        dbIntent.putExtra("oldPrice",pl.get(position).oldPrice)
        dbIntent.putExtra("exceptional",pl.get(position).exceptional)
        dbIntent.putExtra("rating",pl.get(position).rating)
        dbIntent.putExtra("numberOfPeopleRating",pl.get(position).numberOfPeopleRating)
        dbIntent.putExtra("setPrice",pl.get(position).setPrice)
        dbIntent.putExtra("roomPhotoImage",pl.get(position).roomPhotoImage)
        c.startService(dbIntent)
    }

    class ViewHolder(itemView: View,context:Context) : RecyclerView.ViewHolder(itemView) {

        val ctx = context

        // gets items from UI and bind them to  the specified val
        val mainTitle = itemView.findViewById<TextView>(R.id.mainTitle)
        val subTitle = itemView.findViewById<TextView>(R.id.subTitle)
        val mileage = itemView.findViewById<TextView>(R.id.mileage)
        val price = itemView.findViewById<TextView>(R.id.price)
        val limitedOffer = itemView.findViewById<TextView>(R.id.limitedOffer)
        val oldPrice = itemView.findViewById<TextView>(R.id.oldPrice)
        val perNight = itemView.findViewById<TextView>(R.id.perNight)
        val exceptional = itemView.findViewById<TextView>(R.id.exceptional)
        val rating = itemView.findViewById<TextView>(R.id.rating)
        val numberOfPeopleRating = itemView.findViewById<TextView>(R.id.numberOfPeopleRating)
        val setPrice = itemView.findViewById<TextView>(R.id.setPrice)
        val roomPhotoImage = itemView.findViewById<ImageView>(R.id.roomPhoto)
        val favoriteHeart = itemView.findViewById<ImageView>(R.id.favorite)

        fun bindItems(propertyList: PropertyList) {

            // binds data from data class to UI
           mainTitle.text = propertyList.mainTile
            subTitle.text = propertyList.subTitle
            mileage.text = propertyList.mileage
            price.text = propertyList.price
            exceptional.text = AppUtilities.ratingLevel(propertyList.rating!!.toDouble())
            rating.text = propertyList.rating
            numberOfPeopleRating.text = "(${propertyList.numberOfPeopleRating})"

            // set random color for prices and limited offer
           setRandomColors(price,ctx)

            //set OldPrice
            setOldPrice(oldPrice, price,limitedOffer, propertyList)

            // set Image
            setImage(roomPhotoImage,propertyList)

            //set Favorites
            setFavorites(favoriteHeart, propertyList)
        }

        private fun setFavorites(favoriteHeart: ImageView?, prop: PropertyList?) {
            val  title = prop?.mainTile.toString()

            val sharedPrefs  = this.ctx.applicationContext.getSharedPreferences("FavoriteChecker",Context.MODE_PRIVATE)

            if (sharedPrefs.contains(title)) {

                val getFavs = sharedPrefs.getBoolean(title, false)

                if (getFavs == true) {
                    favoriteHeart?.isActivated = true
                } else {
                    favoriteHeart?.isActivated = false
                }
            }
        }

        private fun setImage(roomPhotoImage: ImageView?, propertyList: PropertyList) {

            // set image on UI
            Glide.with(ctx)
                .load(propertyList.roomPhotoImage)
                .into(roomPhotoImage!!)
        }

        private fun setOldPrice(oldPrice: TextView?, price:TextView?, limitedOffer: TextView?, propertyList: PropertyList) {

            var op = propertyList.oldPrice
            var lmo = limitedOffer

            // set older price and add line through it
            if (op == "null"){
                oldPrice?.text = " "
            } else{
                oldPrice?.text = propertyList.oldPrice
                oldPrice?.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

                savedPercent(oldPrice?.text?.toString(), price?.text?.toString(), lmo)
            }
        }

        private fun savedPercent(oldPrice: String?, price: String?, limitedOffer: TextView?) {
            var op = oldPrice!!.substring(1,oldPrice!!.lastIndex).toInt()
            var p =  price!!.substring(1,price!!.lastIndex).toInt()

            var savedMoney = AppUtilities.savedMoney(op!!,p!!)

            if (savedMoney > 0) {
                limitedOffer?.visibility = View.VISIBLE
                limitedOffer?.text = "Save $savedMoney"
            }
        }

        private fun setRandomColors(tv: TextView, context:Context) {

            // set random percentage because there is no data from the server
            var colors = context.resources.getIntArray(R.array.randomcolorlist)
            var randomColor = colors[Random().nextInt(colors.size)]
            tv.setTextColor(randomColor)
        }

    }
}