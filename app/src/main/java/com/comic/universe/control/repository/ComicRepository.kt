package com.comic.universe.control.repository

import android.util.Log
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.model.remote.ComicRemote
import com.comic.universe.data.api.ApiComic
import com.google.gson.Gson
import io.reactivex.Observable

class ComicRepository(
    private val apiComic: ApiComic
) {

    fun getComic() : Observable<List<Comic>> {
        return apiComic.getComic().map { response ->
            Log.d("getComic", response.toString())
            Gson().fromJson(response, ComicRemote::class.java).results
        }
    }

    fun getCharacters() : Observable<List<Comic>> {
        return apiComic.getCharacters().map { response ->
            Log.d("getCharacters", response.toString())
            Gson().fromJson(response, ComicRemote::class.java).results
        }
    }

    fun getCreators() : Observable<List<Comic>> {
        return apiComic.getCreators().map { response ->
            Log.d("getCreators", response.toString())
            Gson().fromJson(response, ComicRemote::class.java).results
        }
    }

    fun getEvents() : Observable<List<Comic>> {
        return apiComic.getEvents().map { response ->
            Log.d("getEvents", response.toString())
            Gson().fromJson(response, ComicRemote::class.java).results
        }
    }

    fun getSeries() : Observable<List<Comic>> {
        return apiComic.getSeries().map { response ->
            Log.d("getSeries", response.toString())
            Gson().fromJson(response, ComicRemote::class.java).results
        }
    }

    fun getStories() : Observable<List<Comic>> {
        return apiComic.getStories().map { response ->
            Log.d("getStories", response.toString())
            Gson().fromJson(response, ComicRemote::class.java).results
        }
    }
}