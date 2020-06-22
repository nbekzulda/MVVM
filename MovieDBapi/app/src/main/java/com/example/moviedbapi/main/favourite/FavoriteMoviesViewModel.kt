package com.example.moviedbapi.main.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//import com.example.moviedbapi.additonal.launchSafe
import com.example.moviedbapi.base.ParentViewModel
import com.example.moviedbapi.data.models.MovieData
import com.example.moviedbapi.data.models.MovieResponseData
import com.example.moviedbapi.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FavoriteMoviesViewModel( private val movieRepository: MovieRepository) : ParentViewModel() {

    private val _liveData = MutableLiveData<State>()
    val liveData: LiveData<State>
        get() = _liveData


    fun loadFavMovies(accountId: Int?, sessionId: String?, page: Int = 1) {

        disposables.add(
            movieRepository.getFavoriteMovies(accountId, sessionId, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{
                    _liveData.value = State.ShowLoading
                }
                .doFinally {
                    _liveData.value = State.HideLoading
                }
                .subscribe{
                    val result = {
                        val response = movieRepository.getFavoriteMovies(
                            accountId,
                            sessionId,
                            page
                        ) as MovieResponseData
                        val list = response?.results ?: emptyList()
                        val totalPages = response?.totalPages ?: 0
                        Pair(totalPages, list)
                    } as Pair<Int, List<MovieData>>
                    _liveData.postValue(State.Result(totalPages = result.first, list = result.second ))
                }
        )


    }

    sealed class State {
        object ShowLoading: State()
        object HideLoading: State()
        data class Result(val totalPages: Int, val list: List<MovieData>): State()
        data class Error(val error: String?): State()
        data class IntError(val error: Int): State()
    }
}

