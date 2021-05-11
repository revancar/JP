package com.example.daftarfilmactivity.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.daftarfilmactivity.data.Film
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.example.daftarfilmactivity.vo.Resource

interface FilmDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getMoviesDetail(movieId: String): LiveData<Resource<MovieEntity>>
    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>
    fun getTvShowsDetail(tvShowId: String): LiveData<Resource<TvShowEntity>>
    fun getFavMovies(): LiveData<PagedList<MovieEntity>>
    fun getFavTvShows(): LiveData<PagedList<TvShowEntity>>
    fun setFavMovies(movie: MovieEntity, state: Boolean)
    fun setFavTvShows(tvShow: TvShowEntity, state: Boolean)

}