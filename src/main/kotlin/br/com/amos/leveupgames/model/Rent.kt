package br.com.amos.leveupgames.model

data class Rent(
    val gamer: Gamer,
    val game: Game) {

    override fun toString(): String {
        return "${game.title} rented by ${gamer.name}.\n"
    }
}