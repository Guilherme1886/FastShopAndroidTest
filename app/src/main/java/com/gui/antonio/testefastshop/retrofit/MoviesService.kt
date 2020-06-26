package com.gui.antonio.testefastshop.retrofit

import com.gui.antonio.testefastshop.datasource.MovieDetails
import com.gui.antonio.testefastshop.datasource.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {
    @GET("3/movie/popular?api_key=fac4a7ec8d035dcafe286348aabee4a1")
    fun getMovies(): Call<Movies>

    @GET("3/movie/{movie_id}?api_key=fac4a7ec8d035dcafe286348aabee4a1")
    fun getDetailsMovie(@Path(value = "movie_id") id: Int): Call<MovieDetails>
}
