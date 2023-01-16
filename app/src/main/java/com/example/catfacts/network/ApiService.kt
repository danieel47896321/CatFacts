package com.example.catfacts.network

import com.example.catfacts.api.CatModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET ("/facts/random")
    fun getRandomCatFacts(): Call<CatModel>
}