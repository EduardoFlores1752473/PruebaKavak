package com.example.pruebakavak.data.utils

import android.content.res.Configuration

class Configurations {

    companion object{


        const val BOOK_APPI_KEY = "https://raw.githubusercontent.com/ejgteja/files/"
    }

    private val courentConfiguration = "dev"
    private val configuration = mapOf(
        "dev" to Configuration(
            baseUrl = "https://raw.githubusercontent.com/ejgteja/files/"
        ),
        "qa" to Configuration(
            baseUrl = "https://raw.githubusercontent.com/ejgteja/files/"
        ),
        "release" to Configuration(
            baseUrl = "https://raw.githubusercontent.com/ejgteja/files/"
        )
    )

    private var baseURL : String = ""

    init {
        val selectConfig = configuration[courentConfiguration]
        selectConfig?.baseUrl?.let {
            baseURL=it
        }
    }

    fun getBaseUrl(): String =baseURL
}

private data class Configuration(
    val baseUrl : String= ""
)