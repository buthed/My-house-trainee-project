package com.example.myhouse.model

data class Camera (
    val name: String,
    val snapshot: String,
    val room: String? = null,
    val id: Long,
    val favorites: Boolean,
    val rec: Boolean
)

data class DataCameras (
    val room: List<String>,
    val cameras: List<Camera>
)