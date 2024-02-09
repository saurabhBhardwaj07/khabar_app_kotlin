package com.saurabh.mynews.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.saurabh.mynews.data.remote.NewsPagingSource
import com.saurabh.mynews.data.remote.SearchNewsPagingSource
import com.saurabh.mynews.data.remote.NewsApi
import com.saurabh.mynews.domain.model.Article
import com.saurabh.mynews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl (private val newsApi: NewsApi) : NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return  Pager(
            config = PagingConfig(10) ,
            pagingSourceFactory = {
                   NewsPagingSource(newsApi = newsApi , sources = sources.joinToString(","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig( pageSize = 10),
        pagingSourceFactory = {
            SearchNewsPagingSource(
                api = newsApi,
                searchQuery = searchQuery,
                sources = sources.joinToString(",")
            )
        }
        ).flow
    }

}