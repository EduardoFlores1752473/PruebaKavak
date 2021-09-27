package com.example.pruebakavak.data.network.repositories

import com.example.pruebakavak.data.network.NetworkModule
import com.example.pruebakavak.data.network.models.Book
import com.example.pruebakavak.data.network.models.Results
import com.example.pruebakavak.data.network.models.TypesOfBooks
import com.example.pruebakavak.data.network.services.BookServices
import com.example.pruebakavak.data.utils.Configurations
import com.example.pruebakavak.domain.repositories.GetBookListRepository
import retrofit2.Response

class KickOffNetworkRepository() : GetBookListRepository {

    private val retrofitInstance = NetworkModule().provideRetrofit(baseUrl = Configurations().getBaseUrl())

    override suspend fun getBookListRepository(
        apiKey: String,

    ): Response<Results> {

        return NetworkModule().provideApi(
            retrofit = retrofitInstance,
            service = BookServices::class.java
        ).getBookListAAPL(
            apiKey = apiKey,

        )
    }

}