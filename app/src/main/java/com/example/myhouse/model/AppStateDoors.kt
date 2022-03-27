package com.example.myhouse.model

import com.example.myhouse.model.realm.DoorRealm
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import io.reactivex.rxjava3.core.Observable

sealed class AppStateDoors{
    data class Success(val doorsData: List<DoorRealm>) : AppStateDoors()
    data class Error(val error: Throwable) : AppStateDoors()
    object Loading : AppStateDoors()
}
//sealed class AppStateDoors{
//    data class Success(val doorsData: List<Door>) : AppStateDoors()
//    data class Error(val error: Throwable) : AppStateDoors()
//    object Loading : AppStateDoors()
//}


