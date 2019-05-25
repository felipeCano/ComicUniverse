package com.comic.universe.ui.view

import com.comic.universe.center.BaseViewModel
import com.comic.universe.control.repository.ComicRepository

class ComicViewModel(private val comicRepository: ComicRepository) : BaseViewModel() {

    fun getComic(){
        addComics(comicRepository.getComic())
    }

    fun getCharacters(){
        addCharacters(comicRepository.getCharacters())
    }

    fun getCreators(){
        addCreators(comicRepository.getCreators())
    }

    fun getEvents(){
        addComics(comicRepository.getEvents())
    }

    fun getSeries(){
        addComics(comicRepository.getSeries())
    }

    fun getStories(){
        addComics(comicRepository.getStories())
    }
}