package com.example.myhouse.model.db

import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

class CameraRealm (
    @Required
    var name: String,
    var snapshot: String,
    var room: String? = null,
    @PrimaryKey
    var id: Long,
    var favorites: Boolean,
    var rec: Boolean
)