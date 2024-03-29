package com.comic.universe.control.repository

import android.util.Log
import com.comic.universe.control.model.local.Characters
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.model.local.Creators
import com.comic.universe.control.model.remote.ComicRemote
import com.comic.universe.control.model.remote.Marvel
import com.comic.universe.control.model.remote.MarvelCharacters
import com.comic.universe.control.model.remote.MarvelCreators
import com.comic.universe.data.api.ApiComic
import com.google.gson.Gson
import io.reactivex.Observable

class ComicRepository(
    private val apiComic: ApiComic
) {

    fun getComic() : Observable<List<Comic>> {
        return apiComic.getComic().map { response ->
+            Log.d("getComic", response.toString())
            Gson().fromJson(response, Marvel::class.java).data.results
        }
    }

    fun getCharacters() : Observable<List<Characters>> {
        return apiComic.getCharacters().map { response ->
            Log.d("getCharacters", response.toString())
            Gson().fromJson(response, MarvelCharacters::class.java).data.results
        }
    }

    fun getCreators() : Observable<List<Creators>> {
        return apiComic.getCreators().map { response ->
            Log.d("getCreators", response.toString())
            Gson().fromJson(response, MarvelCreators::class.java).data.results
        }
    }

    fun getEvents() : Observable<List<Comic>> {
        return apiComic.getEvents().map { response ->
            Log.d("getEvents", response.toString())
            Gson().fromJson(response, Marvel::class.java).data.results
        }
    }

    fun getSeries() : Observable<List<Comic>> {
        return apiComic.getSeries().map { response ->
            Log.d("getSeries", response.toString())
            Gson().fromJson(response, Marvel::class.java).data.results
        }
    }

    fun getStories() : Observable<List<Comic>> {
        return apiComic.getStories().map { response ->
            Log.d("getStories", response.toString())
            Gson().fromJson(response, Marvel::class.java).data.results
        }
    }


    fun getDetailComic(comicId: Int): Observable<Comic> {
        return apiComic.getDetailComic(comicId).map { response ->
            Log.d("getDetailComic", response.toString())
            Gson().fromJson(response, Marvel::class.java).data.results[0]
        }
    }

    fun getDetailChacters(comicId: Int): Observable<Characters> {
        return apiComic.getDetailCharacters(comicId).map { response ->
            Log.d("getDetailCharacters", response.toString())
            Gson().fromJson(response, MarvelCharacters::class.java).data.results[0]
        }
    }

    fun getDetailCreators(comicId: Int): Observable<Creators> {
        return apiComic.getDetailCreators(comicId).map { response ->
            Log.d("getDetailCreators", response.toString())
            Gson().fromJson(response, MarvelCreators::class.java).data.results[0]
        }
    }

    fun getDetailEvents(comicId: Int): Observable<Comic> {
        return apiComic.getDetailEvents(comicId).map { response ->
            Log.d("getDetailEvents", response.toString())
            Gson().fromJson(response, Marvel::class.java).data.results[0]
        }
    }

    fun getDetailSeries(comicId: Int): Observable<Comic> {
        return apiComic.getDetailSeries(comicId).map { response ->
            Log.d("getDetailSeries", response.toString())
            Gson().fromJson(response, Marvel::class.java).data.results[0]
        }
    }

    fun getDetailStorie(comicId: Int): Observable<Comic> {
        return apiComic.getDetailStories(comicId).map { response ->
            Log.d("getDetailStories", response.toString())
            Gson().fromJson(response, Marvel::class.java).data.results[0]
        }
    }
}