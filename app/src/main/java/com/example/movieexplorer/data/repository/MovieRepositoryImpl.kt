package com.example.movieexplorer.data.repository

import com.example.movieexplorer.data.mapper.toDomain
import com.example.movieexplorer.data.remote.ApiService
import com.example.movieexplorer.domain.model.Movie
import com.example.movieexplorer.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: ApiService
): MovieRepository {
    override suspend fun getTrendingMovies(): List<Movie> {
        return api.getTrendingMovies()
            .results
            .map { it.toDomain() }
    }
}