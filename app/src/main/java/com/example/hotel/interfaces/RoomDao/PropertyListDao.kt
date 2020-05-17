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

    @Query("SELECT COUNT (*) FROM propertylisttable")
    fun getDataCount(): Int

    @Query("SELECT mainTile FROM propertylisttable")
    fun searchMainTitle():List<PropertyListEntity>

    @Query("SELECT mainTile FROM Propertylisttable WHERE mainTile =:name")
    fun searchMainTitleName(name: String):List<PropertyListEntity>

    @Insert
    fun insert(item: PropertyListEntity)

    @Insert
    fun insertAll(vararg insertAll: PropertyListEntity)

    @Delete
    fun delete(item: PropertyListEntity)

    @Delete
    fun deleteAll(item: List<PropertyListEntity>)

}