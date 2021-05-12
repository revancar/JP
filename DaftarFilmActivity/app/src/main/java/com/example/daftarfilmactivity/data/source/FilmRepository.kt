package com.example.daftarfilmactivity.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.daftarfilmactivity.data.Film
import com.example.daftarfilmactivity.data.NetworkBoundResource
import com.example.daftarfilmactivity.data.source.local.LocalDataSource
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.example.daftarfilmactivity.data.source.remote.ApiResponse
import com.example.daftarfilmactivity.data.source.remote.RemoteDataSource
import com.example.daftarfilmactivity.data.source.remote.response.DetailResponse
import com.example.daftarfilmactivity.data.source.remote.response.MovieResponse
import com.example.daftarfilmactivity.data.source.remote.response.TvShowResponse
import com.example.daftarfilmactivity.utils.AppExecutors
import com.example.daftarfilmactivity.vo.Resource

class FilmRepository private constructor(private val remoteDataSource: RemoteDataSource,
private val localDataSource: LocalDataSource,
private val appExecutors: AppExecutors): FilmDataSource{

    companion object {
        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): FilmRepository =
            instance ?: synchronized(this){
                instance ?: FilmRepository(remoteDataSource, localData, appExecutors).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>>{
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(movieResponse: List<MovieResponse>) {
                val listMovies = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val movies = MovieEntity(
                        response.movieId,
                        response.title,
                        response.date,
                        response.genre,
                        response.rating,
                        response.desc,
                        response.imgPath,
                        false
                    )

                    listMovies.add(movies)
                }

                localDataSource.insertMovies(listMovies)

            }

        }.asLiveData()


    }

    override fun getMoviesDetail(movieId: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieResponse>(appExecutors){
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieDetail(movieId)

            override fun shouldFetch(movie: MovieEntity?): Boolean =
                movie?.movieId == null

            override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getDetailMovies(movieId)

            override fun saveCallResult(response: MovieResponse) {
                    val movies = MovieEntity(response.movieId,
                    response.title,
                    response.date,
                    response.genre,
                    response.rating,
                    response.desc,
                    response.imgPath,
                    false)
                    localDataSource.updateMovie(movies)

            }
        }.asLiveData()
    }



    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean  =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(tvShowResponse: List<TvShowResponse>) {
                val listTvShows = ArrayList<TvShowEntity>()
                for (response in tvShowResponse) {
                    val tvShows = TvShowEntity(
                        response.tvShowId,
                        response.title,
                        response.date,
                        response.genre,
                        response.rating,
                        response.desc,
                        response.imgPath,
                        false
                        )

                    listTvShows.add(tvShows)
                }

                localDataSource.insertTvShows(listTvShows)
            }
        }.asLiveData()

    }

    override fun getTvShowsDetail(tvShowId: String): LiveData<Resource<TvShowEntity>>{
        return object : NetworkBoundResource<TvShowEntity, TvShowResponse>(appExecutors){
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getTvShowDetail(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data?.tvShowId == null

            override fun createCall(): LiveData<ApiResponse<TvShowResponse>> =
                remoteDataSource.getDetailTvShows(tvShowId)

            override fun saveCallResult(response: TvShowResponse) {
                    val tvShows = TvShowEntity(response.tvShowId,
                    response.title,
                    response.date,
                    response.genre,
                    response.rating,
                    response.desc,
                    response.imgPath,
                    false)

                    localDataSource.updateTvShow(tvShows)

            }
        }.asLiveData()
    }

    override fun getFavMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()
        return LivePagedListBuilder(localDataSource.getFavMovie(), config).build()
    }

    override fun getFavTvShows(): LiveData<PagedList<TvShowEntity>>{
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()
        return LivePagedListBuilder(localDataSource.getFavTvShow(), config).build()
    }

    override fun setFavMovies(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavMovie(movie, state) }
    }

    override fun setFavTvShows(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavTvShow(tvShow,state) }
    }

}