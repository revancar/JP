package com.example.daftarfilmactivity.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.daftarfilmactivity.data.Film
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.utils.DataFilm
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
    private val movies = dummyMovies.title
    private val tvShow = dummyTvShow.title

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Film>


    @Before
    fun setUp(){
        viewModelDetail = ViewModelDetail(filmRepository)
        viewModelDetail.setSelectedMovies(movies)
        viewModelDetail.setSelectedTvShow(tvShow)
    }

    //menguji apakah semua data sesuai dan data tidak null
    @Test
    fun getSelectedTvShow() {
        val tvShowLive = MutableLiveData<Film>()
        tvShowLive.value = dummyTvShow

        `when`(filmRepository.getTvShowsDetail(tvShow)).thenReturn(tvShowLive)
        viewModelDetail.setSelectedMovies(dummyTvShow.title)
        val tvShowEntities = viewModelDetail.getSelectedTvShow().value as Film
        Mockito.verify(filmRepository, times(1)).getTvShowsDetail(tvShow)
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.title, tvShowEntities?.title)
        assertEquals(dummyTvShow.date, tvShowEntities?.date)
        assertEquals(dummyTvShow.genre, tvShowEntities?.genre)
        assertEquals(dummyTvShow.rating, tvShowEntities?.rating)
        assertEquals(dummyTvShow.desc, tvShowEntities?.desc)
        assertEquals(dummyTvShow.imgPath, tvShowEntities?.imgPath)

        viewModelDetail.getSelectedTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }

    //menguji apakah semua data sesuai dan data tidak null
    @Test
    fun getSelectedMovies() {
        val moviesLive = MutableLiveData<Film>()
        moviesLive.value = dummyMovies

        `when`(filmRepository.getMoviesDetail(movies)).thenReturn(moviesLive)
        viewModelDetail.setSelectedTvShow(dummyMovies.title)
        val moviesEntities = viewModelDetail.getSelectedMovies().value as Film
        verify(filmRepository, times(1)).getMoviesDetail(movies)
        assertNotNull(moviesEntities)
        assertEquals(dummyMovies.title, moviesEntities?.title)
        assertEquals(dummyMovies.date, moviesEntities?.date)
        assertEquals(dummyMovies.genre, moviesEntities?.genre)
        assertEquals(dummyMovies.rating, moviesEntities?.rating)
        assertEquals(dummyMovies.desc, moviesEntities?.desc)
        assertEquals(dummyMovies.imgPath, moviesEntities?.imgPath)

        viewModelDetail.getSelectedMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}