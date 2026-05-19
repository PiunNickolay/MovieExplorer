package com.example.movieexplorer.data.remote


import com.google.gson.internal.GsonBuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1MjYyYWY3MzdhNTc0ZDljNTAyN2VmMjhlNWMyNmMzOCIsIm5iZiI6MTc3ODk1NzMyNC4zNzc5OTk4LCJzdWIiOiI2YTA4YmMwYzlkN2FiMzBhZmVkZTJlODkiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.gNRJ7Fyuze460exMH4XC5yqp41M-aLwiSeKkbmZBpkE"
        ) : FilmsResponse
}