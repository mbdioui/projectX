package fr.leboncoin.projectx.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import fr.leboncoin.projectx.R
import fr.leboncoin.projectx.models.Track
import fr.leboncoin.projectx.ui.PhotoGridAdapter
import fr.leboncoin.projectx.viewModels.TracksStatus

@BindingAdapter("imageSrc")
fun bindImage(imgView: ImageView, imageSrc: String?) {
    imageSrc?.let {
        val imgUrl =
            GlideUrl(imageSrc, LazyHeaders.Builder().addHeader("User-Agent", "5").build())
        Glide.with(imgView.context)
            .load(imgUrl)
            .apply(
                RequestOptions().placeholder(R.drawable.loading_img)
                    .error(android.R.drawable.stat_notify_error)
            )
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, listData: List<Track>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(listData)
}

@BindingAdapter("status")
fun bindStatus(statusImageView: ImageView, trackStatus: TracksStatus) {
    when (trackStatus) {
        TracksStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_img)
        }

        TracksStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        else -> {
            statusImageView.visibility = View.GONE
        }
    }
}