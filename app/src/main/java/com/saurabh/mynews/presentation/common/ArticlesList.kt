package com.saurabh.mynews.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.saurabh.mynews.domain.model.Article
import com.saurabh.mynews.ui.theme.NewsAppTheme


@Composable
fun ArticlesList (
    modifier: Modifier = Modifier,
//    articles: Array<Article>,
//    onClick: (Article) -> Unit
) {

}

@Preview(showBackground = true)
//@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnBoardingPagePreview() {
    NewsAppTheme() {
        ArticlesList(
            Modifier,
//            articles = [ ]
        )
    }
}