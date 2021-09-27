package com.example.pruebakavak.domain.repositories

import com.example.pruebakavak.data.network.models.Book
import com.example.pruebakavak.data.network.models.Results
import com.example.pruebakavak.data.network.models.TypesOfBooks
import retrofit2.Response

interface GetBookListRepository {

    suspend fun getBookListRepository(
        apiKey : String
    ): Response<Results>
}