package com.example.myhouse.model.repository


import com.example.myhouse.model.Door
import com.example.myhouse.model.entites.Camera
import com.example.myhouse.model.realm.DoorRealm
import com.example.myhouse.model.rest.rest_entites.CameraDTO
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import io.reactivex.rxjava3.core.Observable

interface Repository {
    fun getCamerasFromLocalStorage(): List<Camera>
    suspend fun getDoorsFromLocalStorage(): List<Door>

    fun getDoorsFromServer(): List<DoorDTO>
    fun getCamerasFromServer(): List<CameraDTO>
//    suspend fun saveDoorsToLocalStorage()
}