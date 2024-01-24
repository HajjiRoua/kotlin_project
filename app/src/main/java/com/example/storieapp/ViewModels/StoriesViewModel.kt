package com.example.storieapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storieapp.API.storiesAPI
import kotlinx.coroutines.launch
import com.example.storieapp.API.Result
class storiesViewModel : ViewModel() {
    private val storiesService = storiesAPI.create();
    val storieListNames: Array<String>  = arrayOf("home", "business", "arts")
    private val _storiesList: MutableLiveData<List<Result>> by lazy { MutableLiveData<List<Result>>() }
    val storiesList: LiveData<List<Result>> = _storiesList;

    fun setstorieListValue(storieListName: String) {
        viewModelScope.launch {
            try {
                val res = storiesService.getstorieList(storieListName)
                println(res)
                _storiesList.value = res.results;
            } catch (e: Exception) {
                println(e)
            }
        }
    }

}