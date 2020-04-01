package com.example.hotel.network

import com.example.hotel.model.HotelDetailsResponse
import com.example.hotel.model.HotelListResponse
import com.example.hotel.model.HotelPhotosResponse
import com.example.hotel.model.SearchResponse
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiClient{

    @Headers("x-rapidapi-host: hotels4.p.rapidapi.com",
                    "x-rapidapi-key: fdb24db5eemsh90362d2616f25ebp135e27jsne4972d8c39bc")
    @GET("/locations/search?locale-en_US&")
    fun searchResults(@Query("query") query: String?): Flowable<SearchResponse?>?


    @Headers("x-rapidapi-host: hotels4.p.rapidapi.com",
                    "x-rapidapi-key: fdb24db5eemsh90362d2616f25ebp135e27jsne4972d8c39bc")
    @GET("/properties/get-hotel-photos")
    fun getHotelPhotos():Single<HotelPhotosResponse>

    @Headers("x-rapidapi-host: hotels4.p.rapidapi.com",
                    "x-rapidapi-key: fdb24db5eemsh90362d2616f25ebp135e27jsne4972d8c39bc")
    @GET("/properties/list")
    fun getHotelList():Single<HotelListResponse>

    @Headers("x-rapidapi-host: hotels4.p.rapidapi.com",
        "x-rapidapi-key: fdb24db5eemsh90362d2616f25ebp135e27jsne4972d8c39bc")
    @GET("/properties/get-details")
    fun getHotelDetails():Single<HotelDetailsResponse>
}