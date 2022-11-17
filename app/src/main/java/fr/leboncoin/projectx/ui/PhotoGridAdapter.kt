package fr.leboncoin.projectx.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.leboncoin.projectx.databinding.TrackViewItemBinding
import fr.leboncoin.projectx.models.Track

class PhotoGridAdapter(val onClickListener: OnClickListener) :
    ListAdapter<Track, PhotoGridAdapter.TrackViewHolder>(DiffCallback) {
    class TrackViewHolder(private var binding: TrackViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(track: Track) {
            binding.track = track
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (track: Track) -> Unit) {
        fun onClick(track: Track) = clickListener(track)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Track>() {
        override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        return TrackViewHolder(TrackViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(track)
        }
        holder.bind(track)
    }
}