package org.wit.charitymark.main

import android.app.Application
import org.wit.charitymark.models.CharitymarkMemStore
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {
    //Using memory store now
    //val charitymarks = ArrayList<CharitymarkModel>()
    val charitymarks = CharitymarkMemStore()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Charitymark started")
    }
}