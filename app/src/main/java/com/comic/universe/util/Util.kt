package com.comic.universe.util

import android.content.Context
import androidx.room.Room
import com.comic.universe.data.api.ApiComic
import com.comic.universe.data.db.ComicDataBase
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val DATABASE_NAME ="comic_universe.db"
object Util {

    fun gsonProvider() : Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setLenient().create()
    }

    fun okHttpClientProvider() : OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    fun retrofitProvider(okHttpClient : OkHttpClient, gson : Gson) : ApiComic{
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiComic::class.java)
    }

    /*fun dataBaseProvider(context : Context) : ComicDataBase{
        return Room.databaseBuilder(context, ComicDataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }*/
}