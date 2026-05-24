package com.example.movieexplorer.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieexplorer.databinding.MovieCardBinding
import com.example.movieexplorer.domain.model.Movie
import com.example.movieexplorer.presentation.model.MovieUiModel
import com.example.movieexplorer.presentation.uiLogic.changeRatingColour


class MovieAdapter: ListAdapter<MovieUiModel, MovieViewHolder>(MovieDiffCallback){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val binding = MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        holder.bind(item)
    }

}

class MovieViewHolder(
    private val binding: MovieCardBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieUiModel) {
        with(binding) {
            filmsName.text = movie.title
            overview.text = movie.overview
            date.text = movie.releaseDate
            ratingCount.text = movie.ratingText
            val color = ContextCompat.getColor(
                root.context,
                movie.ratingColor
            )
            rating.setColorFilter(color)
            Glide
                .with(root.context)
                .load(movie.posterUrl)
                .into(filmsPoster)
        }
    }
}

object MovieDiffCallback: DiffUtil.ItemCallback<MovieUiModel>() {
    override fun areItemsTheSame(
        oldItem: MovieUiModel,
        newItem: MovieUiModel
    ): Boolean = oldItem.id == newItem.id


    override fun areContentsTheSame(
        oldItem: MovieUiModel,
        newItem: MovieUiModel
    ): Boolean = oldItem == newItem
}