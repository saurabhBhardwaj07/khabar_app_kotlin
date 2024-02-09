package com.saurabh.mynews.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.saurabh.mynews.presentation.bookmark.BookmarkScreen
import com.saurabh.mynews.presentation.bookmark.BookmarkViewModel
import com.saurabh.mynews.presentation.home.HomeScreen
import com.saurabh.mynews.presentation.home.HomeViewModel
import com.saurabh.mynews.presentation.news_navigator.NewsNavigator
import com.saurabh.mynews.presentation.onboarding.OnBoardingScreen
import com.saurabh.mynews.presentation.onboarding.OnBoardingViewModel
import com.saurabh.mynews.presentation.search.SearchScreen
import com.saurabh.mynews.presentation.search.SearchViewModel

@Composable
fun NavGraph(startDestination: String) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }
        }

        navigation(route = Route.NewsNavigation.route, startDestination = Route.NewsNavigatorScreen.route) {
           composable( route = Route.NewsNavigatorScreen.route){
               NewsNavigator()
           }
        }
    }
}