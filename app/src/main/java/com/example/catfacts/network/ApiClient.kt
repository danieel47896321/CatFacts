package com.example.catfacts.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        private var retrofit: Retrofit? = null
        fun getRetrofit(): Retrofit? {
            if(retrofit == null){
                retrofit = Retrofit.Builder().baseUrl("https://cat-fact.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }
    }
}