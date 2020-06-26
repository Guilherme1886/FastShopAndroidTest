package com.gui.antonio.testefastshop.dagger

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.gui.antonio.testefastshop.database.AppDatabase
import com.gui.antonio.testefastshop.database.MovieDao
import com.gui.antonio.testefastshop.datasource.MovieDataSource
import com.gui.antonio.testefastshop.repository.MovieRepository
import com.gui.antonio.testefastshop.view.activity.MainActivity
import com.gui.antonio.testefastshop.view.fragment.MoviesFragment
import com.gui.antonio.testefastshop.viewmodel.MainViewModel
import com.gui.antonio.testefastshop.viewmodel.factory.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideRepository(movieDataSource: MovieDataSource): MovieRepository {
        return MovieRepository(movieDataSource)
    }

    @Provides
    fun provideMovieDataSource(movieDao: MovieDao): MovieDataSource{
        return MovieDataSource(movieDao)
    }

    @Provides
    fun provideDB(context: Context): AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, "dbmovies").build()
    }

    @Provides
    fun provideMainViewModel(activity : MainActivity, context: Context) : MainViewModel{
        return ViewModelProvider(activity, MainViewModelFactory(provideRepository(provideMovieDataSource(provideDB(context).movieDao())))).get(MainViewModel::class.java)
    }
}