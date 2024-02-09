package com.saurabh.mynews.domain.usecases.news

import com.saurabh.mynews.data.local.NewsDao
import com.saurabh.mynews.domain.model.Article

class UpsertArticle (
    private val newsDao: NewsDao
) {
    suspend operator  fun  invoke(article: Article){
        newsDao.upsert(article)
    }
}