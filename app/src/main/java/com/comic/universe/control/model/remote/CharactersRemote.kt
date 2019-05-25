package com.comic.universe.control.model.remote

import com.comic.universe.control.model.local.Characters

data class CharactersRemote(
    val count: Int,
    val limit: Int,
    val offset: Int,
    var results: List<Characters> = emptyList(),
    val total: Int
)
