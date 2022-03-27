package com.example.myhouse.model.realm

import com.example.myhouse.model.rest.rest_entites.DoorDTO
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmOperations(private val config: RealmConfiguration) {

     fun insertDoor(door: DoorDTO) {
        val realm = Realm.getInstance(config)
        realm.executeTransaction { realmTransaction ->
        val newDoor = DoorRealm(
            name = door.name,
            room = door.room,
            id = door.id,
            favorites = door.favorites,
            snapshot = door.snapshot,)
        realmTransaction.insert(newDoor)
        }
         realm.close()
    }

    fun retrieveDoors(): List<DoorRealm> {
        val realm = Realm.getInstance(config)
        val result = realm.where(DoorRealm::class.java).findAll()
        realm.close()
        return result
    }
}