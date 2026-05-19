package com.example.movieexplorer.data.remote


import retrofit2.http.GET
import retrofit2.http.Query
import com.example.movieexplorer.BuildConfig

interface ApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        ) : MovieResponse
}