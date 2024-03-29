package com.comic.universe.control.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Comic")
data class Comic(
    @PrimaryKey
    val id: Int,
  //  val thumbnail : Thumbnail,
    val title: String

){
    data class Thumbnail(
        var path : String,
        var extension : String
    )
}
