package org.wit.charitymark.models
import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize

data class CharitymarkModel(var id: Long = 0,
                            var title: String = "",
                            var description: String = "",
                            var eventdate: String = "",
                            var eventcounty: String = "",
                            var image: Uri = Uri.EMPTY,
                            var lat : Double = 0.0,
                            var lng: Double = 0.0,
                            var zoom: Float = 0f) : Parcelable

@Parcelize
data class Location(var lat: Double = 0.0,
                    var lng: Double = 0.0,
                    var zoom: Float = 0f) : Parcelable
