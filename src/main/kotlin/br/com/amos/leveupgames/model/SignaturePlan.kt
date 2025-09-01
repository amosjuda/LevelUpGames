package br.com.amos.leveupgames.model

class SignaturePlan(
    type: String,
    val monthlyFee: Double,
    val includedGames: Int): Plan(type) {

    override fun getValue(rent: Rent): Double {
        val totalGamesInTheMonth = rent.gamer.monthGames(rent.period.initialDate.monthValue).size+1

        return if (totalGamesInTheMonth <= includedGames){ 0.0 }
        else { super.getValue(rent) }
    }
}
