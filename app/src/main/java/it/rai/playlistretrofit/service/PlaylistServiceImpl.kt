package it.rai.playlistretrofit.service

import android.app.Activity
import android.app.Application
import android.app.PendingIntent.getActivity
import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.GsonBuilder
import it.rai.playlistretrofit.adapter.CustomAdapter
import it.rai.playlistretrofit.entity.PlaylistEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlaylistServiceImpl (var customAdapter: CustomAdapter?, val context: Activity) {
    private val baseURL = "http://www.json-generator.com/api/json/get/"
    private val GSON = GsonBuilder().setLenient().create()
    private val retrofit = Retrofit
                .Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .build()
    private val service = retrofit.create(PlaylistService::class.java)
    private val call =  service.getPlaylist()
    private var playlistEntity = ArrayList<PlaylistEntity>()

    fun getPlaylistService() {

        customAdapter = CustomAdapter(context,playlistEntity)
        val TAGError = "Service Failed"
        val TAGResponse = "Response"

        call.enqueue(object : Callback<Map<String,PlaylistEntity>>{
            override fun onFailure(call: Call<Map<String,PlaylistEntity>>, t: Throwable) {
               Log.e(TAGError,t.message)
            }

            override fun onResponse(
                call: Call<Map<String,PlaylistEntity>>,
                response: Response<Map<String,PlaylistEntity>>
            )  {
                Log.d(TAGResponse,"Start Service")
                if(response.code() == 200){
                    Log.d(TAGResponse,"Success! 200")
                    Log.d(TAGResponse,"Loading...")
                    Log.d(TAGResponse,"Size List"+response.body()?.size.toString())

                    var iterator = response.body()!!.iterator()

                    for(entry in iterator){
                        //Log.d(TAGResponse,"Entry: " + entry.value)
                        playlistEntity.add(entry.value)
                        customAdapter?.notifyDataSetChanged()
                    }


                    //Log.d(TAGResponse,response.body().toString())


                }

                Log.d(TAGResponse,"End Service")
            }


        })

    }

    fun getPlaylistArray() : List<PlaylistEntity>{
        return playlistEntity
    }



    fun getAdapter() : CustomAdapter?{
        return customAdapter
    }
}