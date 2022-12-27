package fr.leboncoin.projectx.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import fr.leboncoin.projectx.databinding.DetailTrackBinding
import fr.leboncoin.projectx.viewModels.DetailTrackViewModel
import fr.leboncoin.projectx.viewModels.DetailViewModelFactory

@AndroidEntryPoint
class DetailTrackFragment : Fragment() {
    private lateinit var binding: DetailTrackBinding
    private val args: DetailTrackFragmentArgs by navArgs()
    private val detailViewModelFactory: DetailViewModelFactory by lazy {
        DetailViewModelFactory(args.selectedTrack)
    }
    val viewModel: DetailTrackViewModel by viewModels { detailViewModelFactory }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailTrackBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }
}