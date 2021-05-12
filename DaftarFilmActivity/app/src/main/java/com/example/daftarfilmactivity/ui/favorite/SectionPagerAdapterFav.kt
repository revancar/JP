package com.example.daftarfilmactivity.ui.favorite


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionPagerAdapterFav(activity: AppCompatActivity): FragmentStateAdapter(activity){

    override fun getItemCount(): Int {
        return 2
    }


    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MoviesFavFragment()
            1 -> fragment = TvShowFavFragment()
        }
        return fragment as Fragment
    }



}