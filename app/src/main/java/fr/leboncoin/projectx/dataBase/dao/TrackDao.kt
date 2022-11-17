package fr.leboncoin.projectx.dataBase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import fr.leboncoin.projectx.models.Track

@Dao
interface TrackDao {
    @Insert(onConflict = REPLACE)
    fun insertTrack(Track: Track)

    @Insert(onConflict = REPLACE)
    fun insertTracks(Tracks: List<Track>)

    @Query("SELECT * from Track")
    fun getAllTracks(): LiveData<List<Track>>

    @Query("SELECT * from Track where id= :id")
    fun getTrackById(id: Long): Track?
}