package com.example.daftarfilmactivity.di

import android.content.Context
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.data.source.local.LocalDataSource
import com.example.daftarfilmactivity.data.source.local.room.FilmDatabase
import com.example.daftarfilmactivity.data.source.remote.RemoteDataSource
import com.example.daftarfilmactivity.utils.AppExecutors
import com.example.daftarfilmactivity.utils.jsonHelper

object injection {

    fun provideRepository(context: Context): FilmRepository {

        val database = FilmDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(jsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()

        return FilmRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

}