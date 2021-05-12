package com.example.daftarfilmactivity.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity

class MoviesFavViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getFavMovies(): LiveData<PagedList<MovieEntity>> = filmRepository.getFavMovies()

    fun setFavMovies(movie: MovieEntity) {
        val newState = !movie.favorite
        filmRepository.setFavMovies(movie, newState)
    }
}