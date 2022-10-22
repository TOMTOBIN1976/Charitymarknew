package org.wit.charitymark.models
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class CharitymarkModel(var title: String = "",
                            var description: String = "") : Parcelable
