package com.example.daftarfilmactivity.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.daftarfilmactivity.data.Film
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.example.daftarfilmactivity.utils.DataFilm
import com.example.daftarfilmactivity.vo.Resource

class TvShowViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = filmRepository.getAllTvShows()

}