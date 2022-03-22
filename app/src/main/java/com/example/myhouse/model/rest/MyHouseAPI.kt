package com.example.myhouse.model.rest

import API_CAMERAS
import API_DOORS
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.model.rest.rest_entites.DoorsDataDTO
import retrofit2.Call
import retrofit2.http.GET

interface MyHouseAPI {
    @GET(API_CAMERAS)
    fun getCameras() //TODO

    @GET(API_DOORS)
    fun getDoors() : Call<DoorsDataDTO>
}