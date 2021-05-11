package com.example.daftarfilmactivity.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.di.injection
import com.example.daftarfilmactivity.ui.detail.ViewModelDetail
import com.example.daftarfilmactivity.ui.favorite.MoviesFavViewModel
import com.example.daftarfilmactivity.ui.favorite.TvShowFavViewModel
import com.example.daftarfilmactivity.ui.home.MoviesViewModel
import com.example.daftarfilmactivity.ui.home.TvShowViewModel

class ViewModelFactory private constructor(private val mFilmRepository: FilmRepository): ViewModelProvider.NewInstanceFactory(){

    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(mFilmRepository) as T
            }

            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mFilmRepository) as T
            }

            modelClass.isAssignableFrom(ViewModelDetail::class.java) -> {
                return ViewModelDetail(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(MoviesFavViewModel::class.java) -> {
                return MoviesFavViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(TvShowFavViewModel::class.java) -> {
                return TvShowFavViewModel(mFilmRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class: " + modelClass.name)
        }
    }

}