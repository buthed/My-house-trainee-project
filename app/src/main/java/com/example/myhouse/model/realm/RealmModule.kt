package com.example.myhouse.model.realm

import io.realm.RealmConfiguration

class RealmModule {
    private val realmVersion = 1L

    fun providesRealmConfig(): RealmConfiguration =
        RealmConfiguration.Builder()
            .schemaVersion(realmVersion)
            .build()
}