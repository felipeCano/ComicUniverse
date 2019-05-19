package com.comic.universe.data.api

import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "ca799fa8fea5b187f2f75aec76355b53"
interface ApiComic {

    @GET("comics")
    fun getComic(
        @Query("api_key") apiKey: String = API_KEY
    ): Observable<JsonElement>
}