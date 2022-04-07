package com.example.myhouse.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myhouse.base.viewmodel.BaseViewModel
import com.example.myhouse.model.AppState
import com.example.myhouse.model.realm.RealmManager
import com.example.myhouse.model.repository.RepositoryImpl
import com.example.myhouse.model.rest.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CamerasViewModel :
    BaseViewModel(MutableLiveData(),RepositoryImpl(RemoteDataSource, RealmManager)) {

    override fun getDataFromServer() {
        liveDataObserver.value = AppState.Loading
        CoroutineScope(Dispatchers.IO).launch {
            try {
                liveDataObserver.postValue(AppState.SuccessCameras(repository.getCamerasFromServer()!!))
            } catch (e: Exception) {
                Log.d("Retrofit", "Error $e")
                null
            }
        }
    }
}