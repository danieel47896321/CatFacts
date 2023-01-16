package com.example.catfacts.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.catfacts.api.CatModel
import com.example.catfacts.network.ApiClient
import com.example.catfacts.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FactRepository {
    private var apiService: ApiService = ApiClient.getRetrofit()?.create(ApiService::class.java)!!
    fun getFact(): LiveData<CatModel>{
        val data: MutableLiveData<CatModel> = MutableLiveData()
        apiService.getRandomCatFacts().enqueue(object: Callback<CatModel> {
            override fun onResponse(call: Call<CatModel>, response: Response<CatModel>) {
                data.value = response.body()
            }
            override fun onFailure(call: Call<CatModel>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}