package com.example.storieapp.API

import retrofit2.http.GET
import retrofit2.http.Path

interface storiesService {
    @GET("{section}.json")
    suspend fun getstorieList(@Path("section") section: String): stories

}