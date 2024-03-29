package com.comic.universe.control.model.remote

import com.comic.universe.control.model.local.Comic

data class ComicRemote (
    val count: Int,
    val limit: Int,
    val offset: Int,
    var results: List<Comic> = emptyList(),
    val total: Int
)