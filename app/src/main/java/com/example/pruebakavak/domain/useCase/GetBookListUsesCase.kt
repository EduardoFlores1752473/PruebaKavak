package com.example.pruebakavak.domain.useCase

import com.example.pruebakavak.data.network.models.Book
import com.example.pruebakavak.data.network.models.Results
import com.example.pruebakavak.data.network.models.TypesOfBooks
import com.example.pruebakavak.domain.repositories.GetBookListRepository
import retrofit2.Response

class GetBookListUsesCase(

    private val getBookListRepository: GetBookListRepository
) {
    suspend fun invoke(
        apiKey: String
    ): Response<Results> {
        return getBookListRepository.getBookListRepository(
            apiKey = apiKey
        )
    }
}