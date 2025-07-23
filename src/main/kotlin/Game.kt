package org.amosjuda

data class Game (val title: String, val cover: String) {
    var description:String? = null

    override fun toString(): String = "My Game:\n(Title='$title',\nCover='$cover',\nDescription='$description')"
}