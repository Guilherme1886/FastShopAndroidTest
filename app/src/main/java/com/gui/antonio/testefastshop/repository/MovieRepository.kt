package com.gui.antonio.testefastshop.repository

import com.gui.antonio.testefastshop.datasource.MovieDataSource
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDataSource: MovieDataSource) {
    fun movies() = movieDataSource.movies()
    fun movieDetails(id: Int) = movieDataSource.movieDetails(id)
}