package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jelajah.ui.viewmodel.CountryViewModelFactory
import com.example.jelajah.ui.viewmodel.MainViewModel
import com.example.myapplication.ui.screen.DetailScreen
import com.example.myapplication.ui.screen.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = viewModel(
        factory = CountryViewModelFactory()
    )
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navHostController = navController, viewModel = viewModel)
        }
        composable("detail") {

            DetailScreen(viewModel, navController)
        }
    }
}