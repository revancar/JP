package com.example.daftarfilmactivity.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity

class TvShowFavViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getFavTvShows(): LiveData<PagedList<TvShowEntity>> = filmRepository.getFavTvShows()

    fun setFavTvShows(tvShow: TvShowEntity){
        val newState = !tvShow.favorite
        filmRepository.setFavTvShows(tvShow, newState)
    }
}