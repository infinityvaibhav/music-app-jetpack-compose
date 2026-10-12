package com.example.music_app_ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.music_app_ui.R
import com.example.music_app_ui.components.HomeItemView

@Composable
fun HomeView() {
    val categories = listOf("Hits", "Happy", "Workout", "Yoga", "Running", "TGIF")
    val grouped = listOf("New Release", "Favorites", "Top Rated").groupBy { it[0] }
    LazyColumn {
        grouped.forEach { item: Map.Entry<Char, List<String>> ->
            stickyHeader {
                Text(text = item.value[0], modifier = Modifier.padding(8.dp))
                LazyRow {
                    items(categories) { category ->
                        HomeItemView(category = category, drawable = R.drawable.baseline_library_music_24)
                    }
                }
            }
        }
    }
}