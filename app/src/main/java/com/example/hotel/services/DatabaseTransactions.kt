package com.example.hotel.services

import android.app.IntentService
import android.content.Context
import android.content.Intent
import com.example.hotel.RoomDataBase.AppDatabase
import com.example.hotel.model.RoomEntities.PropertyListEntity
import com.example.hotel.view.Activities.BaseApplication

class DatabaseTransactions : IntentService("DatabaseTransactions") {

    val db: AppDatabase by lazy{
        BaseApplication.appDb
    }

    override fun onHandleIntent(intent: Intent?) {

        val parmInent = intent?.getStringExtra("insert") ?: "delete"

        when (parmInent) {
            "insert" -> {

                insertItems(intent!!)
            }
            "delete" -> {
                deleteItems(intent!!)
            }
        }
    }

    private fun deleteItems(intent: Intent) {
        val position = intent.getStringExtra("position") ?: "null"
        val mainTitle = intent.getStringExtra("mainTitle")
        val subTitle = intent.getStringExtra("subTitle")
        val mileage = intent.getStringExtra("mileage")
        val price = intent.getStringExtra("price")
        val limitedOffer = intent.getStringExtra("limitedOffer")
        val oldPrice = intent.getStringExtra("oldPrice")
        val exceptional = intent.getStringExtra("exceptional")
        val rating = intent.getStringExtra("rating")
        val numberOfPeopleRating = intent.getStringExtra("numberOfPeopleRating")
        val setPrice = intent.getStringExtra("setPrice")
        val roomPhoto = intent.getStringExtra("roomPhotoImage")

        sharedPrefs(false,position)

        if (position != null) {
            db.propListDao().delete(
                PropertyListEntity(
                    position.toInt(),
                    mainTitle,
                    subTitle,
                    mileage,
                    price,
                    limitedOffer,
                    oldPrice,
                    exceptional,
                    rating,
                    numberOfPeopleRating,
                    setPrice,
                    roomPhoto
                )
            )
        }

    }

    private fun insertItems(intent: Intent) {

        val position = intent.getStringExtra("position")
        val mainTitle = intent.getStringExtra("mainTitle")
        val subTitle = intent.getStringExtra("subTitle")
        val mileage = intent.getStringExtra("mileage")
        val price = intent.getStringExtra("price")
        val limitedOffer = intent.getStringExtra("limitedOffer")
        val oldPrice = intent.getStringExtra("oldPrice")
        val exceptional = intent.getStringExtra("exceptional")
        val rating = intent.getStringExtra("rating")
        val numberOfPeopleRating = intent.getStringExtra("numberOfPeopleRating")
        val setPrice = intent.getStringExtra("setPrice")
        val roomPhoto = intent.getStringExtra("roomPhotoImage")

        sharedPrefs(true,mainTitle)

        db.propListDao().insertAll(
            PropertyListEntity(
                position.toInt(),
                mainTitle,
                subTitle,
                mileage,
                price,
                limitedOffer,
                oldPrice,
                exceptional,
                rating,
                numberOfPeopleRating,
                setPrice,
                roomPhoto
            ))
    }

    fun sharedPrefs(boolean: Boolean, position: String){

        val prefs = getSharedPreferences("FavoriteChecker", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean(position,boolean)
        editor.commit()
    }

}
