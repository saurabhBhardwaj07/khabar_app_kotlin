package com.saurabh.mynews.domain.usecases.news

import androidx.paging.PagingData
import com.saurabh.mynews.domain.model.Article
import com.saurabh.mynews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}