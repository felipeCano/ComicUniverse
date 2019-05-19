package com.comic.universe.ui

import com.comic.universe.center.BaseViewModel
import com.comic.universe.control.repository.ComicRepository

class ComicViewModel(private val comicRepository: ComicRepository) : BaseViewModel() {

    fun getComic(){
        addDisposable(comicRepository.getComic())
    }
}