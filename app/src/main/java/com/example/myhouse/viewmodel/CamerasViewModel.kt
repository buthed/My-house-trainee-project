package com.example.myhouse.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.model.AppStateCameras
import com.example.myhouse.model.realm.RealmManager
import com.example.myhouse.model.repository.Repository
import com.example.myhouse.model.repository.RepositoryImpl
import com.example.myhouse.model.rest.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CamerasViewModel(
    val liveDataObserverCameras : MutableLiveData<AppStateCameras> = MutableLiveData(),
    val repository: Repository = RepositoryImpl(RemoteDataSource, RealmManager)
): ViewModel(), LifecycleObserver {

    fun getLiveData() = liveDataObserverCameras

    fun getCamerasFromServer() {
        liveDataObserverCameras.value = AppStateCameras.Loading
        GlobalScope.launch(Dispatchers.IO) {
            liveDataObserverCameras
                .postValue(AppStateCameras.Success(repository.getCamerasFromServer()))
        }
    }
}