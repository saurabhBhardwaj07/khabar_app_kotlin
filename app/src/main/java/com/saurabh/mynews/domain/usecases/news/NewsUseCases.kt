package com.saurabh.mynews.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val getNewsArticles: GetNewsArticles,
    val getArticle: GetArticle,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle
)
