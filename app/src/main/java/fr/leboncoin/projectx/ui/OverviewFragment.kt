package fr.leboncoin.projectx.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import fr.leboncoin.projectx.databinding.OverviewLayoutBinding
import fr.leboncoin.projectx.viewModels.TracksViewModel

class OverviewFragment : Fragment() {
    private lateinit var binding: OverviewLayoutBinding
    private lateinit var viewModel: TracksViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = OverviewLayoutBinding.inflate(inflater)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(
            TracksViewModel::class.java
        )
        binding.viewModel = viewModel
        binding.photosGrid.adapter =
            PhotoGridAdapter(PhotoGridAdapter.OnClickListener { viewModel.displayTrackDetails(it) })
        viewModel.navigateToSelectedTrack.observe(viewLifecycleOwner, Observer() {
            if (it != null) {
                this.findNavController().navigate(
                        OverviewFragmentDirections.actionOverviewFragmentToDetailTrackFragment(
                            it
                        )
                    )
                viewModel.displayTrackDetailsComplete()
            }
        })
        return binding.root
    }
}