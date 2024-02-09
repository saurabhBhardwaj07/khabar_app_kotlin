package com.saurabh.mynews.presentation.search
import androidx.paging.PagingData
import com.saurabh.mynews.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val article: Flow<PagingData<Article>>? = null
)
