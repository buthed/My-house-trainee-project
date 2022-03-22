package com.example.myhouse.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.model.AppStateDoors
import com.example.myhouse.model.repository.Repository
import com.example.myhouse.model.repository.RepositoryImpl
import com.example.myhouse.model.rest.RemoteDataSource

class DoorsViewModel(
    val liveDataObserverCameras : MutableLiveData<AppStateDoors> = MutableLiveData(),
    val repository: Repository = RepositoryImpl(RemoteDataSource)
): ViewModel(), LifecycleObserver {

    fun getLiveData() = liveDataObserverCameras

    fun getDoorsFromLocalSource() {
        repository.getDoorsFromLocalStorage()
    }
}