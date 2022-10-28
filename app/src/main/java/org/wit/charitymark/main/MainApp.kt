package org.wit.charitymark.main

import android.app.Application
import org.wit.charitymark.models.CharitymarkJSONStore
import org.wit.charitymark.models.CharitymarkMemStore
import org.wit.charitymark.models.CharitymarkStore
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {
    //Using memory store now
    //val charitymarks = ArrayList<CharitymarkModel>()
    //val charitymarks = CharitymarkMemStore()

    lateinit var charitymarks: CharitymarkStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        //charitymarks = CharitymarkMemStore()
        charitymarks = CharitymarkJSONStore(applicationContext)
        i("Charitymark started")
    }
}