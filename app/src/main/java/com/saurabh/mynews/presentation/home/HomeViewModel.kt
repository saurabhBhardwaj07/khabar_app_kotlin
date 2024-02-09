package com.saurabh.mynews.presentation.home
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.paging.cachedIn
import androidx.lifecycle.viewModelScope
import com.saurabh.mynews.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private  val newsUseCases: NewsUseCases
) : ViewModel() {
    var state = mutableStateOf(HomeState())
    val news = newsUseCases.getNews(
        sources = listOf("bbc-news", "abc-news","al-jazeera-english")
    ).cachedIn(viewModelScope)
}