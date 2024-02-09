package com.saurabh.mynews.presentation.bookmark
import com.saurabh.mynews.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)