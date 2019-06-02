package com.comic.universe.ui.view.detail.eventsdetail

import com.comic.universe.center.BaseViewModel
import com.comic.universe.control.repository.ComicRepository

class EventsDetailViewModel(private val comicRepository: ComicRepository) : BaseViewModel() {

    fun getDetailEvents(eventsId : Int){
        addDisposableDetail(comicRepository.getDetailEvents(eventsId))
    }
}