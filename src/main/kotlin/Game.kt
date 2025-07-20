package org.amosjuda

data class Game (val title: String, val cover:String) {
    var description = ""

    override fun toString(): String {
        return "My Game:\n(Title='$title',\n Cover='$cover',\n Description='$description')"
    }
}