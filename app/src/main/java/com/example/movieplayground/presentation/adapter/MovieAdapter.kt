package com.example.movieplayground.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movieplayground.databinding.ItemMovieBinding
import com.example.movieplayground.domain.models.MovieItem

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val itemBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem

        }
    }
    private val differ = AsyncListDiffer(this, differCallback)
    var listMovies: List<MovieItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val currentMovie = listMovies[position]

        holder.itemBinding.apply {
            titleMovie.text = currentMovie.name
            imageMovie.load(currentMovie.image?.original) {
                crossfade(true)
                crossfade(1000)

            }
        }
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

}