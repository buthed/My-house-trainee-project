package com.example.myhouse.model

sealed class AppStateCameras{
    data class Success(val camerasData: List<Camera>) : AppStateCameras()
    data class Error(val error: Throwable) : AppStateCameras()
    object Loading : AppStateCameras()
}