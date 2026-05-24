package com.example.movieexplorer.presentation.states

import com.example.movieexplorer.domain.model.Movie

sealed interface UiState {
    data object Loading: UiState
    data object Empty: UiState
    data class Error(val message: String): UiState
    data class Success(val movie: List<Movie>): UiState
}