package com.saurabh.mynews.domain.usecases.news

import androidx.paging.PagingData
import com.saurabh.mynews.data.remote.SearchNewsPagingSource
import com.saurabh.mynews.domain.model.Article
import com.saurabh.mynews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}