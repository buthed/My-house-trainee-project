package com.example.myhouse.model.repository


import com.example.myhouse.model.Door
import com.example.myhouse.model.entites.Camera
import com.example.myhouse.model.rest.rest_entites.CameraDTO
import com.example.myhouse.model.rest.rest_entites.DoorDTO

interface Repository {
    fun getCamerasFromLocalStorage(): List<Camera>
    fun getDoorsFromLocalStorage(): List<Door>

    fun getDoorsFromServer(): List<DoorDTO>
    fun getCamerasFromServer(): List<CameraDTO>
}