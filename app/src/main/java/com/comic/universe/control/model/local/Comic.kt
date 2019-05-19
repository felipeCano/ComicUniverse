package com.comic.universe.control.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Comic")
data class Comic(
    @PrimaryKey
    val id: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("poster_path")
    val imageserie: String,
    val overview: String
)
