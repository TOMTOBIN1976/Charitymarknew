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

    override fun create(charitymark: CharitymarkModel) {
        charitymark.id = getId()
        charitymarks.add(charitymark)
        logAll()
    }
// Update function - used in editing
    override fun update(charitymark: CharitymarkModel) {
        var foundCharitymark: CharitymarkModel? = charitymarks.find { p -> p.id == charitymark.id }
        if (foundCharitymark != null) {
            foundCharitymark.title = charitymark.title
            foundCharitymark.description = charitymark.description
            foundCharitymark.image = charitymark.image
            foundCharitymark.lat = charitymark.lat
            foundCharitymark.lng = charitymark.lng
            foundCharitymark.zoom = charitymark.zoom
            logAll()
        }
    }

    private fun logAll() {
        charitymarks.forEach { i("$it") }
    }
}