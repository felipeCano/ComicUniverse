package com.comic.universe.control.model.remote

import com.comic.universe.control.model.local.Comic
import com.google.gson.annotations.SerializedName

data class ComicRemote (
    var page: Int,
    var results: List<Comic> = emptyList(),
    @SerializedName("total_results")
    var totalResults: Int,
    @SerializedName("total_pages")
    var totalPages: Int
)