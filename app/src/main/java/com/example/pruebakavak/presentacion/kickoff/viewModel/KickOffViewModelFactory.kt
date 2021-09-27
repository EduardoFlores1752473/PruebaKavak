package com.example.pruebakavak.presentacion.kickoff.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pruebakavak.domain.useCase.GetBookListUsesCase
import com.example.pruebakavak.presentacion.core.callback.ResultCallBack

class KickOffViewModelFactory(

    private val getBookListUsesCase : GetBookListUsesCase,
    private val resultCallBack: ResultCallBack<String>

): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return KickOffViewModel(
            getBookListUsesCase,
            resultCallBack
        ) as T
    }
}