package com.wildanka.moviecatalogue.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wildanka.moviecatalogue.model.entity.*

@Database(entities = [FavoriteMovie::class, TVShowData::class], version = 1, exportSchema = false)
abstract class MovieCatalogueDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao

    companion object {
        @Volatile
        private var INSTANCE: MovieCatalogueDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MovieCatalogueDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<MovieCatalogueDatabase>(
                    context.applicationContext,
                    MovieCatalogueDatabase::class.java!!,
                    "favorites_database"
                ).fallbackToDestructiveMigration().build()
            }
            return INSTANCE as MovieCatalogueDatabase
        }

        fun getDatabase(context: Context): MovieCatalogueDatabase? {
            if (INSTANCE == null) {
                synchronized(MovieCatalogueDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            MovieCatalogueDatabase::class.java, "favorites_database"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}