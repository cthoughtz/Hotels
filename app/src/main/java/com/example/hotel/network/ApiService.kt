package com.example.hotel.network

import HotelDetailsResponse
import com.example.hotel.model.HotelListResponse
import com.example.hotel.model.HotelPhotosResponse
import com.example.hotel.model.SearchResponse
import com.example.hotel.network.PostApi.postApi
import com.google.gson.GsonBuilder
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object PostApi{

    val baseUrl = "https://hotels4.p.rapidapi.com"

    private val loggingInterceptor = HttpLoggingInterceptor()
        .also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .readTimeout(30,TimeUnit.SECONDS)
        .connectTimeout(30,TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

    val postApi: ApiClient by lazy{
        retrofit.create(ApiClient::class.java)
    }
}

class ApiService(): ApiClient{
    override fun searchResults(query: String?): Flowable<SearchResponse?>? {

        return postApi.searchResults(query = "New York")
    }

    override fun getHotelPhotos(): Flowable<HotelPhotosResponse> {

        return  postApi.getHotelPhotos()
    }

    override fun getHotelDetails(): Flowable<HotelDetailsResponse> {

        return postApi.getHotelDetails()
    }

    override fun getHotelList(): Flowable<HotelListResponse> {

        return postApi.getHotelList()
    }

}