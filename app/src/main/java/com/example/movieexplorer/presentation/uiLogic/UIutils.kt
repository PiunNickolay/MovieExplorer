package com.example.movieexplorer.presentation.uiLogic

import androidx.annotation.ColorRes
import com.example.movieexplorer.R
import com.example.movieexplorer.domain.model.Movie
import com.example.movieexplorer.presentation.model.MovieUiModel

@ColorRes
fun changeRatingColour (rating: Double): Int {
    return when (rating) {
        in 0.0..6.0 -> R.color.red
        in 6.1..7.0 -> R.color.yellow
        in 7.1..8.0 -> R.color.light_green
        in 8.1..9.0 -> R.color.green
        in 9.1..10.0 -> R.color.dark_green
        else -> R.color.black
    }
}

fun Movie.toUi(): MovieUiModel = MovieUiModel (
    id = id,
    title = title,
    overview = overview,
    releaseDate = releaseDate,
    ratingText = "%.1f".format(rating),
    ratingColor = changeRatingColour(rating),
    posterUrl = posterUrl
)