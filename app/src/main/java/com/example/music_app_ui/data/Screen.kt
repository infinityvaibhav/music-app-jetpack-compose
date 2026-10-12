package com.example.music_app_ui.data

import androidx.annotation.DrawableRes
import com.example.music_app_ui.R

sealed class Screen(val title: String, val route: String) {

    sealed class BottomScreen(title: String,
                              route: String,
                              @DrawableRes val icon: Int) : Screen(title, route) {
        object Home: BottomScreen(
            "Home",
            "home",
            R.drawable.baseline_home_24
        )

        object Library: BottomScreen(
            "Library",
            "library",
            R.drawable.baseline_library_music_24
        )

        object Browse: BottomScreen(
            "Browse",
            "browse",
            R.drawable.outline_browse_24
        )
    }

    sealed class DrawerScreen(title: String,
                              route: String,
                              @DrawableRes val icon: Int) : Screen(title, route) {
        object Account : DrawerScreen(
            "Account",
            "account",
            R.drawable.baseline_account_circle_24,
        )

        object Subscription : DrawerScreen(
            "Subscription",
            "subscribe",
            R.drawable.baseline_library_music_24,
        )

        object AddAccount : DrawerScreen(
            "Add Account",
            "add_account",
            R.drawable.baseline_person_add_alt_1_24,
        )
    }

    companion object {

    }
}

val bottomNavItems = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Browse,
    Screen.BottomScreen.Library
)

val screensInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscription,
    Screen.DrawerScreen.AddAccount
)

val allScreens: List<Screen> = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscription,
    Screen.DrawerScreen.AddAccount,
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Browse,
    Screen.BottomScreen.Library
)