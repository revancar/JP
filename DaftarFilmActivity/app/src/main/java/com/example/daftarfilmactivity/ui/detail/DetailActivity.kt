package com.example.daftarfilmactivity.ui.detail


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.daftarfilmactivity.R
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.example.daftarfilmactivity.databinding.ActivityDetailBinding
import com.example.daftarfilmactivity.viewmodel.ViewModelFactory
import com.example.daftarfilmactivity.vo.Status

class DetailActivity : AppCompatActivity() {

    private lateinit var DetailActivityBinding: ActivityDetailBinding

    private var menu: Menu? = null

    companion object{
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TV = "extra_tv"

        const val TAG = "TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailActivityBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(DetailActivityBinding.root)
        actionBar?.setTitle(R.string.detailFilm)
        supportActionBar?.setTitle(R.string.detailFilm)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel =ViewModelProvider(this, factory)[ViewModelDetail::class.java]


        val bundle = intent.extras
        if (bundle != null){
            val movie = bundle.getString(EXTRA_FILM)
            val tvShow = bundle.getString(EXTRA_TV)

            if(movie != null){


                viewModel.setSelectedMovies(movie)
                viewModel.getSelectedMovies.observe(this, {movieSelected ->
                    if (movieSelected !=null){
                        when(movieSelected.status){
                            Status.LOADING ->{
                                DetailActivityBinding.progressBar.visibility = View.VISIBLE
                            DetailActivityBinding.tvOverview.visibility = View.GONE}
                            Status.SUCCESS -> if (movieSelected.data != null){
                                DetailActivityBinding.progressBar.visibility = View.GONE
                                DetailActivityBinding.tvOverview.visibility = View.VISIBLE
                                populateDataMovie(movieSelected.data)

                            }
                            Status.ERROR -> {
                                DetailActivityBinding.progressBar.visibility = View.GONE
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

            }


            else if (tvShow != null){


                viewModel.setSelectedTvShow(tvShow)

                viewModel.getSelectedTvShow.observe(this, {tvShowSelected ->
                    if (tvShowSelected != null){
                        when (tvShowSelected.status){
                            Status.LOADING -> {
                                DetailActivityBinding.progressBar.visibility = View.VISIBLE
                                DetailActivityBinding.tvOverview.visibility = View.GONE
                            }Status.SUCCESS -> if (tvShowSelected.data != null){
                            DetailActivityBinding.progressBar.visibility = View.GONE
                            DetailActivityBinding.tvOverview.visibility = View.VISIBLE

                            populateDataTvShow(tvShowSelected.data)
                        }
                            Status.ERROR -> {
                                DetailActivityBinding.progressBar.visibility = View.GONE
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

            }
        }
    }

    private fun populateDataMovie(movie: MovieEntity){
        DetailActivityBinding.tvItemTitle.text = movie.title
        DetailActivityBinding.tvItemDate.text = movie.date
        DetailActivityBinding.tvGenre.text = movie.genre
        DetailActivityBinding.tvRating.text = movie.rating
        DetailActivityBinding.tvDescription.text = movie.desc


        Glide.with(this)
                .load(movie.imgPath)
                .into(DetailActivityBinding.imgPoster)
    }

    private fun populateDataTvShow(tvShow: TvShowEntity){
        DetailActivityBinding.tvItemTitle.text = tvShow.title
        DetailActivityBinding.tvItemDate.text = tvShow.date
        DetailActivityBinding.tvGenre.text = tvShow.genre
        DetailActivityBinding.tvRating.text = tvShow.rating
        DetailActivityBinding.tvDescription.text = tvShow.desc

        Glide.with(this)
                .load(tvShow.imgPath)
                .into(DetailActivityBinding.imgPoster)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        this.menu = menu
        val factory = ViewModelFactory.getInstance(this)
        val viewModelState =ViewModelProvider(this, factory)[ViewModelDetail::class.java]
        val bundle = intent.extras
        if (bundle != null){
            val movie = bundle.getString(EXTRA_FILM)
            val tvShow = bundle.getString(EXTRA_TV)

            if(movie != null){
                viewModelState.getSelectedMovies.observe(this , { mMovies ->
                    if (mMovies != null){
                        when(mMovies.status){
                            Status.LOADING -> {
                                DetailActivityBinding?.progressBar?.visibility = View.VISIBLE
                                DetailActivityBinding?.tvOverview?.visibility = View.GONE
                                }
                            Status.SUCCESS -> if (mMovies.data != null){
                                DetailActivityBinding?.progressBar?.visibility = View.GONE
                                DetailActivityBinding?.tvOverview?.visibility = View.VISIBLE
                                val state = mMovies.data.favorite
                                setFavState(state)
                            }
                            Status.ERROR -> {
                                DetailActivityBinding?.progressBar?.visibility = View.GONE
                                DetailActivityBinding?.tvOverview?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }

                        }
                    }
                })
            }else if (tvShow != null){
                viewModelState.getSelectedTvShow.observe(this, { mTvShow ->
                    if (mTvShow != null){
                        when(mTvShow.status){
                            Status.LOADING-> {
                                DetailActivityBinding?.progressBar?.visibility = View.VISIBLE
                                DetailActivityBinding?.tvOverview?.visibility = View.GONE
                            }
                            Status.SUCCESS -> if (mTvShow.data != null) {
                                DetailActivityBinding?.progressBar?.visibility = View.GONE
                                DetailActivityBinding?.tvOverview?.visibility = View.VISIBLE
                                val state = mTvShow.data.favorite
                                setFavState(state)

                            }
                            Status.ERROR -> {
                                DetailActivityBinding?.progressBar?.visibility = View.GONE
                                DetailActivityBinding?.tvOverview?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val factory = ViewModelFactory.getInstance(this)
        val viewModelState =ViewModelProvider(this, factory)[ViewModelDetail::class.java]
        if (item.itemId == R.id.favorite) {
            val bundle = intent.extras
            if (bundle != null) {
                val movie = bundle.getString(EXTRA_FILM)
                val tvShow = bundle.getString(EXTRA_TV)
                if (movie != null){
                    viewModelState.setFavMovie()
                    return true
                }else if (tvShow!= null){
                    viewModelState.setFavTvShow()
                    return true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavState(state: Boolean){
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        }else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }

}