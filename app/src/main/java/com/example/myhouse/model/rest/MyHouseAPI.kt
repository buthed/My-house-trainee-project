package com.example.myhouse.model.rest

import API_CAMERAS
import API_DOORS
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.model.rest.rest_entites.DoorsDataDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyHouseAPI {
    @GET(API_CAMERAS)
    fun getCamerasSource() //TODO

    @GET(API_DOORS)
    fun getDoorsSource(
    ) : Call<DoorsDataDTO>
}