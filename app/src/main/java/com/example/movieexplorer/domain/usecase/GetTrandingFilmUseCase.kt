package com.example.movieexplorer.domain.usecase

import com.example.movieexplorer.domain.repository.MovieRepository
import javax.inject.Inject

class GetTrandingFilmUseCase @Inject constructor(
    private val repo: MovieRepository
) {
    suspend operator fun invoke() = repo.getTrendingMovies()
}