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

    override fun update(charitymark: CharitymarkModel) {
        var foundCharityark: CharitymarkModel? = charitymarks.find { p -> p.id == charitymark.id }
        if (foundCharityark != null) {
            foundCharityark.title = charitymark.title
            foundCharityark.description = charitymark.description
            logAll()
        }
    }

    private fun logAll() {
        charitymarks.forEach { i("$it") }
    }
}