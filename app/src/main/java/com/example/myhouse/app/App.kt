package com.example.myhouse.app

import android.app.Application
import android.content.Context
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.internal.objectstore.OsSyncUser
import io.realm.mongodb.sync.SyncConfiguration

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        initRealm()
    }

    private fun initRealm() {
        Realm.init(this)
        val realmName: String = "MyHouseDB"
        val config = RealmConfiguration.Builder()
            .name(realmName)
            .build()
        Realm.setDefaultConfiguration(config)
    }
}