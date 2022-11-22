package fr.leboncoin.projectx.dataBase

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import fr.leboncoin.projectx.dataBase.dao.TrackDao
import fr.leboncoin.projectx.models.Track
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

val tracksList = listOf(
    Track(id = 1L), Track(id = 2L), Track(id = 3L), Track(id = 4L), Track(id = 34L)
)
@RunWith(AndroidJUnit4::class)
class MusicDataBaseTest {

    private lateinit var trackDao: TrackDao
    private lateinit var dataBase: MusicDataBase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        dataBase = Room.inMemoryDatabaseBuilder(context, MusicDataBase::class.java)
            .allowMainThreadQueries().build()
        trackDao = dataBase.trackDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        dataBase.close()
    }

    @Test
    fun insertAndGetTrack_ExpectSameObject() {
        val track = Track(id = 3L)
        trackDao.insertTrack(track)
        runBlocking {
            val trackRetrieved = trackDao.getTrackById(id = 3L)
            Assert.assertEquals(trackRetrieved?.id, 3L)
        }
    }
    @Test
    fun insertAndGetTracks_ExpectNumberOfObjects() {
        trackDao.insertTracks(tracksList)
        runBlocking {
            val tracks = trackDao.getAllTracks()
            Assert.assertTrue(tracks.size == 5)
        }
    }
}
