package com.gui.antonio.testefastshop.viewmodel

import androidx.lifecycle.ViewModel
import com.gui.antonio.testefastshop.repository.MovieRepository
import javax.inject.Inject

class MainViewModel @Inject constructor (private val movieRepository: MovieRepository) : ViewModel() {
    fun movies() = movieRepository.movies()
    fun movieDetails(id: Int) = movieRepository.movieDetails(id)
}