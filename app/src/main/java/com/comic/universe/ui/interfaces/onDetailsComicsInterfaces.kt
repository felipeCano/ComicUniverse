package com.comic.universe.ui.interfaces

import com.comic.universe.control.model.local.Characters
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.model.local.Creators

interface onDetailsComicsInterfaces {
    fun onDetailsComic(comic: Comic)
    fun onDetailCharacters(characters: Characters)
    fun onDetailCreators(creators: Creators)
}