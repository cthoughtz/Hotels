package com.example.hotel.view.Activities

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}