package com.example.music_app_ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.music_app_ui.data.Screen

class MainViewModel: ViewModel() {

    private val _currentScreen: MutableState<Screen> = mutableStateOf(Screen.DrawerScreen.Account)

    val currentScreen: MutableState<Screen>
        get() = _currentScreen

    fun setCurrentScreen(screen: Screen) {
        _currentScreen.value = screen
    }
}