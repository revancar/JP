package com.example.daftarfilmactivity.data.source.remote

import android.os.Looper
import com.example.daftarfilmactivity.data.source.remote.response.DetailResponse
import com.example.daftarfilmactivity.data.source.remote.response.MovieResponse
import com.example.daftarfilmactivity.data.source.remote.response.TvShowResponse
import com.example.daftarfilmactivity.utils.jsonHelper
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daftarfilmactivity.utils.EspressoIdlingResource

class RemoteDataSource private constructor(private val jsonHelper: jsonHelper){

    private val handler = Handler(Looper.getMainLooper())


    companion object{
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instanse: RemoteDataSource? = null

        fun getInstance(helper: jsonHelper): RemoteDataSource =
            instanse ?: synchronized(this){
                instanse ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>>{
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({resultMovies.value = ApiResponse.success(jsonHelper.loadMovies())
                            EspressoIdlingResource.decrement() }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovies
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvShowResponse>>>{
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        handler.postDelayed({resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShows())
                            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }

    fun getDetailMovies(movieId: String): LiveData<ApiResponse<MovieResponse>>{
        EspressoIdlingResource.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<MovieResponse>>()
        handler.postDelayed({ val movies = jsonHelper.loadDetailMovies(movieId)

                            for (response in movies){
                                if (response.movieId == movieId){
                                    val movieResult = MovieResponse(response.movieId,
                                    response.title,
                                    response.date,
                                    response.genre,
                                    response.rating,
                                    response.desc,
                                    response.imgPath,
                                    false)
                                    resultDetailMovie.value = ApiResponse.success(movieResult)
                                }
                            }
                            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
        return resultDetailMovie
    }

    fun getDetailTvShows(tvShowId: String): LiveData<ApiResponse<TvShowResponse>>{
        EspressoIdlingResource.increment()
        val resultDetailTvShows = MutableLiveData<ApiResponse<TvShowResponse>>()
        handler.postDelayed({val tvShows = jsonHelper.loadDetailTvShows(tvShowId)

                            for (response in tvShows) {
                                if (response.tvShowId == tvShowId){
                                    val tvShowResult = TvShowResponse(response.tvShowId,
                                    response.title,
                                    response.date,
                                    response.genre,
                                    response.rating,
                                    response.desc,
                                    response.imgPath,
                                    false)
                                    resultDetailTvShows.value = ApiResponse.success(tvShowResult)
                                }
                            }
                            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
        return resultDetailTvShows
    }


}