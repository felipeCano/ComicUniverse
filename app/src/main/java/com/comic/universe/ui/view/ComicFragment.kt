package com.comic.universe.ui.view

import androidx.lifecycle.Observer
import com.comic.universe.R
import com.comic.universe.center.BaseFragment
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.repository.ComicRepository
import com.comic.universe.ui.adapter.ComicAdapter
import kotlinx.android.synthetic.main.fragment_comic.*

class ComicFragment : BaseFragment() {

    lateinit var comicViewModel: ComicViewModel
    lateinit var comicRepository: ComicRepository
    var mAdapterComic : ComicAdapter? = null

    override fun onFinishedViewLoad() {
        initializeUi()
    }

    private fun initializeUi(){
        comicRepository = ComicRepository(retrofit)
        comicViewModel = ComicViewModel(comicRepository)
        comicViewModel.getComic()
       // comicViewModel.getCharacters()
       // comicViewModel.getCreators()
       // comicViewModel.getEvents()
       // comicViewModel.getSeries()
      //  comicViewModel.getStories()

        comicViewModel.liveData.observe(this, recyclerComic)
    }

    private fun initAdapterComic(comic : List<Comic>){
        mAdapterComic = ComicAdapter(comic)
        rvComic.adapter = mAdapterComic
    }

    var recyclerComic = Observer<List<Comic>>{comic ->
        initAdapterComic(comic)
    }

    override fun fragmentLayout(): Int = R.layout.fragment_comic
}