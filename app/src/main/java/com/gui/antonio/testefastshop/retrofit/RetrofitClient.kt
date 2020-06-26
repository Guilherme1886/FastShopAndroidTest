package com.gui.antonio.testefastshop.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient { val retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org").addConverterFactory(GsonConverterFactory.create()).build().create(MoviesService::class.java) }