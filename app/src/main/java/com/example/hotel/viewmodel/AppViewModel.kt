package com.example.hotel.viewmodel

import HotelDetailsResponse
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    fun fetchHotelList(){

        disposable = apiResponse.getHotelList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                hotelList.value = it
            },{error ->
                Timber.d(error.message,"Hotel List Error")
            })
    }

    fun fetchHotelPhotos(){

        disposable = apiResponse.getHotelPhotos()
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