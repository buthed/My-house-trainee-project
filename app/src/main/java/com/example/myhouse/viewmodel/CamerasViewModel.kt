package com.example.myhouse.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.model.AppStateCamera
import com.example.myhouse.model.repository.Repository
import com.example.myhouse.model.repository.RepositoryImpl
import com.example.myhouse.model.rest.RemoteDataSource

class CamerasViewModel(
    val liveDataObserverCameras : MutableLiveData<AppStateCamera> = MutableLiveData(),
    val repository: Repository = RepositoryImpl(RemoteDataSource)): ViewModel(), LifecycleObserver {

    fun getLiveData() = liveDataObserverCameras

    fun getCamerasFromLocalSource() {
        repository.getCamerasFromLocalStorage()
    }
}