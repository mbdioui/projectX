package fr.leboncoin.projectx.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fr.leboncoin.projectx.databinding.DetailTrackBinding
import fr.leboncoin.projectx.viewModels.DetailTrackViewModel
import fr.leboncoin.projectx.viewModels.DetailViewModelFactory

class DetailTrackFragment : Fragment() {
    private lateinit var binding: DetailTrackBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailTrackBinding.inflate(inflater)
        binding.lifecycleOwner = this
        arguments?.let {
            val selectedTrack = DetailTrackFragmentArgs.fromBundle(it).selectedTrack
            val viewModelFactory = DetailViewModelFactory(selectedTrack)
            binding.viewModel =
                ViewModelProvider(this, viewModelFactory).get(DetailTrackViewModel::class.java)
        }

        return binding.root
    }
}