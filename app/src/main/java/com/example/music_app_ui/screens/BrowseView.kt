package com.example.music_app_ui.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import com.example.music_app_ui.R
import com.example.music_app_ui.components.HomeItemView

@Composable
fun BrowseView() {
    val categories = listOf("Hits", "Happy", "Workout", "Yoga", "Running", "TGIF")
    LazyVerticalGrid(GridCells.Fixed(2)) {
        items(categories) {
            HomeItemView(category = it, drawable = R.drawable.baseline_library_music_24)
        }
    }
}