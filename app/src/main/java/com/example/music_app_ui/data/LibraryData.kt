package com.example.music_app_ui.data

import androidx.annotation.DrawableRes
import com.example.music_app_ui.R

data class LibraryData(
    @DrawableRes val icon: Int,
    val name: String
)

val libraries = listOf<LibraryData>(
    LibraryData(R.drawable.outline_playlist_play_24, "Playlist"),
    LibraryData(R.drawable.outline_artist_24, "Artist"),
    LibraryData(R.drawable.outline_album_24, "Album"),
    LibraryData(R.drawable.outline_music_note_24, "Songs"),
    LibraryData(R.drawable.outline_genres_24, "Genre"),
)