package com.example.daftarfilmactivity.ui.home

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
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<Film>>

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Before
    fun setUp(){
        viewModel = TvShowViewModel(filmRepository)
    }

    //menguji apakah semua data sesuai dengan size yang dikasih dan data tidak null
    @Test
    fun getTvShow() {
        val dummyTvShow = DataFilm.generateDummyTv()
        val tvShow = MutableLiveData<List<Film>>()
        tvShow.value = dummyTvShow


        `when`(filmRepository.getAllTvShows()).thenReturn(tvShow)
        val TvShowEntities = viewModel.getTvShow().value
        verify(filmRepository).getAllTvShows()
        assertNotNull(TvShowEntities)
        assertEquals(10, TvShowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}