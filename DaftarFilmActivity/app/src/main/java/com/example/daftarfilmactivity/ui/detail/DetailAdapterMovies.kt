package com.example.daftarfilmactivity.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.daftarfilmactivity.R

import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.databinding.ItemsMovieBinding

class DetailAdapterMovies: RecyclerView.Adapter<DetailAdapterMovies.DetailMoviesViewHolder>() {

    private val listMovie = ArrayList<MovieEntity>()

    fun setFilm(movie: List<MovieEntity>){
        if (movie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movie)
    }

    inner class DetailMoviesViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: MovieEntity){
            with(binding){
                tvItemTitle.text = movie.title
                tvItemDate.text = movie.date
                tvGenre.text = movie.genre
                tvRating.text = movie.rating

                Glide.with(itemView.context)
                    .load(movie.imgPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailMoviesViewHolder {
        val itemsMoviesActivityBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context),parent , false)
        return DetailMoviesViewHolder(itemsMoviesActivityBinding)
    }

    override fun onBindViewHolder(holder: DetailMoviesViewHolder, position: Int) {
        val movies = listMovie[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovie.size
}