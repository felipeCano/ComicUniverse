package com.comic.universe.center

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.comic.universe.data.api.ApiComic
import com.comic.universe.data.db.ComicDao
import com.comic.universe.data.db.ComicDataBase
import com.comic.universe.util.Util
import com.google.gson.Gson
import okhttp3.OkHttpClient

abstract class BaseFragment : Fragment(){


    protected lateinit var okHttpClient: OkHttpClient
    protected lateinit var retrofit: ApiComic
    protected lateinit var gosn: Gson
    protected lateinit var comicDao: ComicDao
    protected lateinit var comicDataBase: ComicDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(fragmentLayout(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gosn = Util.gsonProvider()
        okHttpClient = Util.okHttpClientProvider()
        retrofit = Util.retrofitProvider(okHttpClient, gosn)
      //  comicDataBase = Util.dataBaseProvider(context!!)
        onFinishedViewLoad()
    }

    @LayoutRes
    abstract fun fragmentLayout(): Int

    abstract fun onFinishedViewLoad()

    protected fun navController(): NavController? {
        return view?.let { Navigation.findNavController(it) }
    }
}