package com.example.myhouse.model.repository

import com.example.myhouse.model.Camera
import com.example.myhouse.model.DataDoors

interface Repository {
    fun getCamerasFromLocalStorage(): List<Camera>
    fun getDoorsFromLocalStorage(): List<DataDoors>
}