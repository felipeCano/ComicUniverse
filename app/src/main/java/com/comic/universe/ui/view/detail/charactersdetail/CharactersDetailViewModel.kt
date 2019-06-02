package com.comic.universe.ui.view.detail.charactersdetail

import com.comic.universe.center.BaseViewModel
import com.comic.universe.control.repository.ComicRepository

class CharactersDetailViewModel(private val comicRepository: ComicRepository) : BaseViewModel() {

    fun getDetailCharacters(charactersId : Int){
        addDisposableDetailCharacters(comicRepository.getDetailChacters(charactersId))
    }
}