package org.wit.charitymark.models

interface CharitymarkStore {
    fun findAll(): List<CharitymarkModel>
    fun create(charitymark: CharitymarkModel)
    fun update(charitymark: CharitymarkModel)
}