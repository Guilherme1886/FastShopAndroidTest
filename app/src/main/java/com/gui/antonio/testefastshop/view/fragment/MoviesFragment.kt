package com.gui.antonio.testefastshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gui.antonio.testefastshop.R
import com.gui.antonio.testefastshop.view.activity.MainActivity
import com.gui.antonio.testefastshop.view.adapter.MovieAdapter
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment(), MovieAdapter.OnClickMovie {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).viewModel.movies().observe(this, Observer {
            rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            rv.adapter = MovieAdapter(it, this)
        })

    }

    override fun onClick(id: Int) {
        val args = Bundle()
        args.putInt("id", id)
        findNavController().navigate(R.id.action_moviesFragment_to_movieDetailsFragment, args)
    }

}