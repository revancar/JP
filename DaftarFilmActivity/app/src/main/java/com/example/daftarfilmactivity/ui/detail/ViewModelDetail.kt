package com.example.daftarfilmactivity.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.daftarfilmactivity.data.source.FilmRepository
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.example.daftarfilmactivity.vo.Resource

class ViewModelDetail(private val filmRepository: FilmRepository): ViewModel() {
    private lateinit var movie: String
    private lateinit var tvShow: String
    val movieId = MutableLiveData<String>()
    val tvShowId = MutableLiveData<String>()


    fun setSelectedMovies(movie: String){
        this.movieId.value = movie
    }

    fun setSelectedTvShow(tvShow: String){
        this.tvShowId.value = tvShow
    }

//    private fun getTvShow(): ArrayList<Film> = filmRepository.getAllTvShows()
//    private fun getMovies(): ArrayList<Film> = DataFilm.generateDummyFilm() as ArrayList<Film>

    var getSelectedMovies: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId){ mMovies ->
        filmRepository.getMoviesDetail(mMovies)
    }

    var getSelectedTvShow: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowId){ mTvShow ->
        filmRepository.getTvShowsDetail(mTvShow)
    }


    fun setFavMovie(){
        val movieVal = getSelectedMovies.value
        if(movieVal != null){
            val movies = movieVal.data
            if(movies != null){
                val newState = !movies.favorite
                filmRepository.setFavMovies(movies, newState)
            }
        }

    }

    fun setFavTvShow(){
        val tvShowVal = getSelectedTvShow.value
        if(tvShowVal != null){
            val tvShows = tvShowVal.data
            if(tvShows != null){
                val newState = !tvShows.favorite
                filmRepository.setFavTvShows(tvShows, newState)
            }
        }
    }

}