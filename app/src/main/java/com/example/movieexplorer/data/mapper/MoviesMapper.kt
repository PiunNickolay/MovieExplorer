package com.example.movieexplorer.data.mapper

import com.example.movieexplorer.data.NetworkConstants.NetworkConstants.IMAGE_BASE_URL
import com.example.movieexplorer.data.remote.MovieDto
import com.example.movieexplorer.domain.model.Movie

fun MovieDto.toDomain(): Movie = Movie(
    id = id,
    title = title,
    overview = overview,
    posterUrl = IMAGE_BASE_URL + posterPath,
    rating = voteAverage,
    releaseDate = releaseDate
)