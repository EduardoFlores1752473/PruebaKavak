package com.example.pruebakavak.data.network.services

import com.example.pruebakavak.data.network.models.Results
import com.example.pruebakavak.data.network.models.TypesOfBooks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookServices {

    @GET(value = "main/books.json")

    suspend fun getBookListAAPL(
        @Query(value = "apikey")
        apiKey:String,


    ): Response<Results>

}