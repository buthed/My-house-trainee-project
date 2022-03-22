package com.example.myhouse.model

sealed class AppStateDoors{
    data class Success(val doorsData: List<Door>) : AppStateDoors()
    data class Error(val error: Throwable) : AppStateDoors()
    object Loading : AppStateDoors()
}