package com.example.daftarfilmactivity.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.example.daftarfilmactivity.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao){

    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getAllMovies()

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getAllTvShows()

    fun getMovieDetail(movieId: String) : LiveData<MovieEntity> = mFilmDao.getMovieDetail(movieId)

    fun getTvShowDetail(tvShowId: String) : LiveData<TvShowEntity> = mFilmDao.getTvShowDetail(tvShowId)

    fun getFavMovie(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getMovieFav()

    fun getFavTvShow(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getTvShowsFav()

    fun insertMovies(movies: List<MovieEntity>) = mFilmDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mFilmDao.insertTvShow(tvShows)

    fun setFavMovie(movies: MovieEntity, newState: Boolean){
        movies.favorite = newState
        mFilmDao.updateMovie(movies)
    }

    fun setFavTvShow(tvShows: TvShowEntity, newState: Boolean){
        tvShows.favorite = newState
        mFilmDao.updateTvShow(tvShows)
    }

    fun updateMovie(movies: MovieEntity){
        mFilmDao.updateMovie(movies)
    }

    fun updateTvShow(tvShows: TvShowEntity){
        mFilmDao.updateTvShow(tvShows)
    }



}