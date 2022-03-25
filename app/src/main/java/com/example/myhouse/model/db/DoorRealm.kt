package com.example.myhouse.model.db

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class DoorRealm(
    @Required
    var name: String,
    var room: String? = null,
    @PrimaryKey
    var id: Long,
    var favorites: Boolean,
    var snapshot: String? = null
): RealmObject()