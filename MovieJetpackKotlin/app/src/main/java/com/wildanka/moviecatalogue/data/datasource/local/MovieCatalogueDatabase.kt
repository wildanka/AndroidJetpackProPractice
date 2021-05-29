package com.wildanka.moviecatalogue.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wildanka.moviecatalogue.data.datasource.local.entity.*

@Database(entities = [FavoriteMovie::class, FavoriteTVShow::class, MovieCast::class, MovieData::class], version = 5, exportSchema = false)
abstract class MovieCatalogueDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao

    companion object {
        @Volatile
        private var INSTANCE: MovieCatalogueDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MovieCatalogueDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    MovieCatalogueDatabase::class.java,
                    "favorites_database"
                ).fallbackToDestructiveMigration().build()
            }
            return INSTANCE as MovieCatalogueDatabase
        }
    }
}