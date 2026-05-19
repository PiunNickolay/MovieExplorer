package com.example.movieexplorer.domain

data class Movie (
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val mediaType: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val softcore: Boolean,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)