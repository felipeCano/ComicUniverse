package com.comic.universe.ui.view.detail.seriesdetail

import com.comic.universe.center.BaseViewModel
import com.comic.universe.control.repository.ComicRepository

class SeriesDetailViewModel(private val comicRepository: ComicRepository) : BaseViewModel() {

    fun getDetailSeries(seriesId : Int){
        addDisposableDetail(comicRepository.getDetailSeries(seriesId))
    }
}