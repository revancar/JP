package com.example.daftarfilmactivity.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity

@Dao
interface FilmDao {

    @Query("SELECT * FROM tb_movie")
    fun getAllMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tb_tvshow")
    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tb_movie WHERE favorite = 1")
    fun getMovieFav(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tb_tvshow WHERE favorite = 1")
    fun getTvShowsFav(): DataSource.Factory<Int, TvShowEntity>

    @Transaction
    @Query("SELECT * FROM tb_movie WHERE movieId = :movieId")
    fun getMovieDetail(movieId: String): LiveData<MovieEntity>

    @Transaction
    @Query("SELECT * FROM tb_tvshow WHERE tvShowId = :tvShowId")
    fun getTvShowDetail(tvShowId: String): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)


}