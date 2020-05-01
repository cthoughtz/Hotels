package com.example.hotel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotel.model.HotelDetailsResponse
import com.example.hotel.model.HotelListResponse
import com.example.hotel.model.HotelPhotosResponse
import com.example.hotel.model.SearchResponse
import com.example.hotel.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class AppViewModel: ViewModel() {

    val hotelDetails = MutableLiveData<HotelDetailsResponse>()
    val hotelList = MutableLiveData<HotelListResponse>()
    val hotelPhoto = MutableLiveData<HotelPhotosResponse>()
    val hotelSearches = MutableLiveData<SearchResponse>()

    private var disposable: Disposable? = null
    val apiResponse = ApiService()

    fun fetchHotelDetails(){

        disposable = apiResponse.getHotelDetails()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                hotelDetails.value = it
            },{error ->
                Timber.d(error.message,"Hotel Details Error")
            })
    }

    fun fetchHotelList(currency:String,locale:String,sortOrder:String,destinationId:String, pageNumber:String, checkin:String, checkout:String, pageSize:String, adult:String){

        disposable = apiResponse.getHotelList(currency,locale,sortOrder,destinationId,pageNumber,checkin,checkout,pageSize,adult)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                hotelList.value = it
            },{error ->
                Timber.d(error.message,"Hotel List Error")
            })
    }

    fun fetchHotelPhotos(search: Int){

        disposable = apiResponse.getHotelPhotos(search)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                hotelPhoto.value = it
            },{ error->
                Timber.d(error.message,"Hotel Photos Error")
            })
    }

    fun fetchSearchResult(search: String){

        disposable = apiResponse.searchResults(search)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                hotelSearches.value = it
            },{error->
                Timber.d(error.message,"Search Result Error")
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}