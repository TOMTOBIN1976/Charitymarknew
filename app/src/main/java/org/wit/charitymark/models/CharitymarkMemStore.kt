package org.wit.charitymark.models

import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class CharitymarkMemStore : CharitymarkStore {

    val charitymarks = ArrayList<CharitymarkModel>()

    override fun findAll(): List<CharitymarkModel> {
        return charitymarks
    }

    override fun create(placemark: CharitymarkModel) {
        placemark.id = getId()
        charitymarks.add(placemark)
        logAll()
    }

    override fun update(placemark: CharitymarkModel) {
        var foundPlacemark: CharitymarkModel? = charitymarks.find { p -> p.id == placemark.id }
        if (foundPlacemark != null) {
            foundPlacemark.title = placemark.title
            foundPlacemark.description = placemark.description
            logAll()
        }
    }

    private fun logAll() {
        charitymarks.forEach { i("$it") }
    }
}