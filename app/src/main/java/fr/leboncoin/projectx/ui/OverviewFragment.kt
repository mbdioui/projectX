package fr.leboncoin.projectx.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.leboncoin.projectx.databinding.OverviewLayoutBinding
import fr.leboncoin.projectx.viewModels.TracksViewModel

@AndroidEntryPoint
class OverviewFragment : Fragment() {
    private lateinit var binding: OverviewLayoutBinding
    private val viewModel: TracksViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = OverviewLayoutBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter =
            PhotoGridAdapter(PhotoGridAdapter.OnClickListener { viewModel.displayTrackDetails(it) })
        viewModel.navigateToSelectedTrack.observe(viewLifecycleOwner) {
            if (it != null) {
                this.findNavController().navigate(
                    OverviewFragmentDirections.actionOverviewFragmentToDetailTrackFragment(
                        it
                    )
                )
                viewModel.displayTrackDetailsComplete()
            }
        }
        return binding.root
    }
}