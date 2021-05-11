package com.example.daftarfilmactivity.ui.favorite

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

class MoviesFavAdapter: PagedListAdapter<MovieEntity, MoviesFavAdapter.MoviesFavViewHolder>
    (DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object  : DiffUtil.ItemCallback<MovieEntity>(){
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    class MoviesFavViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity){
            with(binding){
                tvItemTitle.text = movie.title
                tvItemDate.text = movie.date
                tvGenre.text = movie.genre
                tvRating.text = movie.rating
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, movie.movieId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movie.imgPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MoviesFavViewHolder{
        val itemsMoviesBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesFavViewHolder(itemsMoviesBinding)
    }
    override fun onBindViewHolder(holder: MoviesFavViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie !=null){
            holder.bind(movie)
        }
    }

}