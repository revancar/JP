package com.example.daftarfilmactivity.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailResponse (
    var filmId: String,
    var title: String,
    var date: String,
    var genre: String,
    var rating: String,
    var desc: String,
    var imgPath: String,
    var favorite: Boolean = false
):Parcelable