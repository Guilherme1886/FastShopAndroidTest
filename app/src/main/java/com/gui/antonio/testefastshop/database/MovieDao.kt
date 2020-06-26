package com.gui.antonio.testefastshop.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gui.antonio.testefastshop.datasource.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getAll() : List<Movie>

    @Insert
    fun insertAll(movie: List<Movie>)

    @Query("DELETE FROM Movie")
    fun deleteAll()

}