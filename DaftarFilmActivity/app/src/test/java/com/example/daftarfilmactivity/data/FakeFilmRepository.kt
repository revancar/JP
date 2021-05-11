package com.example.daftarfilmactivity.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daftarfilmactivity.data.Film
import com.example.daftarfilmactivity.data.source.FilmDataSource
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.data.source.remote.RemoteDataSource
import com.example.daftarfilmactivity.data.source.remote.response.DetailResponse
import com.example.daftarfilmactivity.data.source.remote.response.MovieResponse
import com.example.daftarfilmactivity.data.source.remote.response.TvShowResponse

class FakeFilmRepository (private val remoteDataSource: RemoteDataSource): FilmDataSource {


    override fun getAllMovies(): LiveData<List<Film>> {
        val movieResult = MutableLiveData<List<Film>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val listMovies = java.util.ArrayList<Film>()
                for (response in movieResponse) {
                    val movies = Film(response.title,
                        response.date,
                        response.genre,
                        response.rating,
                        response.desc,
                        response.imgPath)

                    listMovies.add(movies)
                }
                movieResult.postValue(listMovies)
            }
        })

        return movieResult
    }

    override fun getMoviesDetail(movie: String): LiveData<Film> {
        val movieDetailResult = MutableLiveData<Film>()

        remoteDataSource.getDetailMovies(movie, object : RemoteDataSource.LoadDetailMoviesCallback{
            override fun onAllMoviesDetailReceived(moviesDetailResponse: List<DetailResponse>) {
                lateinit var listMovies: Film
                for (response in moviesDetailResponse) {
                    if (response.title == movie){
                        listMovies = Film(response.title,
                            response.date,
                            response.genre,
                            response.rating,
                            response.desc,
                            response.imgPath)

                        movieDetailResult.postValue(listMovies)
                    }
                }
            }
        })


        return movieDetailResult
    }

    override fun getAllTvShows(): LiveData<List<Film>> {
        val tvShowResult = MutableLiveData<List<Film>>()

        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback{
            override fun onAllTvShowsReceived(tvShowResponse: List<TvShowResponse>) {
                val listTvShows = java.util.ArrayList<Film>()
                for (response in tvShowResponse) {
                    val tvShows = Film(response.title,
                        response.date,
                        response.genre,
                        response.rating,
                        response.desc,
                        response.imgPath)

                    listTvShows.add(tvShows)
                }
                tvShowResult.postValue(listTvShows)
            }
        })

        return tvShowResult
    }

    override fun getTvShowsDetail(tvShow: String): LiveData<Film> {
        val tvShowDetailResult = MutableLiveData<Film>()

        remoteDataSource.getDetailTvShows(tvShow, object : RemoteDataSource.LoadDetailTvShowsCallback{
            override fun onAllTvShowsDetailReceived(tvShowDetailResponse: List<DetailResponse>) {
                lateinit var listTvShow: Film
                for (response in tvShowDetailResponse) {
                    if (response.title == tvShow){
                        listTvShow = Film(response.title,
                            response.date,
                            response.genre,
                            response.rating,
                            response.desc,
                            response.imgPath)

                        tvShowDetailResult.postValue(listTvShow)
                    }

                }
            }
        })


        return tvShowDetailResult
    }

}