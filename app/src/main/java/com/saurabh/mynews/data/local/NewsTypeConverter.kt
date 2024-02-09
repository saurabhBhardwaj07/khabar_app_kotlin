package com.saurabh.mynews.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.saurabh.mynews.domain.model.Source


@ProvidedTypeConverter
class NewsTypeConverter {

    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}";
    }

    @TypeConverter
    fun stringToSource(source: String) : Source{
        return  source.split(",").let {
            sourceArray -> Source(id = source[0].toString() , name = source[1].toString())
        }
    }
}