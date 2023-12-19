package com.saurabh.mynews.presentation.onboarding

import androidx.annotation.DrawableRes
import com.saurabh.mynews.R

data class Page(
    val title: String, val description: String, @DrawableRes val image: Int
)

val pages = listOf<Page>(
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simple dummy text of the printing and typesetting industry",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simple dummy text of the printing and typesetting industry",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simple dummy text of the printing and typesetting industry",
        image = R.drawable.onboarding3
    ),
)