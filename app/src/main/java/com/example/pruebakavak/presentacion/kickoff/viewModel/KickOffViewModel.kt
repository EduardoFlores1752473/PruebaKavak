package com.example.pruebakavak.presentacion.kickoff.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.pruebakavak.data.network.models.Results
import com.example.pruebakavak.data.network.models.TypesOfBooks
import com.example.pruebakavak.data.utils.Configurations
import com.example.pruebakavak.domain.useCase.GetBookListUsesCase
import com.example.pruebakavak.presentacion.core.base.BaseViewModel
import com.example.pruebakavak.presentacion.core.callback.ResultCallBack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KickOffViewModel(

    private val getBookListUsesCase: GetBookListUsesCase,
    private val resultCallBack : ResultCallBack<String>


) : BaseViewModel() {

    var typesOfBooksMLD = MutableLiveData  <Results>()
    var typesOfBooksResponse: Results? = null

    init {
        getTypesOfBooks()

    }

    private fun getTypesOfBooks(){
        job = CoroutineScope(Dispatchers.IO).launch {
            typesOfBooksResponse = getBookListUsesCase.invoke(
               apiKey = Configurations.BOOK_APPI_KEY
            ).body()
            withContext(Dispatchers.Main){
                typesOfBooksResponse?.let {
                    typesOfBooksMLD.postValue(
                        it
                    )
                }
            }
        }
    }
}