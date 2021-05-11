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
import java.util.*
import kotlin.collections.ArrayList

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<Film>>

    @Before
    fun setUp(){
        viewModel = MoviesViewModel(filmRepository)
    }

    //menguji apakah semua data sesuai dengan size yang dikasih dan data tidak null
    @Test
    fun getMovies() {
        val dummyMovies = DataFilm.generateDummyFilm()
        val movies = MutableLiveData<List<Film>>()
        movies.value = dummyMovies


        `when`(filmRepository.getAllMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getMovies().value
        verify<FilmRepository>(filmRepository).getAllMovies()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}