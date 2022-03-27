package com.example.myhouse.model.realm

import com.example.myhouse.model.AppStateDoors
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.realm.Realm
import io.realm.RealmConfiguration

object RealmManager {

    val backgroundThreadRealm : Realm = Realm.getInstance(Realm.getDefaultConfiguration())

     fun insertDoor(door: DoorDTO) {
             backgroundThreadRealm.executeTransactionAsync { realmTransaction ->
                 val newDoor = DoorRealm(
                     name = door.name,
                     room = door.room,
                     id = door.id,
                     favorites = door.favorites,
                     snapshot = door.snapshot,
                 )
                 realmTransaction.insert(newDoor)
             }
             backgroundThreadRealm.close()
    }

    fun retrieveDoors(): List<DoorRealm> {
            val result = backgroundThreadRealm.where(DoorRealm::class.java).findAllAsync()
            return result
    }
}