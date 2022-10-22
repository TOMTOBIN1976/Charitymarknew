package org.wit.charitymark.models
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class CharitymarkModel(var id: Long = 0,
                            var title: String = "",
                            var description: String = "") : Parcelable
