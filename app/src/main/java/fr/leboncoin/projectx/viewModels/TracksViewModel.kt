package fr.leboncoin.projectx.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import fr.leboncoin.projectx.dataBase.MusicDataBase
import fr.leboncoin.projectx.dataBase.dao.TrackDao
import fr.leboncoin.projectx.models.Track
import fr.leboncoin.projectx.network.TracksApi
import kotlinx.coroutines.launch

enum class TracksStatus { DONE, LOADING, ERROR }

class TracksViewModel(application: Application, dataBase: MusicDataBase) :
    AndroidViewModel(application) {

    private val _status = MutableLiveData<TracksStatus>()
    val status: LiveData<TracksStatus>
        get() = _status

    private val _tracks = MutableLiveData<List<Track>>()
    val tracks: LiveData<List<Track>>
        get() = _tracks

    private val _navigateToSelectedTrack = MutableLiveData<Track?>()
    private var musicDataBase: MusicDataBase
    private var tracksDao: TrackDao

    val navigateToSelectedTrack: LiveData<Track?>
        get() = _navigateToSelectedTrack

    init {
        musicDataBase = dataBase
        tracksDao = musicDataBase.trackDao
        getTracks()
    }

    fun displayTrackDetails(trackProperty: Track) {
        _navigateToSelectedTrack.value = trackProperty
    }

    fun displayTrackDetailsComplete() {
        _navigateToSelectedTrack.value = null
    }

    private fun getTracks() {
        viewModelScope.launch {
            _status.value = TracksStatus.LOADING
            try {
                var result: List<Track>
                val tracksFromDataBase = tracksDao.getAllTracks()
                result = tracksFromDataBase
                Log.i("TracksViewModel", "getting tracks from Room database $tracksFromDataBase")
                if (tracksFromDataBase.isEmpty()) {
                    result = TracksApi.retrofitService.getTracks()
                    Log.i("TracksViewModel", "getting tracks from API ")
                    tracksDao.insertTracks(result)
                }
                if (result.isNotEmpty()) _tracks.value = result
                _status.value = TracksStatus.DONE
            } catch (throwable: Throwable) {
                _status.value = TracksStatus.ERROR
                _tracks.value = ArrayList()
                Log.i("TracksViewModel", "Error while loading tracks ,$throwable")
            }
        }
    }
}