package com.example.daftarfilmactivity.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.daftarfilmactivity.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager: ViewPager = view.findViewById(R.id.viewPager)
        val tab: TabLayout =view.findViewById(R.id.tabs)
        val sectionPagerAdapter = activity?.let { SectionPagerAdapter(it, childFragmentManager) }

        viewPager.adapter = sectionPagerAdapter
        tab.setupWithViewPager(viewPager)

    }

}