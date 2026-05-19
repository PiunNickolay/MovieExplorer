package com.example.movieexplorer.data.di

import com.example.movieexplorer.BuildConfig
import com.example.movieexplorer.data.remote.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlin.math.log

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideApi(): ApiService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val logging = HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .addHeader("Authorization", "Bearer ${BuildConfig.TMDB_API_KEY}")
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(logging)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiService::class.java)
    }
}