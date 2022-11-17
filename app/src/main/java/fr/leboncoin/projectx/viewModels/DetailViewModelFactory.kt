package fr.leboncoin.projectx.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.leboncoin.projectx.models.Track

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(private val track: Track) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailTrackViewModel::class.java)) {
            return DetailTrackViewModel(track) as T
        }
        throw java.lang.IllegalArgumentException("unknown ViewModel class")
    }
}