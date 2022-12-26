package fr.leboncoin.projectx.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.leboncoin.projectx.dataBase.dao.TrackDao
import fr.leboncoin.projectx.models.Album
import fr.leboncoin.projectx.models.Track

@Database(entities = [Track::class, Album::class], version = 1, exportSchema = false)
abstract class MusicDataBase : RoomDatabase() {
    abstract fun getDao(): TrackDao

    companion object {
        private const val DATABASE_NAME = "Music DataBase"
        @Volatile
        var INSTANCE: MusicDataBase? = null

        fun getInstance(context: Context): MusicDataBase {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext, MusicDataBase::class.java, DATABASE_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
            }
            return instance
        }
    }
}