package com.example.myhouse.model.repository

import com.example.myhouse.model.Camera
import com.example.myhouse.model.DataDoors
import com.example.myhouse.model.getCameras
import com.example.myhouse.model.getDoors

class RepositoryImpl: Repository {

    override fun getCamerasFromLocalStorage(): List<Camera> = getCameras()
    override fun getDoorsFromLocalStorage(): List<DataDoors> = getDoors()

}