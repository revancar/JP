package com.example.daftarfilmactivity.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarfilmactivity.R
import com.example.daftarfilmactivity.databinding.FragmentTvShowFavBinding
import com.example.daftarfilmactivity.viewmodel.ViewModelFactory

class TvShowFavFragment : Fragment() {
    private lateinit var viewModel: TvShowFavViewModel
    private lateinit var adapter: TvShowFavAdapter

    private var fragmentTvShowFavBinding: FragmentTvShowFavBinding? = null
    private val binding get() = fragmentTvShowFavBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentTvShowFavBinding = FragmentTvShowFavBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowFavViewModel::class.java]

            adapter = TvShowFavAdapter()
            fragmentTvShowFavBinding?.progressBar?.visibility = View.VISIBLE

            viewModel.getFavTvShows().observe(viewLifecycleOwner, { tvShows ->
                fragmentTvShowFavBinding?.progressBar?.visibility = View.GONE
                adapter.submitList(tvShows)
            })

            with(fragmentTvShowFavBinding?.rvTvShow){
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = adapter
            }
        }
    }

}