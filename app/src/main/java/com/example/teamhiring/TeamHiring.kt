package com.example.teamhiring

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class TeamHiring: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}