package com.gui.antonio.testefastshop.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gui.antonio.testefastshop.datasource.Movie

@Database(entities = [Movie::class],version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}