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
}