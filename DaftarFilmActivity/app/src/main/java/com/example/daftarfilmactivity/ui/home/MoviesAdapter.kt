package com.example.daftarfilmactivity.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.daftarfilmactivity.R
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.databinding.ItemsMovieBinding
import com.example.daftarfilmactivity.ui.detail.DetailActivity

class MoviesAdapter: PagedListAdapter<MovieEntity, MoviesAdapter.MoviesViewHolder>
    (DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>(){
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }

    }

    class MoviesViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MovieEntity){
            with(binding){
                tvItemTitle.text = movies.title
                tvItemDate.text = movies.date
                tvGenre.text = movies.genre
                tvRating.text = movies.rating
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, movies.title)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movies.imgPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsMoviesActivityBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesActivityBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }

}