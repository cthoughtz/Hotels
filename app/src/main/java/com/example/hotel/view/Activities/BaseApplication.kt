package com.example.hotel.view.Activities

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.room.Room
import com.example.hotel.RoomDataBase.AppDatabase

class BaseApplication: Application() {

    companion object{

        var instance= BaseApplication()
        val appDb: AppDatabase by lazy {
            Room.databaseBuilder(
                instance,
                AppDatabase::class.java,
                "database"
            ).build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}