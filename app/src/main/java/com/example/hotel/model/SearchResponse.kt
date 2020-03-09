package com.example.hotel.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("term")
    val term: String?,
    @SerializedName("moresuggestions")
    val moresuggestions: Int?,
    @SerializedName("autoSuggestInstance")
    val autoSuggestInstance: Any?,
    @SerializedName("trackingID")
    val trackingID: String?,
    @SerializedName("misspellingfallback")
    val misspellingfallback: Boolean?,
    @SerializedName("suggestions")
    val suggestions: List<Suggestion?>?
) {
    data class Suggestion(
        @SerializedName("group")
        val group: String?,
        @SerializedName("entities")
        val entities: List<Entity?>?
    ) {
        data class Entity(
            @SerializedName("geoId")
            val geoId: String?,
            @SerializedName("destinationId")
            val destinationId: String?,
            @SerializedName("type")
            val type: String?,
            @SerializedName("caption")
            val caption: String?,
            @SerializedName("redirectPage")
            val redirectPage: String?,
            @SerializedName("latitude")
            val latitude: Double?,
            @SerializedName("longitude")
            val longitude: Double?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("landmarkCityDestinationId")
            val landmarkCityDestinationId: Any?
        )
    }
}