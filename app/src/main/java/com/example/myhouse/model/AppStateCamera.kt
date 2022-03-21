package com.example.myhouse.model

sealed class AppStateCamera{
    data class Success(val cameraData: List<Camera>) : AppStateCamera()
    data class Error(val error: Throwable) : AppStateCamera()
    object Loading : AppStateCamera()
}