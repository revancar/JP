package com.example.daftarfilmactivity.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.daftarfilmactivity.data.Film
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.data.source.local.LocalDataSource
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.example.daftarfilmactivity.data.source.local.room.FilmDao
import com.example.daftarfilmactivity.utils.DataFilm
import com.example.daftarfilmactivity.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ViewModelDetailTest {
    private lateinit var viewModelDetail: ViewModelDetail
    private val dummyMovies = DataFilm.generateDummyFilm()[0]
    private val dummyTvShow = DataFilm.generateDummyTv()[0]
    private val movies = dummyMovies.movieId
    private val tvShow = dummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<Resource<TvShowEntity>>


    @Before
    fun setUp(){
        viewModelDetail = ViewModelDetail(filmRepository)
        viewModelDetail.setSelectedMovies(movies)
        viewModelDetail.setSelectedTvShow(tvShow)
    }

    //menguji apakah semua data sesuai dan data tidak null
    @Test
    fun getSelectedTvShow() {
        val tvShowLive = MutableLiveData<Resource<TvShowEntity>>()
        tvShowLive.value = Resource.success(dummyTvShow)


        `when`(filmRepository.getTvShowsDetail(tvShow)).thenReturn(tvShowLive)
        viewModelDetail.getSelectedTvShow.observeForever(observerTvShow)
        verify(observerTvShow).onChanged(tvShowLive.value)

        val tvShowValue = tvShowLive.value
        val actualValue = viewModelDetail.getSelectedTvShow.value

        assertEquals(tvShowValue, actualValue)

    }

    //menguji apakah semua data sesuai dan data tidak null
    @Test
    fun getSelectedMovies() {
        val moviesLive = MutableLiveData<Resource<MovieEntity>>()
        moviesLive.value = Resource.success(dummyMovies)


        `when`(filmRepository.getMoviesDetail(movies)).thenReturn(moviesLive)
        viewModelDetail.getSelectedMovies.observeForever(observerMovie)
        verify(observerMovie).onChanged(moviesLive.value)

        val moviesValue = moviesLive.value
        val actualValue = viewModelDetail.getSelectedMovies.value

        assertEquals(moviesValue,actualValue)


    }

    @Test
    fun setFavMovie(){

        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(DataFilm.generateMovieFav(dummyMovies, true))

        `when`(filmRepository.getMoviesDetail(movies)).thenReturn(expected)

        viewModelDetail.setFavMovie()
        viewModelDetail.getSelectedMovies.observeForever(observerMovie)

        verify(observerMovie).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModelDetail.getSelectedMovies.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun setFavTvShow(){

        val expected = MutableLiveData<Resource<TvShowEntity>>()
        expected.value = Resource.success(DataFilm.generateTvShowFav(dummyTvShow, true))

        `when`(filmRepository.getTvShowsDetail(tvShow)).thenReturn(expected)

        viewModelDetail.setFavTvShow()
        viewModelDetail.getSelectedTvShow.observeForever(observerTvShow)

        verify(observerTvShow).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModelDetail.getSelectedTvShow.value

        assertEquals(expectedValue, actualValue)

    }

}