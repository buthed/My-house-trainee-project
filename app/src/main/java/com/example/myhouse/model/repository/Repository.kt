package com.example.myhouse.model.repository

import com.example.myhouse.model.Camera
import com.example.myhouse.model.Door
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.model.rest.rest_entites.DoorsDataDTO
import retrofit2.Call

interface Repository {
    fun getCamerasFromLocalStorage(): List<Camera>
    fun getDoorsFromLocalStorage(): List<Door>

    fun getDoorsFromServer(): List<DoorDTO>
}