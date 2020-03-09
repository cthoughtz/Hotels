package com.example.hotel.model

import com.google.gson.annotations.SerializedName

data class HotelPhotosResponse(
    @SerializedName("hotelId")
    val hotelId: Int?,
    @SerializedName("hotelImages")
    val hotelImages: List<HotelImage?>?,
    @SerializedName("roomImages")
    val roomImages: List<RoomImage?>?,
    @SerializedName("featuredImageTrackingDetails")
    val featuredImageTrackingDetails: FeaturedImageTrackingDetails?,
    @SerializedName("propertyImageTrackingDetails")
    val propertyImageTrackingDetails: PropertyImageTrackingDetails?
) {
    data class HotelImage(
        @SerializedName("baseUrl")
        val baseUrl: String?,
        @SerializedName("imageId")
        val imageId: Int?,
        @SerializedName("mediaGUID")
        val mediaGUID: String?,
        @SerializedName("sizes")
        val sizes: List<Size?>?
    ) {
        data class Size(
            @SerializedName("type")
            val type: Int?,
            @SerializedName("suffix")
            val suffix: String?
        )
    }

    data class RoomImage(
        @SerializedName("roomId")
        val roomId: Int?,
        @SerializedName("images")
        val images: List<Image?>?
    ) {
        data class Image(
            @SerializedName("baseUrl")
            val baseUrl: String?,
            @SerializedName("imageId")
            val imageId: Int?,
            @SerializedName("mediaGUID")
            val mediaGUID: String?,
            @SerializedName("sizes")
            val sizes: List<Size?>?
        ) {
            data class Size(
                @SerializedName("type")
                val type: Int?,
                @SerializedName("suffix")
                val suffix: String?
            )
        }
    }

    data class FeaturedImageTrackingDetails(
        @SerializedName("version")
        val version: String?,
        @SerializedName("namespace")
        val namespace: String?,
        @SerializedName("algorithmName")
        val algorithmName: String?
    )

    data class PropertyImageTrackingDetails(
        @SerializedName("version")
        val version: String?,
        @SerializedName("namespace")
        val namespace: String?,
        @SerializedName("algorithmName")
        val algorithmName: String?
    )
}