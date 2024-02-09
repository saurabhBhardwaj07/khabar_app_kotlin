package com.saurabh.mynews.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saurabh.mynews.domain.model.Article

@Database(entities = [Article :: class], version = 1)
@TypeConverters(NewsTypeConverter :: class)
abstract class NewsDatabase : RoomDatabase() {
    abstract  val newsDao: NewsDao
}