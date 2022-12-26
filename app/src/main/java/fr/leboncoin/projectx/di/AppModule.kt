package fr.leboncoin.projectx.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.leboncoin.projectx.dataBase.MusicDataBase
import fr.leboncoin.projectx.dataBase.dao.TrackDao
import fr.leboncoin.projectx.network.TrackApiService
import fr.leboncoin.projectx.network.tracksApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppDB(context: Application): MusicDataBase {
        return MusicDataBase.getInstance(context)
    }
    @Provides
    @Singleton
    fun provideDao(musicDataBase: MusicDataBase): TrackDao {
        return musicDataBase.getDao()
    }
    @Provides
    @Singleton
    fun provideApi(): TrackApiService = tracksApi()

}