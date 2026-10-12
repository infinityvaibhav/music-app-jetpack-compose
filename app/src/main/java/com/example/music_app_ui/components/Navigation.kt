package com.example.music_app_ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.music_app_ui.data.Screen
import com.example.music_app_ui.data.screensInDrawer
import com.example.music_app_ui.screens.AccountView
import com.example.music_app_ui.screens.BrowseView
import com.example.music_app_ui.screens.HomeView
import com.example.music_app_ui.screens.LibraryView
import com.example.music_app_ui.screens.SubscriptionView

@Composable
fun Navigation(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = screensInDrawer.first().route,
        modifier = Modifier.padding(padding)
    ) {
        composable(Screen.DrawerScreen.Account.route) {
            AccountView()
        }
        composable(Screen.DrawerScreen.Subscription.route) {
            SubscriptionView()
        }
        composable(Screen.BottomScreen.Home.route) {
            HomeView()
        }
        composable(Screen.BottomScreen.Browse.route) {
            BrowseView()
        }
        composable(Screen.BottomScreen.Library.route) {
            LibraryView()
        }
    }
}