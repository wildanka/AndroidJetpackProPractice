package com.wildanka.moviecatalogue

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import com.wildanka.moviecatalogue.favorite.model.db.MovieCatalogueDatabase
import org.junit.Before

open class FavoritesDaoTest {
    private lateinit var moviewCatalogueDatabase: MovieCatalogueDatabase

    @Before
    fun initDb() {
        moviewCatalogueDatabase = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(), MovieCatalogueDatabase::class.java
        ).build()
    }
}