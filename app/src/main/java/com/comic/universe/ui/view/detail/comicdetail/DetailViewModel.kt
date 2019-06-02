package com.comic.universe.ui.view.detail.comicdetail

import com.comic.universe.center.BaseViewModel
import com.comic.universe.control.repository.ComicRepository

class DetailViewModel(private val comicRepository: ComicRepository) : BaseViewModel() {

    fun getDetailComic(comicId : Int){
    addDisposableDetail(comicRepository.getDetailComic(comicId))
    }
}