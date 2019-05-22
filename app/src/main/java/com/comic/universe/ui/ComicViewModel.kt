package com.comic.universe.ui

import com.comic.universe.center.BaseViewModel
import com.comic.universe.control.repository.ComicRepository

class ComicViewModel(private val comicRepository: ComicRepository) : BaseViewModel() {

    fun getComic(){
        addDisposable(comicRepository.getComic())
    }

    fun getCharacters(){
        addDisposable(comicRepository.getCharacters())
    }

    fun getCreators(){
        addDisposable(comicRepository.getCreators())
    }

    fun getEvents(){
        addDisposable(comicRepository.getEvents())
    }

    fun getSeries(){
        addDisposable(comicRepository.getSeries())
    }

    fun getStories(){
        addDisposable(comicRepository.getStories())
    }
}