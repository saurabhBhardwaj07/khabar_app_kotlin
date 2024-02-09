package com.saurabh.mynews.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.saurabh.mynews.domain.model.Article

class NewsPagingSource (
    private val newsApi: NewsApi,
    private val sources: String
        ) : PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

     private var totalNewsCount = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {

        val page = params.key ?: 1
        return  try {
            val newsResponse = newsApi.getNews(sources = sources , page = page)
            totalNewsCount += newsResponse.articles?.size ?: 0
            val articles = newsResponse.articles?.filterNotNull()?.distinctBy { it.title }

            LoadResult.Page(
                data = articles.orEmpty(),
                nextKey = if(totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (e : Exception){
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }


}