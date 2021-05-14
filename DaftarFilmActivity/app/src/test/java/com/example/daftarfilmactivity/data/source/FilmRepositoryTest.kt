package com.example.daftarfilmactivity.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.daftarfilmactivity.data.FakeFilmRepository
import com.example.daftarfilmactivity.data.source.local.LocalDataSource
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.example.daftarfilmactivity.data.source.remote.RemoteDataSource
import com.example.daftarfilmactivity.data.source.remote.response.DetailResponse
import com.example.daftarfilmactivity.data.source.remote.response.MovieResponse
import com.example.daftarfilmactivity.data.source.remote.response.TvShowResponse
import com.example.daftarfilmactivity.utils.*
import com.example.daftarfilmactivity.vo.Resource
//import com.nhaarman.mockitokotlin2.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val executor = mock(AppExecutors::class.java)
    private val filmRepository = FakeFilmRepository(remote, local, executor)

    private val movieResponse = DataFilm.generateRemoteDummyMovies()
    private val movieTitle = movieResponse[0].title
    private val tvShowResponse = DataFilm.generateRemoteDummyTvShows()
    private val tvShowTitle = tvShowResponse[0].title
    private val movie = DataFilm.generateDummyFilm()[0]
    private val tvShow = DataFilm.generateDummyTv()[0]

    @Test
    fun getAllMovies() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSource)
        filmRepository.getAllMovies()

        val moviesEntities = Resource.success(PagedListUtil.mockPagedList(DataFilm.generateDummyFilm()))
        verify(local).getAllMovies()
        assertNotNull(moviesEntities.data)
        assertEquals(movieResponse.size.toLong(), moviesEntities.data?.size?.toLong())
    }

    @Test
    fun getMoviesDetail() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movie
        `when`(local.getMovieDetail(movie.movieId)).thenReturn(dummyMovie)

        val resultMovie = LiveDataTestUtils.getValue(filmRepository.getMoviesDetail(movie.movieId))
        verify(local).getMovieDetail(movie.movieId)
        assertNotNull(resultMovie)
        assertEquals(movie.movieId, resultMovie.data?.movieId)
    }

    @Test
    fun getAllTvShows() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShows()).thenReturn(dataSource)
        filmRepository.getAllTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataFilm.generateDummyTv()))
        verify(local).getAllTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowsDetail() {
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = tvShow
        `when`(local.getTvShowDetail(tvShow.tvShowId)).thenReturn(dummyTvShow)

        val resultTvShow = LiveDataTestUtils.getValue(filmRepository.getTvShowsDetail(tvShow.tvShowId))
        verify(local).getTvShowDetail(tvShow.tvShowId)
        assertNotNull(resultTvShow)
        assertEquals(tvShow.tvShowId, resultTvShow.data?.tvShowId)
    }

    private val testExecutors: AppExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())
    @Test
    fun setFavMovie(){

        val dummyMovie: MovieEntity = DataFilm.generateDummyFilm()[0]
        val newState = !dummyMovie.favorite

        `when`(executor.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).setFavMovie(dummyMovie, newState)

        filmRepository.setFavMovies(dummyMovie, newState)
        verify(local, times(1)).setFavMovie(dummyMovie, newState)
    }

    @Test
    fun setFavTvShow(){

        val dummyTvShow: TvShowEntity = DataFilm.generateDummyTv()[0]
        val newState = !dummyTvShow.favorite

        `when`(executor.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).setFavTvShow(dummyTvShow, newState)

        filmRepository.setFavTvShows(dummyTvShow, newState)
        verify(local, times(1)).setFavTvShow(dummyTvShow, newState)

    }
}