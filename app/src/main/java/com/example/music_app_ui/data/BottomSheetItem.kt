package com.example.music_app_ui.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomSheetItem(
    val title: String,
    val icon: ImageVector
)

val bottomSheetItems = listOf(
    BottomSheetItem("Settings", Icons.Default.Settings),
    BottomSheetItem("Share", Icons.Default.Share),
    BottomSheetItem("Help", Icons.AutoMirrored.Filled.Help)
)
