package com.example.myhouse.base.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.model.AppState
import com.example.myhouse.model.repository.Repository

abstract class BaseViewModel(
    val liveDataObserver : MutableLiveData<AppState>,
    val repository: Repository
): ViewModel(), LifecycleObserver {

    fun getLiveData() = liveDataObserver

    abstract fun getDataFromServer()


    companion object {

    }
}

//TODO добавить абстракцию на адаптер