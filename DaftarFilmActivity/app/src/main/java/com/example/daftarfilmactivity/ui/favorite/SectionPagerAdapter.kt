package com.example.daftarfilmactivity.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.daftarfilmactivity.R

class SectionPagerAdapter(private val context: Context, fragment: FragmentManager) : FragmentPagerAdapter(
    fragment, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab1,
            R.string.tab2
        )
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> MoviesFavFragment()
            2 -> TvShowFavFragment()
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? =
        context.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = TAB_TITLES.size

}