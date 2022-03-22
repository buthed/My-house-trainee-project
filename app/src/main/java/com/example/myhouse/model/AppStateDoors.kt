package com.example.myhouse.model

import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.model.rest.rest_entites.DoorsDataDTO
import retrofit2.Call

sealed class AppStateDoors{
    data class Success(val doorsData: List<DoorDTO>) : AppStateDoors()
    data class Error(val error: Throwable) : AppStateDoors()
    object Loading : AppStateDoors()
}
//sealed class AppStateDoors{
//    data class Success(val doorsData: List<Door>) : AppStateDoors()
//    data class Error(val error: Throwable) : AppStateDoors()
//    object Loading : AppStateDoors()
//}


