package com.comic.universe.ui.view.detail.storiedetail

import com.comic.universe.center.BaseViewModel
import com.comic.universe.control.repository.ComicRepository

class StoriesDetailViewModel(private val comicRepository: ComicRepository) : BaseViewModel() {

    fun getDetailStorie(storieId : Int){
        addDisposableDetail(comicRepository.getDetailStorie(storieId))
    }
}