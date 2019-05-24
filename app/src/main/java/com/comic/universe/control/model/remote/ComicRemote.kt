package com.comic.universe.control.model.remote

import com.comic.universe.control.model.local.Comic
import com.google.gson.annotations.SerializedName

data class ComicRemote (
  //  var page: Int,

    val count: Int,
    val limit: Int,
    val offset: Int,
    var results: List<Comic>,
    val total: Int
)