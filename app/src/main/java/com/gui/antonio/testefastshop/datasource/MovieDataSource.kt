package com.gui.antonio.testefastshop.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gui.antonio.testefastshop.database.MovieDao
import com.gui.antonio.testefastshop.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDataSource(private val movieDao: MovieDao) {

    val error = MutableLiveData<String>()

    fun movies(): LiveData<List<Movie>> {
        val data = MutableLiveData<List<Movie>>()
        RetrofitClient.retrofit.getMovies().enqueue(object : Callback<Movies> {
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                error.value = t.message
            }

            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.isSuccessful) {
                    response.body().let { movies ->
                        movies?.results?.let { results ->
                            CoroutineScope(Dispatchers.IO).launch {
                                movieDao.deleteAll()
                                movieDao.insertAll(results)
                                data.postValue(movieDao.getAll())
                            }
                        }
                    }
                } else {
                    error.value = response.message()
                }
            }
        })
        return data
    }

    fun movieDetails(id: Int) : LiveData<MovieDetails> {

        val data = MutableLiveData<MovieDetails>()

        RetrofitClient.retrofit.getDetailsMovie(id).enqueue(object : Callback<MovieDetails> {
            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                error.value = t.message
            }

            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                if (response.isSuccessful) { response.body().let { data.value = it } }
            }

        })

        return data
    }
}