package org.wit.charitymark.models

import timber.log.Timber.i

class CharitymarkMemStore : CharitymarkStore {

    val charitymarks = ArrayList<CharitymarkModel>()

    override fun findAll(): List<CharitymarkModel> {
        return charitymarks
    }

    override fun create(charitymark: CharitymarkModel) {
        charitymarks.add(charitymark)
    }

    fun logAll() {
        charitymarks.forEach{ i("${it}") }
    }
}