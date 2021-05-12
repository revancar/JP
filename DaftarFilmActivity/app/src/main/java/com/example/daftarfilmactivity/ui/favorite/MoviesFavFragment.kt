package com.example.daftarfilmactivity.ui.favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarfilmactivity.databinding.FragmentMoviesFavBinding
import com.example.daftarfilmactivity.viewmodel.ViewModelFactory

class MoviesFavFragment : Fragment() {
    private lateinit var viewModel: MoviesFavViewModel
    private lateinit var adapter: MoviesFavAdapter

    companion object{
        const val TAG = "TAG"
    }

    private var fragmentMoviesFavBinding: FragmentMoviesFavBinding? = null
    private val binding get()= fragmentMoviesFavBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentMoviesFavBinding = FragmentMoviesFavBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MoviesFavViewModel::class.java]

            adapter = MoviesFavAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavMovies().observe(viewLifecycleOwner, { movies ->
                if(movies != null){
                    binding?.progressBar?.visibility = View.GONE
                    adapter.submitList(movies)
                    adapter.notifyDataSetChanged()
                }

            })

//            with(fragmentMoviesFavBinding?.rvMovies){
//                this?.layoutManager =LinearLayoutManager(context)
//                this?.adapter = adapter
//            }

            binding?.rvMovies?.layoutManager =LinearLayoutManager(context)
            binding?.rvMovies?.adapter = adapter


        }
    }


}