package org.amosjuda

class Game {
    var title = ""
    var cover = ""
    var description = ""

    override fun toString(): String {
        return "My Game:\n(Title='$title',\n Cover='$cover',\n Description='$description')"
    }
}