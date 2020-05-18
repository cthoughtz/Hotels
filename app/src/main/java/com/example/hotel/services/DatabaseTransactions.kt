package com.example.hotel.services

import android.app.IntentService
import android.content.Context
import android.content.Intent
import com.example.hotel.RoomDataBase.AppDatabase
import com.example.hotel.model.RoomEntities.PropertyListEntity
import com.example.hotel.view.Activities.BaseApplication

class DatabaseTransactions : IntentService("DatabaseTransactions") {

    //initialize  Database
    val db: AppDatabase by lazy{
        BaseApplication.appDb
    }

    override fun onHandleIntent(intent: Intent?) {

        // Get intent Extra
        val parmInent = intent?.getStringExtra("insert") ?: "delete"

        when (parmInent) {
            "insert" -> {
                // insert items into database
                insertItems(intent!!)
            }
            "delete" -> {
                // Delete Items from database
                deleteItems(intent!!)
            }
        }
    }

    private fun deleteItems(intent: Intent) {

        // Get Intents for all the data to be deleted
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

        // Set boolean to false if it exist in shared preferences
        sharedPrefs(false,mainTitle)

        // If position from intent is not equal to false delete it from the database
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

        // Get Intents for all the data to be inserted
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

        // Set boolean to true if it exist in shared preferences
        sharedPrefs(true,mainTitle)

        // Insert all items into database
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

        // Add items to Shared preferences
        val prefs = getSharedPreferences("FavoriteChecker", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean(position,boolean)
        editor.commit()
    }

}
