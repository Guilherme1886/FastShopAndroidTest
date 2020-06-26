package com.gui.antonio.testefastshop.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gui.antonio.testefastshop.repository.MovieRepository
import com.gui.antonio.testefastshop.viewmodel.MainViewModel
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}