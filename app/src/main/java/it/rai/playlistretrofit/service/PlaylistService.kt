package it.rai.playlistretrofit.service

import it.rai.playlistretrofit.entity.PlaylistEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface PlaylistService{

    @GET("bZHwBXSxSG?indent=2")
    fun getPlaylist():Call<Map<String,PlaylistEntity>>
}