package com.example.daftarfilmactivity.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class TvShowFavViewModelTest {

    private lateinit var viewModel: TvShowFavViewModel


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var filmRepository = mock<FilmRepository>()

//    @Mock
//    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    private var observer = mock<Observer<PagedList<TvShowEntity>>>()

//    @Mock
//    private lateinit var tvShowPagedList: PagedList<TvShowEntity>
    private var tvShowPagedList = mock<PagedList<TvShowEntity>>()

    @Before
    fun setUp(){
        viewModel = TvShowFavViewModel(filmRepository)
    }

    @Test
    fun getFavTvShows() {

        val dummyTvShow = tvShowPagedList
        `when`(dummyTvShow.size).thenReturn(5)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShow


        `when`(filmRepository.getFavTvShows()).thenReturn(tvShow)
        val tvShowEntities =viewModel.getFavTvShows().value
        assertNotNull(tvShowEntities)
        assertEquals(5, tvShowEntities?.size)


        viewModel.getFavTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)


    }
}