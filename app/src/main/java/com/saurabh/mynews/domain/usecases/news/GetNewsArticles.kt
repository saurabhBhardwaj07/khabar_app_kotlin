package com.saurabh.mynews.domain.usecases.news

import com.saurabh.mynews.data.local.NewsDao
import com.saurabh.mynews.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetNewsArticles(
    private  val newsDao : NewsDao
) {
    operator fun invoke () : Flow<List<Article>>{
       return newsDao .getArticles()
    }
}