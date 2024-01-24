package com.example.storieapp.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.storieapp.Utils.ConnectivityRepository

class ConnectivityViewModal(private val connectivityRepository: ConnectivityRepository): ViewModel() {
        val isOnline = connectivityRepository.isConnected.asLiveData()
}

class ConnectivityViewModelFactory(private val customParam: ConnectivityRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(ConnectivityViewModal::class.java)) {
                        @Suppress("UNCHECKED_CAST")
                        return ConnectivityViewModal(customParam) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
        }
}