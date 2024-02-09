package com.saurabh.mynews.presentation.home

data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false
)
