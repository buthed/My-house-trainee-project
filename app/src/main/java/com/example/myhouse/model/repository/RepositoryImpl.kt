package com.example.myhouse.model.repository

import com.example.myhouse.model.*
import com.example.myhouse.model.rest.RemoteDataSource
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.model.rest.rest_entites.DoorsDataDTO
import retrofit2.Call

class RepositoryImpl(private val remoteDataSource: RemoteDataSource): Repository {

    override fun getCamerasFromLocalStorage(): List<Camera> = getCameras()
    override fun getDoorsFromLocalStorage(): List<Door> = getDoors()

    override fun getDoorsFromServer(): Call<DoorsDataDTO> {
        return remoteDataSource.api.getDoors()
    }

}