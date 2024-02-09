package com.saurabh.mynews.presentation.details

import com.saurabh.mynews.domain.model.Article

open class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()
    object RemoveSideEffect : DetailsEvent()
}
