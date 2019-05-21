package com.comic.universe.data.api

import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.security.MessageDigest
import java.sql.Timestamp
import java.text.SimpleDateFormat


const val API_KEY_PUBLIC = "ca799fa8fea5b187f2f75aec76355b53"
const val API_KEY_PRIVATE = "de212838d957f48b4863827e057255cc06b7c00e"
const val ACCEPT_TOKEN: String = "Accept: application/json"
const val CONTENT_TYPE: String = "Content-Type: application/json"
//var formattedDate = SimpleDateFormat("yyyyMMdd").format(Timestamp(System.currentTimeMillis()))
val TIMESTAMP_MD5 = System.currentTimeMillis()

fun md5(): String {
    val text = TIMESTAMP_MD5.toString() + API_KEY_PRIVATE + API_KEY_PUBLIC
    val md = MessageDigest.getInstance("MD5")
    val digested = md.digest(text.toByteArray())
    return digested.joinToString("") {
        String.format("%02x", it)
    }
}

interface ApiComic {

    @Headers(ACCEPT_TOKEN, CONTENT_TYPE)
    @GET("comics")
    fun getComic(
        @Query("apikey") apiKey: String = API_KEY_PUBLIC,
        @Query("ts") timestamp: String = TIMESTAMP_MD5.toString(),
        @Query("hash") hash: String = md5()
    ): Observable<JsonElement>
}