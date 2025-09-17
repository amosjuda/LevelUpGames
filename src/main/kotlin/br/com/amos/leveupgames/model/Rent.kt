package br.com.amos.leveupgames.model

data class Rent(
    val gamer: Gamer,
    val game: Game,
    val period: Period) {
    val rentValue = gamer.plan.getValue(this)
    var id = 0

    override fun toString(): String {
        return "${game.title} rented by ${gamer.name} for the value of R$ $rentValue \n"
    }
}