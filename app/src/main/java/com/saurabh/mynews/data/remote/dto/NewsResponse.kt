package com.saurabh.mynews.data.remote.dto
import com.saurabh.mynews.domain.model.Article

data class NewsResponse(
    var articles: List<Article?>?,
    var status: String?,
    var totalResults: Int?
)

