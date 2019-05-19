package com.comic.universe.ui

import com.comic.universe.R
import com.comic.universe.center.BaseFragment
import com.comic.universe.control.repository.ComicRepository

class ComicFragment : BaseFragment() {

    lateinit var comicViewModel: ComicViewModel
    lateinit var comicRepository: ComicRepository

    override fun onFinishedViewLoad() {
        initializeUi()
    }

    private fun initializeUi(){
        comicRepository = ComicRepository(retrofit)
        comicViewModel = ComicViewModel(comicRepository)
        comicViewModel.getComic()
    }

    override fun fragmentLayout(): Int = R.layout.fragment_comic
}