package com.example.daftarfilmactivity.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarfilmactivity.R
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.databinding.FragmentMoviesBinding
import com.example.daftarfilmactivity.viewmodel.ViewModelFactory
import com.example.daftarfilmactivity.vo.Status

class MoviesFragment : Fragment() {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]


        val moviesAdapter =MoviesAdapter()
        viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
            if (movies!= null){
                when (movies.status) {
                    Status.LOADING -> fragmentMoviesBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentMoviesBinding.progressBar.visibility = View.GONE
                        moviesAdapter.submitList(movies.data)
                        moviesAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        fragmentMoviesBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })


        with(fragmentMoviesBinding.rvMovies){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = moviesAdapter
        }
        }
    }


}