package com.saurabh.mynews.presentation.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.saurabh.mynews.R
import com.saurabh.mynews.domain.model.Article
import com.saurabh.mynews.presentation.Dimens.MediumPadding1
import com.saurabh.mynews.presentation.common.SearchBar
import com.saurabh.mynews.ui.theme.NewsAppTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
//    articles: LazyPagingItems<Article>, navigate: (String) -> Unit
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding1)
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        SearchBar(
            modifier = Modifier
                .padding(horizontal = MediumPadding1)
                .fillMaxWidth(),
            text = "", onValueChanged = {},
            onSearch = {},
            onClick = {
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
    }
}

//@Preview(showBackground = true)
////@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//fun OnBoardingPagePreview() {
//    NewsAppTheme() {
//        HomeScreen()
//    }
//}