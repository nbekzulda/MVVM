package com.example.moviedbapi.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class ParentViewModel : ViewModel() {


    protected var disposables = CompositeDisposable()


    override fun onCleared() {

        disposables.clear()
        super.onCleared()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun removeDisposables(){
        disposables.clear()
    }
}