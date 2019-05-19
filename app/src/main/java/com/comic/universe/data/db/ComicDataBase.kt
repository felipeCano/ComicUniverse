package com.comic.universe.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.comic.universe.control.model.local.Comic

@Database(entities = [Comic::class], version = 1, exportSchema = false)
abstract class ComicDataBase : RoomDatabase() {
    abstract fun comicDao() : ComicDao
}