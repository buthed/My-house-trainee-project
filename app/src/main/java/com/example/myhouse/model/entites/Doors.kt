package com.example.myhouse.model

data class DataDoors (
    val name: String,
    val room: String? = null,
    val id: Long,
    val favorites: Boolean,
    val snapshot: String? = null
)

fun getDoors() = listOf(
    DataDoors("Door1","Earth",1,true, "2"),
    DataDoors("Door2","Earth",1,true, "2"),
    DataDoors("Door3","Earth",1,true, "2"),
    DataDoors("Door4","Earth",1,true, "2"),
)
