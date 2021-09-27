package com.example.pruebakavak.presentacion.booklist.viewModel

import com.example.pruebakavak.domain.useCase.GetBookListUsesCase
import com.example.pruebakavak.presentacion.core.base.BaseViewModel

class BookListViewModel(

    private val getBookListUsesCase: GetBookListUsesCase
): BaseViewModel(){

}