package com.example.pruebakavak.presentacion.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel(){

    var job : Job? = null

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}