package com.example.movieexplorer.domain.repository

import com.example.movieexplorer.domain.model.Movie

interface MovieRepository {
    suspend fun getTrendingMovies(): List<Movie>
}