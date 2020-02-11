package it.rai.playlistretrofit.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import it.rai.playlistretrofit.R
import it.rai.playlistretrofit.entity.PlaylistEntity

class CustomAdapter (private val context : Activity,
                     private val playlist : List<PlaylistEntity>)
    : ArrayAdapter<PlaylistEntity>(context,
    R.layout.row,playlist) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.row,null,true)

        val textArtista = rowView.findViewById<TextView>(R.id.artista)
        val textTitolo = rowView.findViewById<TextView>(R.id.titolo)
        val textDurata = rowView.findViewById<TextView>(R.id.durata)
        val textAlbum = rowView.findViewById<TextView>(R.id.album)

        textArtista.text = "Artista: " + playlist[position].getArtista()
        textTitolo.text = "Titolo: " +playlist[position].getTitolo()
        textDurata.text = "Durata: " + playlist[position].getDurata()
        textAlbum.text = "Album: " + playlist[position].getAlbum()

        return rowView
    }

}