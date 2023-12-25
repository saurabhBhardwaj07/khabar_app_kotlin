package com.saurabh.mynews.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.saurabh.mynews.presentation.onboarding.OnBoardingScreen
import com.saurabh.mynews.presentation.onboarding.OnBoardingViewModel

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
//                    OnBoardingScreen(onEvent = {
//                        viewModel.onEvent(it)
//                    })
            }
        }

        navigation(route = Route.NewsNavigation.route, startDestination = Route.HomeScreen.route) {
            composable(route = Route.HomeScreen.route) {
                Text(text = "HomeScreen")
            }
//            composable(route = Route.SearchScreen.route) {
//
//            }
//            composable(route = Route.BookmarkScreen.route) {
//
//            }
//            composable(route = Route.DetailsScreen.route) {
//
//            }

        }
    }
}