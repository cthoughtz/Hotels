package com.example.hotel.model.RoomEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Propertylisttable")
data class PropertyListEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo
    var mainTile:String? = null,
    @ColumnInfo
    var subTitle:String? = null,
    @ColumnInfo
    var mileage:String? = null,
    @ColumnInfo
    var price:String? = null,
    @ColumnInfo
    var limitedOffer:String? = null,
    @ColumnInfo
    var oldPrice:String? = null,
    @ColumnInfo
    var exceptional:String? = null,
    @ColumnInfo
    var rating:String? = null,
    @ColumnInfo
    var numberOfPeopleRating:String? = null,
    @ColumnInfo
    var setPrice:String? = null,
    @ColumnInfo
    var roomPhotoImage: String? = null
)