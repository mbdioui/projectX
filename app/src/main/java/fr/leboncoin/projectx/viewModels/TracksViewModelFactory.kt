package fr.leboncoin.projectx.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.leboncoin.projectx.dataBase.MusicDataBase

@Suppress("UNCHECKED_CAST")
class TracksViewModelFactory(
    private val application: Application,
    private val dataBase: MusicDataBase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TracksViewModel::class.java)) {
            return TracksViewModel(application, dataBase) as T
        }
        throw java.lang.IllegalArgumentException("unknown ViewModel class")
    }
}