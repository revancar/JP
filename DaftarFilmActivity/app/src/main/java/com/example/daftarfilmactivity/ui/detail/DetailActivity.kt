package com.example.daftarfilmactivity.ui.detail


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.example.daftarfilmactivity.databinding.ActivityDetailBinding
import com.example.daftarfilmactivity.viewmodel.ViewModelFactory
import com.example.daftarfilmactivity.vo.Status

class DetailActivity : AppCompatActivity() {

    private lateinit var DetailActivityBinding: ActivityDetailBinding

    companion object{
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailActivityBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(DetailActivityBinding.root)

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
                            Status.LOADING ->
                                DetailActivityBinding.progressBar.visibility = View.VISIBLE
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
}