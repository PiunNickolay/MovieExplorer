package com.example.movieexplorer.domain

interface Reporitory {
    suspend fun getTrendingMovies(): List<Movie>
}