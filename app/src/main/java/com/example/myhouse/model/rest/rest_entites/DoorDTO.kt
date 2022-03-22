package com.example.myhouse.model.rest.rest_entites

data class DoorsDataDTO(
    val data: List<DoorDTO>
)

data class DoorDTO(
    val name: String,
    val room: String? = null,
    val id: Long,
    val favorites: Boolean,
    val snapshot: String? = null
)