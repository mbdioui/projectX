package fr.leboncoin.projectx.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.leboncoin.projectx.models.Track

class DetailTrackViewModel(track: Track) : ViewModel() {
    private val _selectedTrack = MutableLiveData<Track>()

    // The external LiveData for the SelectedProperty
    val selectedTrack: LiveData<Track>
        get() = _selectedTrack

    // Initialize the _selectedProperty MutableLiveData
    init {
        Log.i(javaClass.name, track.id.toString())
        _selectedTrack.value = track
    }
}