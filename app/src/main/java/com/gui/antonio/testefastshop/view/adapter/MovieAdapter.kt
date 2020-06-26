package com.gui.antonio.testefastshop.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gui.antonio.testefastshop.R
import com.gui.antonio.testefastshop.databinding.ItemMovieBinding
import com.gui.antonio.testefastshop.datasource.Movie

class MovieAdapter(val movies: List<Movie>, val onClickMovie: OnClickMovie) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {


    class MyViewHolder(val view: ItemMovieBinding, val onClickMovie: OnClickMovie) : RecyclerView.ViewHolder(view.root) {
        fun bind(movie: Movie) {
            view.movie = movie
            view.root.setOnClickListener { movie.id?.let { it1 -> onClickMovie.onClick(it1) } }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemMovieBinding: ItemMovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
        return MyViewHolder(itemMovieBinding, onClickMovie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["urlOfImage"])
        fun setImage(imageView: ImageView, urlOfImage: String) = Glide.with(imageView).load("http://image.tmdb.org/t/p/w200/$urlOfImage").into(imageView)
    }

    interface OnClickMovie {
        fun onClick(id: Int)
    }
}