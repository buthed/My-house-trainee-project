package com.example.myhouse.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.model.AppStateCamera
import com.example.myhouse.model.repository.Repository

class CamerasViewModel(private val repository: Repository): ViewModel(), LifecycleObserver {
    private val liveDataToObserve: MutableLiveData<AppStateCamera> = MutableLiveData()
    fun getLiveData() = liveDataToObserve

    fun getCamerasFromLocalSource() {
        repository.getCamerasFromLocalStorage()
    }
}