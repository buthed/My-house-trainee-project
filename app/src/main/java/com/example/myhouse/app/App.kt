package com.example.myhouse.app

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

//        val realmName: String = "MyHouseDB"
//        val config = RealmConfiguration.Builder()
//            .name(realmName)
//            .schemaVersion(0)
//            .build()
//        val backgroundThreadRealm : Realm = Realm.getInstance(config)
    }
}