package com.example.catfacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.catfacts.api.CatModel
import com.example.catfacts.repository.FactRepository

class FactViewModel: ViewModel() {
    private var factRepository = FactRepository()
    private var factList = ArrayList<CatModel>()
    fun getFact(): LiveData<CatModel>{
        return factRepository.getFact()
    }
    fun getList(): ArrayList<CatModel> { return factList }
}