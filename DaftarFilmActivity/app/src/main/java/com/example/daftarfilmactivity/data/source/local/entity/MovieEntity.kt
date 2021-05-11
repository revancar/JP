package com.example.daftarfilmactivity.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_movie")
@Parcelize
data class MovieEntity (

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "desc")
    var desc: String,

    @ColumnInfo(name = "imgPath")
    var imgPath: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false

):Parcelable