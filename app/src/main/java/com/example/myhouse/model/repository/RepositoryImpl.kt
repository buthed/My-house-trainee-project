package com.example.myhouse.model.repository

import android.app.Application
import com.example.myhouse.model.Door
import com.example.myhouse.model.entites.Camera
import com.example.myhouse.model.entites.getCameras
import com.example.myhouse.model.getDoors
import com.example.myhouse.model.realm.DoorRealm
import com.example.myhouse.model.realm.RealmManager
import com.example.myhouse.model.rest.RemoteDataSource
import com.example.myhouse.model.rest.rest_entites.CameraDTO
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import io.reactivex.rxjava3.core.Observable

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val realmManager: RealmManager): Repository {

    override fun getCamerasFromLocalStorage(): List<Camera> = getCameras()
    override fun getDoorsFromLocalStorage(): List<DoorRealm> {
            saveDoorsToLocalStorage()
            return   realmManager.retrieveDoors()
    }

    override fun getDoorsFromServer(): List<DoorDTO> {
        val dto = remoteDataSource.api.getDoorsSource().execute().body()
        return dto?.data!!
    }

    override fun getCamerasFromServer(): List<CameraDTO> {
        val dto = remoteDataSource.api.getCamerasSource().execute().body()
        return dto?.data?.cameras!!
    }

    override fun saveDoorsToLocalStorage() {
        for (i in getDoorsFromServer()) {
            realmManager.insertDoor(i)
        }
    }
}