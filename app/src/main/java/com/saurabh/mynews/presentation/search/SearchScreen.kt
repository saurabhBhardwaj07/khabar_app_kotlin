package com.saurabh.mynews.presentation.search
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.saurabh.mynews.domain.model.Article
import com.saurabh.mynews.presentation.Dimens.ExtraSmallPadding2
import com.saurabh.mynews.presentation.Dimens.MediumPadding1
import com.saurabh.mynews.presentation.common.ArticlesList
import com.saurabh.mynews.presentation.common.SearchBar
import com.saurabh.mynews.ui.theme.NewsAppTheme


@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                top = MediumPadding1, start = MediumPadding1, end = MediumPadding1
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        SearchBar(
            text = state.searchQuery,
            onValueChanged = {
                event(SearchEvent.UpdateSearchQuery(it))
            },
            readOnly = false,
            onSearch = {
                event(SearchEvent.SearchNews)
            }
        )
        Spacer(modifier = Modifier.height( ExtraSmallPadding2))
        state.article?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(articles = articles, onClick = {
              article ->   navigateToDetails(article)
            })
        }
    }
}


@Preview(showBackground = true)
//@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnBoardingPagePreview() {
    NewsAppTheme() {
        SearchScreen(state = SearchState(), event = {} , navigateToDetails = {});
    }
}