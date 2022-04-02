package com.example.myhouse.model

import com.example.myhouse.model.rest.rest_entites.CameraDTO
import com.example.myhouse.model.rest.rest_entites.DoorDTO

sealed class AppState{
    data class SuccessCameras(val camerasData: List<CameraDTO>) : AppState()
    data class SuccessDoors(val doorsData: List<DoorDTO>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}

