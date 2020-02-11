package it.rai.playlistretrofit.entity

import com.google.gson.annotations.SerializedName

class PlaylistEntity {

    @SerializedName("artista")
    private var artista : String? = null

    @SerializedName("titolo")
    private var titolo : String? = null

    @SerializedName("durata")
    private var durata : String? = null

    @SerializedName("album")
    private var album : String? = null

    @SerializedName("anno")
    private var anno : String? = null

    fun getArtista() : String? { return artista}
    fun getTitolo() : String? { return titolo}
    fun getDurata() : String? { return durata}
    fun getAlbum() : String? { return album}
    fun getAnno() : String? { return anno}

    override fun toString(): String {
        return "Artista: $artista, Titolo: $titolo, Durata: $durata, Album: $album, Anno: $anno"
    }


}