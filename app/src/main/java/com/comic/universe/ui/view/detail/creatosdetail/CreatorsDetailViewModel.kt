package com.comic.universe.ui.view.detail.creatosdetail

import com.comic.universe.center.BaseViewModel
import com.comic.universe.control.repository.ComicRepository

class CreatorsDetailViewModel(private val comicRepository: ComicRepository) : BaseViewModel() {

    fun getDetailCreatos(creatorsId : Int){
        addDisposableDetailCreators(comicRepository.getDetailCreators(creatorsId))
    }
}