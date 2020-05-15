package com.example.hotel.interfaces.RoomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.hotel.model.RoomEntities.PropertyListEntity

@Dao
interface PropertyListDao{

    @Query("SELECT * FROM propertylisttable")
    fun getAll(): List<PropertyListEntity>

    @Insert
    fun insert(item: PropertyListEntity)

    @Insert
    fun insertAll(vararg insertAll: PropertyListEntity)

    @Delete
    fun delete(item: PropertyListEntity)

    @Delete
    fun deleteAll(item: List<PropertyListEntity>)

}