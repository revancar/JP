package com.example.daftarfilmactivity.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.daftarfilmactivity.utils.DataFilm

import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.daftarfilmactivity.R
import com.example.daftarfilmactivity.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before


class MainActivityTest{

    private val dummyMovies = DataFilm.generateDummyFilm()
    private val dummyTvShow = DataFilm.generateDummyTv()



    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    
    @Before
    fun setUp(){
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    //    Memastikan rvMovies dalam keadaan tampil.
//    Gulir rvMovies ke posisi data terakhir.
    @Test
    fun loadMovies(){
        onView(withId(R.id.rvMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))

    }
    //   Memberi tindakan klik pada pager ke 2 yaitu TvShows.
    //    Memastikan rvTvShows dalam keadaan tampil.
    //    Gulir rvTvShows ke posisi data terakhir.
    @Test
    fun loadTvShow(){
        onView(withText("TVSHOWS")).perform(click())
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))

    }

    //Memberi tindakan klik pada data pertama rvMovies
    //Memastikan TextView untuk title tampil sesuai dengan yang diharapkan.
    //Memastikan TextView untuk date tampil sesuai dengan yang diharapkan.
    //Memastikan TextView untuk genre tampil sesuai dengan yang diharapkan.
    //Memastikan TextView untuk rating tampil sesuai dengan yang diharapkan.
    //Memastikan TextView untuk rating dapat di swipeUp.
    //Memastikan TextView untuk description tampil sesuai dengan yang diharapkan.
    //Memastikan ImageView dalam keadaan tampil.
    @Test
    fun loadMoviesDetail(){
        onView(withId(R.id.rvMovies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_date)).check(matches(withText(dummyMovies[0].date)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyMovies[0].genre)))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText(dummyMovies[0].rating)))
        onView(withId(R.id.tv_rating)).perform(swipeUp()).perform(swipeUp())
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(withText(dummyMovies[0].desc)))
    }
    //Memberi tindakan klik pada pager TvShows.
    //Memberi tindakan klik pada data pertama rvTvShows.
    //Memastikan TextView untuk title tampil sesuai dengan yang diharapkan.
    //Memastikan TextView untuk date tampil sesuai dengan yang diharapkan.
    //Memastikan TextView untuk genre tampil sesuai dengan yang diharapkan.
    //Memastikan TextView untuk rating tampil sesuai dengan yang diharapkan.
    //Memastikan TextView untuk rating dapat di swipeUp.
    //Memastikan TextView untuk description tampil sesuai dengan yang diharapkan.
    //Memastikan ImageView dalam keadaan tampil.
    @Test
    fun loadTvShowsDetail(){
        onView(withText("TVSHOWS")).perform(click())
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_item_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_date)).check(matches(withText(dummyTvShow[0].date)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText(dummyTvShow[0].rating)))
        onView(withId(R.id.tv_rating)).perform(swipeUp()).perform(swipeUp())
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(withText(dummyTvShow[0].desc)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
    }

    //Memastikan viewPager ditampilkan
    //Memberi tindakan swipeRight kepada viewPager
    //Memberi tindakan swipeLeft kepada viewPager
    @Test
    fun swipeFilm(){
        onView(withId(R.id.viewPager)).check(matches(isDisplayed()))
        onView(withId(R.id.viewPager)).perform(swipeRight())
        onView(withId(R.id.viewPager)).perform(swipeLeft())
    }

}