package com.example.myhouse.model

data class DataDoors (
    val name: String,
    val room: String? = null,
    val id: Long,
    val favorites: Boolean,
    val snapshot: String? = null
)
