package com.comic.universe.control.model.local

import androidx.room.PrimaryKey

data class Characters(
    @PrimaryKey
    val id: Int,
    //  val thumbnail : Thumbnail,
    val name: String

){
    data class Thumbnail(
        var path : String,
        var extension : String
    )
}


