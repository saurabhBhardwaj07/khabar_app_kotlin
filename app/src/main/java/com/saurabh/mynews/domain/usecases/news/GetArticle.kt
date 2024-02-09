package com.saurabh.mynews.domain.usecases.news

import com.saurabh.mynews.data.local.NewsDao
import com.saurabh.mynews.domain.model.Article

class GetArticle (
    private  val newsDao: NewsDao
) {
    suspend operator  fun invoke(url: String) : Article?{
     return   newsDao.getArticle(url)
    }
}