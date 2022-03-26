package com.example.myhouse.model.realm

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class DoorRealm(
    @Required
    var name: String? = "",
    var room: String? = null,
    @PrimaryKey
    var id: Long? = 0,
    var favorites: Boolean? = true,
    var snapshot: String? = null
): RealmObject()

open class DoorsDataRealm(
    var data: RealmList<DoorRealm>? = null
): RealmObject()