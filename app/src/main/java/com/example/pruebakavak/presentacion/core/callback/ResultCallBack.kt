package com.example.pruebakavak.presentacion.core.callback

interface ResultCallBack <T> {

    fun onSucces(type: T)
    fun onError (message : String,type:T? = null)
}