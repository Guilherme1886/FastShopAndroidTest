package com.gui.antonio.testefastshop.view.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.gui.antonio.testefastshop.R
import com.gui.antonio.testefastshop.databinding.FragmentMovieDetailsBinding
import com.gui.antonio.testefastshop.databinding.FragmentMoviesBinding
import com.gui.antonio.testefastshop.view.activity.MainActivity
import java.lang.StringBuilder

class MovieDetailsFragment : Fragment() {

    lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let { bundle ->
            bundle?.getInt("id")?.let { id ->
                (activity as MainActivity).viewModel.movieDetails(id)
                    .observe(this, Observer { details ->
                        Log.v("TAG", details.posterPath)
                        binding.movie = details
                        Glide.with(binding.ivFilm).load("http://image.tmdb.org/t/p/w200/${details.posterPath}").into(binding.ivFilm)
                        val s = StringBuilder()
                        details.genres?.forEach {
                            s.append("${it.name}\n")
                        }
                        binding.tvGenres.text = s
                    })
            }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["url"])
        fun setImage(imageView: ImageView, url: String) = Glide.with(imageView).load("http://image.tmdb.org/t/p/w200/$url").into(imageView)
    }
}