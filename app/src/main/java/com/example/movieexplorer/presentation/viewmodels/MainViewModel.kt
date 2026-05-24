package com.example.movieexplorer.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieexplorer.domain.usecase.GetTrandingFilmUseCase
import com.example.movieexplorer.presentation.states.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTrendingMovieUseCase: GetTrandingFilmUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state = _state.asStateFlow()

    init {
        loadTrendingMovies()
    }

    fun loadTrendingMovies() {
        viewModelScope.launch {

            _state.value = UiState.Loading

            try {
                val movies = getTrendingMovieUseCase()

                _state.value = if (movies.isEmpty()) {
                    UiState.Empty
                } else {
                    UiState.Success(movies)
                }
            } catch (e: IOException) {
                _state.value = UiState.Error("No internet connection")
            } catch (e: HttpException) {
                _state.value = UiState.Error("Server error")
            } catch (e: Exception) {
                _state.value = UiState.Error("Unknow error")
            }
        }
    }
}