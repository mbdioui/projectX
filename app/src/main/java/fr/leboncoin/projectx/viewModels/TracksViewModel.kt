package fr.leboncoin.projectx.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.leboncoin.projectx.models.Track
import fr.leboncoin.projectx.network.TracksApi
import kotlinx.coroutines.launch

enum class TracksStatus { DONE, LOADING, ERROR }

class TracksViewModel : ViewModel() {

    private val _status = MutableLiveData<TracksStatus>()
    val status: LiveData<TracksStatus>
        get() = _status

    private val _tracks = MutableLiveData<List<Track>>()
    val tracks: LiveData<List<Track>>
        get() = _tracks

    private val _navigateToSelectedTrack = MutableLiveData<Track?>()

    val navigateToSelectedTrack: LiveData<Track?>
        get() = _navigateToSelectedTrack

    init {
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
                val result = TracksApi.retrofitService.getTracks()
                if (result.isNotEmpty()) _tracks.value = result
                _status.value = TracksStatus.DONE
            } catch (throwable: Throwable) {
                _status.value = TracksStatus.ERROR
                _tracks.value = ArrayList()
                Log.i("TracksViewModel", "Error while loading tracks")
            }
        }
    }
}