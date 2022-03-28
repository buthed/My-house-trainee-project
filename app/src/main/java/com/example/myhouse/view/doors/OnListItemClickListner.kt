package com.example.myhouse.view.doors

import com.example.myhouse.model.realm.DoorRealm
import com.example.myhouse.model.rest.rest_entites.DoorDTO

interface OnListItemClickListner {
    fun onItemClick(door: DoorDTO)
}
