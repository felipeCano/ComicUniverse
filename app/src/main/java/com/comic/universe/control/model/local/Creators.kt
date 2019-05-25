package com.comic.universe.control.model.local

import androidx.room.PrimaryKey

data class Creators (
    @PrimaryKey
    val id: Int,
    //  val thumbnail : Thumbnail,
    val firstName: String

){
    data class Thumbnail(
        var path : String,
        var extension : String
    )
}