package com.example.daftarfilmactivity.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.daftarfilmactivity.data.FakeFilmRepository
import com.example.daftarfilmactivity.data.Film
import com.example.daftarfilmactivity.data.source.remote.RemoteDataSource
import com.example.daftarfilmactivity.data.source.remote.response.DetailResponse
import com.example.daftarfilmactivity.data.source.remote.response.MovieResponse
import com.example.daftarfilmactivity.data.source.remote.response.TvShowResponse
import com.example.daftarfilmactivity.utils.DataFilm
import com.example.daftarfilmactivity.utils.LiveDataTestUtils
import org.junit.Test
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.doAnswer

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val filmRepository = FakeFilmRepository(remote)

    private val movieResponse = DataFilm.generateRemoteDummyMovies()
    private val movieTitle = movieResponse[0].title
    private val tvShowResponse = DataFilm.generateRemoteDummyTvShows()
    private val tvShowTitle = tvShowResponse[0].title
    private val detailResponseMovie = DataFilm.generateRemoteDummyMoviesDetail()
    private val detailResponseTvShow = DataFilm.generateRemoteDummyTvShowsDetail()

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val moviesEntities = LiveDataTestUtils.getValue(filmRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(moviesEntities)
        assertEquals(movieResponse.size.toLong(), moviesEntities.size.toLong())
    }

    @Test
    fun getMoviesDetail() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMoviesCallback)
                .onAllMoviesDetailReceived(detailResponseMovie)
            null
        }.`when`(remote).getDetailMovies(eq(movieTitle), any())
        val resultMovie = LiveDataTestUtils.getValue(filmRepository.getMoviesDetail(movieTitle))
        verify(remote).getDetailMovies(eq(movieTitle),any())
        assertNotNull(resultMovie)
        assertEquals(movieResponse[0].title, resultMovie.title)
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShows(any())
        val tvShowEntities = LiveDataTestUtils.getValue(filmRepository.getAllTvShows())
        verify(remote).getAllTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getTvShowsDetail() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowsCallback)
                .onAllTvShowsDetailReceived(detailResponseTvShow)
            null
        }.`when`(remote).getDetailTvShows(eq(tvShowTitle), any())
        val resultTvShow = LiveDataTestUtils.getValue(filmRepository.getTvShowsDetail(tvShowTitle))
        verify(remote).getDetailTvShows(eq(tvShowTitle), any())
        assertNotNull(resultTvShow)
        assertEquals(tvShowResponse[0].title, resultTvShow.title)
    }
}