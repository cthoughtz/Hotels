package com.example.hotel.RoomDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hotel.interfaces.RoomDao.PropertyListDao
import com.example.hotel.model.RoomEntities.PropertyListEntity

@Database(entities = arrayOf(PropertyListEntity::class), version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun propListDao(): PropertyListDao
}