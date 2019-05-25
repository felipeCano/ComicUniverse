package com.comic.universe.control.model.remote

import com.comic.universe.control.model.local.Creators

data class CreatorsRemote (
    val count: Int,
    val limit: Int,
    val offset: Int,
    var results: List<Creators> = emptyList(),
    val total: Int
)