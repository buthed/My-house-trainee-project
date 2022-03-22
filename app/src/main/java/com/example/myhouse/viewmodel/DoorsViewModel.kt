package com.example.myhouse.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.model.AppStateDoors
import com.example.myhouse.model.AppStateCameras
import com.example.myhouse.model.repository.Repository
import com.example.myhouse.model.repository.RepositoryImpl
import com.example.myhouse.model.rest.RemoteDataSource

class DoorsViewModel(
    val liveDataObserverDoors : MutableLiveData<AppStateDoors> = MutableLiveData(),
    val repository: Repository = RepositoryImpl(RemoteDataSource)
): ViewModel(), LifecycleObserver {

    fun getLiveData() = liveDataObserverDoors

    fun getDoorsFromLocalSource() {
        liveDataObserverDoors.value = AppStateDoors.Loading
        liveDataObserverDoors.value = AppStateDoors.Success(repository.getDoorsFromLocalStorage())
    }
}