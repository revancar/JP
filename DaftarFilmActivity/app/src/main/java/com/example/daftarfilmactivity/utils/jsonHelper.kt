package com.example.daftarfilmactivity.utils

import android.content.Context
import com.example.daftarfilmactivity.data.source.remote.response.DetailResponse
import com.example.daftarfilmactivity.data.source.remote.response.MovieResponse
import com.example.daftarfilmactivity.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class jsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException){
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("daftarmovies.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()){
                val movies = listArray.getJSONObject(i)

                val movieId = movies.getString("movieId")
                val title = movies.getString("title")
                val date = movies.getString("date")
                val genre = movies.getString("genre")
                val rating = movies.getString("rating")
                val desc = movies.getString("desc")
                val imgPath = movies.getString("imgPath")

                val movieResponse = MovieResponse(movieId, title, date, genre, rating, desc, imgPath)
                list.add(movieResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShows(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("daftartvshow.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()){
                val tvshows = listArray.getJSONObject(i)
                val tvShowsId = tvshows.getString("tvShowId")
                val title = tvshows.getString("title")
                val date = tvshows.getString("date")
                val genre = tvshows.getString("genre")
                val rating = tvshows.getString("rating")
                val desc = tvshows.getString("desc")
                val imgPath = tvshows.getString("imgPath")

                val tvShowResponse = TvShowResponse(tvShowsId, title, date, genre, rating, desc, imgPath)
                list.add(tvShowResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailMovies(MoviesId: String): List<MovieResponse>{
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("daftarmovies.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()){
                val movies = listArray.getJSONObject(i)
                val movieId = movies.getString("movieId")
                val title = movies.getString("title")
                val date = movies.getString("date")
                val genre = movies.getString("genre")
                val rating = movies.getString("rating")
                val desc = movies.getString("desc")
                val imgPath = movies.getString("imgPath")

                val movieResponse = MovieResponse(movieId, title, date, genre, rating, desc, imgPath)
                list.add(movieResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailTvShows(TvShowId: String): List<TvShowResponse>{
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("daftartvshow.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()){
                val tvshows = listArray.getJSONObject(i)
                val tvShowsId = tvshows.getString("tvShowId")
                val title = tvshows.getString("title")
                val date = tvshows.getString("date")
                val genre = tvshows.getString("genre")
                val rating = tvshows.getString("rating")
                val desc = tvshows.getString("desc")
                val imgPath = tvshows.getString("imgPath")

                val tvShowResponse = TvShowResponse(tvShowsId, title, date, genre, rating, desc, imgPath)
                list.add(tvShowResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        return list
    }

}