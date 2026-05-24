package com.example.movieexplorer.presentation.model

import androidx.annotation.ColorRes

data class MovieUiModel(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val ratingText: String,
    @ColorRes
    val ratingColor: Int,
    val posterUrl: String?
)
