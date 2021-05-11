package com.example.daftarfilmactivity.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.daftarfilmactivity.data.Film
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.utils.DataFilm
import com.example.daftarfilmactivity.vo.Resource

class MoviesViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = filmRepository.getAllMovies()

}