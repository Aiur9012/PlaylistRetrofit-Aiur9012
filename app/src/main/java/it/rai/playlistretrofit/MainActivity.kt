package it.rai.playlistretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import it.rai.playlistretrofit.adapter.CustomAdapter
import it.rai.playlistretrofit.entity.PlaylistEntity
import it.rai.playlistretrofit.service.PlaylistServiceImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var customAdapter : CustomAdapter? = null
        val playlistServiceImpl = PlaylistServiceImpl(customAdapter, this)
        val listView = findViewById<ListView>(R.id.list_view)
        playlistServiceImpl.getPlaylistService()
        listView.adapter = playlistServiceImpl.customAdapter



    }
}
