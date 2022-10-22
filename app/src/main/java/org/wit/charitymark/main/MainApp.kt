package org.wit.charitymark.main

import android.app.Application
import org.wit.charitymark.models.CharitymarkModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val charitymarks = ArrayList<CharitymarkModel>()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Placemark started")
        //charitymarks.add(CharitymarkModel("One", "About one..."))
        //charitymarks.add(CharitymarkModel("Two", "About two..."))
        //charitymarks.add(CharitymarkModel("Three", "About three..."))
    }
}