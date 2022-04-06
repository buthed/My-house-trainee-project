package com.example.myhouse.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.myhouse.base.viewmodel.BaseViewModel
import com.example.myhouse.model.AppState
import com.example.myhouse.model.realm.RealmManager
import com.example.myhouse.model.repository.RepositoryImpl
import com.example.myhouse.model.rest.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DoorsViewModel :
    BaseViewModel(MutableLiveData(),RepositoryImpl(RemoteDataSource, RealmManager)) {

    override fun getDataFromServer() {
        liveDataObserver.postValue(AppState.Loading)
        GlobalScope.launch(Dispatchers.IO) {
            liveDataObserver.postValue(AppState.SuccessDoors(repository.getDoorsFromServer()!!))
        }
    }
}